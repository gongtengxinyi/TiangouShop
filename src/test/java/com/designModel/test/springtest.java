package com.designModel.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class springtest {
	 public static String delHTMLTag(String htmlStr){  
	        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //����script��������ʽ  
	        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //����style��������ʽ  
	        String regEx_html="<[^>]+>"; //����HTML��ǩ��������ʽ  
	         
	        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);  
	        Matcher m_script=p_script.matcher(htmlStr);  
	        htmlStr=m_script.replaceAll(""); //����script��ǩ  
	         
	        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);  
	        Matcher m_style=p_style.matcher(htmlStr);  
	        htmlStr=m_style.replaceAll(""); //����style��ǩ  
	         
	        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);  
	        Matcher m_html=p_html.matcher(htmlStr);  
	        htmlStr=m_html.replaceAll(""); //����html��ǩ  
	  
	       return htmlStr.trim(); //�����ı��ַ���  
	    }   
	      
	    /** 
	    *ȥ���ַ��������html���롣<br> 
	    *Ҫ������Ҫ�淶���������С�ں�Ҫ����,����ᱻ������ɱ�� 
	    *�� 
	    *@paramcontent 
	    *�������������� 
	    *@returnȥ��������� 
	    */  
	public static String stripHtml(String content){  
	    //<p>�����滻Ϊ����  
	    content=content.replaceAll("<p.*?>","");  
	    //<br><br/>�滻Ϊ���� ��  
	    content=content.replaceAll("<brs*/?>","");  
	    //ȥ��������<>֮��Ķ���   
	    content=content.replaceAll("<.*?>","");  
	    //��ԭHTML//content=HTMLDecoder.decode(content);   
	    return content;  
	    }  
	  
	public static String replaceHtml(String html){   
	    String regEx="<.+?>"; //��ʾ��ǩ   
	    Pattern p=Pattern.compile(regEx);   
	    Matcher m=p.matcher(html);   
	    String s=m.replaceAll("");   
	    return s;   
	}  
	  
	    public static void main(String[] args) {  
	      String s = "<!DOCTYPE html PUBLIC ''-//WAPFORUM//DTD XHTML Mobile 1.0//EN'' ''http://www.wapforum.org/DTD/xhtml-mobile10.dtd''><html xmlns=''http://www.w3.org/1999/xhtml''><head><meta http-equiv=''Content-Type'' content=''text/html; charset=utf-8'' /><meta id=''viewport'' name=''viewport'' content=''width=320,initial-scale=1,maximum-scale=1,user-scalable=0;'' /><title>����-��������Ϻ�����ָ��</title><link href=''Pub/css/layout.css'' rel=''stylesheet'' type=''text/css'' /><link href=''Pub/css/public.css'' rel=''stylesheet'' type=''text/css'' /><script type=''text/javascript'' src=''Pub/js/jquery-1.6.1.min.js''></script><script type=''text/javascript'' src=''Pub/js/base.js''></script></head><body><div id=''Layout''><div class=''titleBar''><h1 id= ''1''>1. ����</h1></div><div class=''mainContainer''><p>������(Behcet's disease��BD)�ֳƱ������ز�����-��-��ֳ���������ȡ� </p></div></div></body></html>";  
	      delHTMLTag(s);  
	    System.out.println(delHTMLTag(s));  
	    }  
	  
}
