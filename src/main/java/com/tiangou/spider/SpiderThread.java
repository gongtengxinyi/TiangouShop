package com.tiangou.spider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderThread extends Thread {
public  String url="http://news.sina.com.cn/";
	@Override
	public synchronized void start() {
		super.start();
		while(true)
		{
try {
	Document document = getDocument(QueueUrl.urlLinkList.getFirst());
	writeOnDoc(document.select("a[href]"));
	QueueUrl.urlLinkList.removeFirst();
} catch (Exception e) {
	// TODO: handle exception
	QueueUrl.urlLinkList.removeFirst();
	Document document = getDocument(QueueUrl.urlLinkList.getFirst());
	writeOnDoc(document.select("a[href]"));
	QueueUrl.urlLinkList.removeFirst();
}
		
		}
	
	}
	public String writeOnDoc(Elements elements)
	{
		FileWriter fileWirter=null;
		try {
			fileWirter = new FileWriter("H://URL.doc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Element element : elements) {
			if(element.attr("href").contains("javascript"))
			{
				continue;
			}
			if(!element.attr("href").startsWith("http:"))
			{
				continue;
			}
			try {
				if(!QueueUrl.urlLinkList.contains(element.attr("href")))
				{
					QueueUrl.urlLinkList.addLast(element.attr("href"));
				}
				
				fileWirter.write(element.attr("href")+":"+element.text()+"\n");	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return QueueUrl.urlLinkList.getFirst();
	}
public Document getDocument(String url)
{
	Document document=null;
	try {
		document = Jsoup.connect(url).get();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		QueueUrl.urlLinkList.removeFirst();
		 Jsoup.connect(QueueUrl.urlLinkList.getFirst());
	}
	if(document!=null)
	{
		return document;
	}
	return null;
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}

}
