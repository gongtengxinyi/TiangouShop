package com.tiangou.spider;

import java.util.LinkedList;

public class QueueUrl {
public static LinkedList<String> urlLinkList=new LinkedList<String>();
 public QueueUrl()
 {
	 urlLinkList.add("http://news.sina.com.cn/");
 }
 public void enQueue(String obj)
 {
	 urlLinkList.add(obj);
 }
 public void deQueue(String obj)
 {
	 urlLinkList.removeFirst();
 }
 public boolean isEmpty()
 {
	 return urlLinkList.isEmpty();
 }
 public boolean isContains(String obj)
 {
	 return urlLinkList.contains(obj);
 }
}
