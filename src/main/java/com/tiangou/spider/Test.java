package com.tiangou.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test {
public static void main(String[] args) throws IOException {
	Document document=Jsoup.connect("http://www.zlyijia.com/").get();
	System.out.println(document);
}
}
