package com.designModel.test;

public class AbstractFactoryTest {
	 public static void main(String[] args) {  
	        Provider provider = new MailSenderFactory();  
	        Sender sender = provider.produce();  
	        sender.Send();  
	    }  

}
