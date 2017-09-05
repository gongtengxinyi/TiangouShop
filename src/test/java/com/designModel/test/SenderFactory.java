package com.designModel.test;

import org.apache.commons.lang3.StringUtils;

import com.tiangou.util.StringUtil;

public class SenderFactory {
/*	普通工厂模式
 * public static final String MAIL="mail";
	public static final String SMS="sms";
               public Sender produce(String type)
               {
            	   if(StringUtils.equals(type,MAIL))
            	   {
            		   return new MailSender();
            	   }

            	   else if(StringUtils.equals(type,SMS))
            	   {
            		   return new SmsSender();
            	   }
            	   else
            	   {
            		   System.out.println("请输入正确类型");
            		   return null;
            	   }
               }*/
	
	/**
	 * 多个工厂模式
	 * 
	 */
	/*public Sender getMailSender()
	{
		return new MailSender();
	}
	public Sender getSmsSender()
	{
		return new SmsSender();
	}*/
	
	/**
	 * 静态工厂模式
	 * 
	 */
	public static Sender getMailSender()
	{
		return new MailSender();
	}
	public static Sender getSmsSender()
	{
		return new SmsSender();
	}
}




