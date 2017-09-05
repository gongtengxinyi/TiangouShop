package com.tiangou.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelHtml {
	 public static String delHTMLTag(String htmlStr){  
	        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式  
	        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式  
	        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式  
	         
	        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);  
	        Matcher m_script=p_script.matcher(htmlStr);  
	        htmlStr=m_script.replaceAll(""); //过滤script标签  
	         
	        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);  
	        Matcher m_style=p_style.matcher(htmlStr);  
	        htmlStr=m_style.replaceAll(""); //过滤style标签  
	         
	        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);  
	        Matcher m_html=p_html.matcher(htmlStr);  
	        htmlStr=m_html.replaceAll(""); //过滤html标签  
	  
	       return htmlStr.trim(); //返回文本字符串  
	    }   
	      
	    /** 
	    *去掉字符串里面的html代码。<br> 
	    *要求数据要规范，比如大于小于号要配套,否则会被集体误杀。 
	    *　 
	    *@paramcontent 
	    *　　　　　内容 
	    *@return去掉后的内容 
	    */  
	public static String stripHtml(String content){  
	    //<p>段落替换为换行  
	    content=content.replaceAll("<p.*?>","");  
	    //<br><br/>替换为换行 　  
	    content=content.replaceAll("<brs*/?>","");  
	    //去掉其它的<>之间的东西   
	    content=content.replaceAll("<.*?>","");  
	    //还原HTML//content=HTMLDecoder.decode(content);   
	    return content;  
	    }  
	  
	public static String replaceHtml(String html){   
	    String regEx="<.+?>"; //表示标签   
	    Pattern p=Pattern.compile(regEx);   
	    Matcher m=p.matcher(html);   
	    String s=m.replaceAll("");   
	    return s;   
	}  
	  
	  
}
