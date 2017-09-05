package com.tiangou.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.Constants;
import com.tiangou.util.BlogConstants;
import com.tiangou.util.CommonUtils;
import com.tiangou.util.HttpClientUtil;
import com.tiangou.util.JsonUtils;

public class ToutiaoSpiderTest {

	/**
	 * 201 6 11 20 dingjianlie
	 * 
	 * @param args
	 * @throws IOException
	 *             toutiao 爬虫
	 */
	public static void main(String[] args) throws IOException {
		JSONObject parseObject = getJSONObject(0);
		if (parseObject.getBooleanValue("has_more")) {

			long nextTime = parseObject.getJSONObject("next").getLongValue("max_behot_time");
			JSONArray jsonArray = parseObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject json = (JSONObject) jsonArray.get(i);
				String articleUrl = json.getString("source_url");
				String authorUrl = json.getString("media_url");
				connectSubPage(authorUrl, 0);
			}
			execute(nextTime);
		}

	}

	/**
	 * 连接头条号
	 * 
	 * @param sqlSession
	 * @param authorId
	 * @param authorUrl
	 * @param hotTime
	 */
	private static void connectSubPage(String authorUrl, long hotTime) {
		String media_id = authorUrl.replace("http://toutiao.com/m", "");
		media_id = media_id.replace("/", "");
		JSONObject json = getSubPage(media_id, hotTime);
		if (json != null && json.getIntValue("has_more") == 1) {
			long time = json.getJSONObject("next").getLongValue("max_behot_time");
			JSONArray data = json.getJSONArray("data");
			for (int i = 0; i < data.size(); i++) {
				try {
					JSONObject obj = (JSONObject) data.get(i);
					String title = obj.getString("title");// 标题
					String readCount = obj.getString("go_detail_count");// 阅读次数
					if (readCount.contains("万")) {
						readCount = readCount.replace("万", "");
						readCount = Double.parseDouble(readCount) * 10000 + "";
					}
					int imageCount = 0;
					if (obj.getJSONArray("image_list") != null) {
						imageCount = obj.getJSONArray("image_list").size();// 展示图片数
					}
					int type = BlogConstants.ARTICLE;// 文章类型
					if (obj.getBooleanValue("has_video")) {
						type = BlogConstants.VIDEO;
					} else if (obj.getBooleanValue("has_gallery")) {
						type = BlogConstants.GALLERY;
					}
					String commentCount = obj.getString("comments_count");// 评论次数
					if (commentCount != null && commentCount.contains("万")) {
						commentCount = commentCount.replace("万", "");
						commentCount = Double.parseDouble(commentCount) * 10000 + "";
					}
					Date publishTime = null;// 发布时间
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						publishTime = sdf.parse(obj.getString("datetime"));
					} catch (ParseException e) {
						publishTime = obj.getDate("datatime");
					}
					int galleryCount = obj.getIntValue("gallery_pic_count");// 相集图片数量
					String articleUrl = obj.getString("source_url");
					String section = null;
					if (type == BlogConstants.VIDEO) {
						section = "视频";
					}
					if (type == BlogConstants.GALLERY) {
						section = "图片";
					}
					String tag = null;
					if (Double.parseDouble(readCount) >= 10000) {// 阅读超过1万的
						if (type == BlogConstants.ARTICLE && StringUtils.isNotEmpty(articleUrl)) {
							// 访问文章页面，获取其他信息
							Map<String, Object> articleInfo = getArticleInfo(articleUrl);
							if (articleInfo != null) {
								section = articleInfo.get("section") == null ? ""
										: articleInfo.get("section").toString();
								tag = articleInfo.get("tag") == null ? "" : articleInfo.get("tag").toString();
							}
						}
						Map<String, Object> articleMap = new HashMap<String, Object>();
						articleMap.put("title", title);
						articleMap.put("readcount", readCount);
						articleMap.put("showimgcount", imageCount);
						articleMap.put("type", type);
						articleMap.put("commentcount", commentCount);
						articleMap.put("publishtime", publishTime);
						articleMap.put("gallerycount", galleryCount);
						articleMap.put("section", section);
						articleMap.put("tagword", tag);

					}
				} catch (Exception e) {
					System.out.println("error:" + e.getMessage());
				}
			}
			connectSubPage(authorUrl, time);
		}
	}

	public static Map<String, Object> getArticleInfo(String url) {
		if (url.contains("/item/")) {
			url = url.replace("tem/", "");
		}
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Connection connect = Jsoup.connect(url);
			Document document;
			document = connect.get();
			Element header = document.getElementById("header");
			Elements divs = header.getElementsByClass("chinese-tag");
			String section = "";
			if (divs != null && divs.size() > 0) {
				section = divs.get(0).getElementsByTag("a").get(1).text();
			}
			Elements tagElements = document.getElementsByClass("label-list");
			Elements tags = null;
			if (tagElements != null && tagElements.size() > 0) {
				tags = tagElements.get(0).getElementsByTag("a");
			}
			String tag = "";
			if (tags != null) {
				for (Element t : tags) {
					tag += "(" + t.text() + ")";
				}
			}
			map.put("section", section);
			map.put("tag", tag);
			return map;
		} catch (IOException e) {
			System.err.println("访问文章页失败:" + url + "  原因" + e.getMessage());
		}
		return null;
	}

	/**
	 * 寻找xiayitiao记录
	 * 
	 * @param hottime
	 */
	public static void execute(long hottime) {
		JSONObject json = null;
		try {
			json = getJSONObject(hottime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (json != null) {
			if (json.getBooleanValue("has_more")) {
				long time = json.getJSONObject("next").getLongValue("max_behot_time");
				JSONArray data = json.getJSONArray("data");
				for (int i = 0; i < data.size(); i++) {
					try {
						JSONObject obj = (JSONObject) data.get(i);
						String author = obj.getString("source");// 头条号名称
						String authorUrl = obj.getString("media_url");// 头条号主页url
						// 入库
						if (StringUtils.isNotEmpty(author) && StringUtils.isNotEmpty(authorUrl)) {
							Map<String, Object> authorMap = new HashMap<String, Object>();
							authorMap.put("id", 0);
							authorMap.put("title", author);
							System.out.println("访问头条号：" + author + ",url:" + authorUrl);
							connectSubPage(authorUrl, 0l);
						}
					} catch (Exception e) {
						System.out.println("error:" + e.getMessage());
					}
				}
				execute(time);
			} else {
				System.out.println("----------查询不到任何文章了，睡一个小时再抓----------");
				try {
					Thread.sleep(1000 * 60 * 60);
				} catch (InterruptedException e) {
					System.out.println("@_@被吵醒了，接着再抓吧@_@");
					execute(0);
				}
				System.out.println("----------睡醒了，开始抓----------");
				execute(0);
			}
		}
	}

	/**
	 * 访问头条号作者
	 * 
	 * @param media_id
	 * @param hotTime
	 * @return
	 */
	public static JSONObject getSubPage(String media_id, long hotTime) {
		String url = BlogConstants.TOUTIAOHAOURL + "&media_id=" + media_id + "&max_behot_time=" + hotTime;
		JSONObject param = null;
		param = CommonUtils.getUrlParam();
		url += "&as=" + param.get("as") + "&cp=" + param.get("cp");
		try {
			URL httpUrl = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(httpUrl.openStream(), "UTF-8"));
			String line = null;
			String content = "";
			while ((line = in.readLine()) != null) {
				content += line;
			}
			in.close();
			return JSONObject.parseObject(content);
		} catch (Exception e) {
			System.err.println("访问子页面失败:" + url);
			e.printStackTrace();
		}
		return null;
	}

	public static JSONObject getJSONObject(long time) {
		String url = BlogConstants.TOUTIAOURL + "&max_behot_time=" + time + "&max_behot_time_tmp=" + time;
		JSONObject param = CommonUtils.getUrlParam();
		url += "&as=" + param.get("as") + "&cp=" + param.get("cp");
		String doPost = HttpClientUtil.doPost(url);
		return JSONObject.parseObject(doPost);

	}
}
