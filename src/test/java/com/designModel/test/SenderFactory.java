package com.designModel.test;

import org.apache.commons.lang3.StringUtils;

import com.tiangou.util.StringUtil;

public class SenderFactory {
/*	��ͨ����ģʽ
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
            		   System.out.println("��������ȷ����");
            		   return null;
            	   }
               }*/
	
	/**
	 * �������ģʽ
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
	 * ��̬����ģʽ
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




