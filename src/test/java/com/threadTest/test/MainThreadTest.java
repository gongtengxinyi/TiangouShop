package com.threadTest.test;

import com.tiangou.spider.QueueUrl;
import com.tiangou.spider.SpiderThread;

public class MainThreadTest {
 public static void main(String[] args) {
	 QueueUrl url=new QueueUrl();
	new SpiderThread().start();

	
}
}
