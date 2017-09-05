package com.jsoup.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
public static void main(String[] args) {
Document document=null;
try {
	document = Jsoup.connect("http://www.zlyijia.com/").get();
	Elements selectOne = document.select("a[href]");
	Map<String,String> urlMap=new HashMap<String,String>();
	for (Element element : selectOne) {
		urlMap.put(element.attr("href"),element.text());
		System.out.println(element.text());
	}
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}
