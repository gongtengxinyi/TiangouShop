package com.tiangou.util;

import java.security.MessageDigest;

public class MD5Tools {
	 public final static String MD5(String pwd) {  
	        //���ڼ��ܵ��ַ�  
	        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
	                'A', 'B', 'C', 'D', 'E', 'F' };  
	        try {  
	            //ʹ��ƽ̨��Ĭ���ַ������� String ����Ϊ byte���У���������洢��һ���µ� byte������  
	            byte[] btInput = pwd.getBytes();  
	               
	            //��ϢժҪ�ǰ�ȫ�ĵ����ϣ�����������������С�����ݣ�������̶����ȵĹ�ϣֵ��  
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
	               
	            //MessageDigest����ͨ��ʹ�� update�����������ݣ� ʹ��ָ����byte�������ժҪ  
	            mdInst.update(btInput);  
	               
	            // ժҪ����֮��ͨ������digest����ִ�й�ϣ���㣬�������  
	            byte[] md = mdInst.digest();  
	               
	            // ������ת����ʮ�����Ƶ��ַ�����ʽ  
	            int j = md.length;  
	            char str[] = new char[j * 2];  
	            int k = 0;  
	            for (int i = 0; i < j; i++) {   //  i = 0  
	                byte byte0 = md[i];  //95  
	                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5   
	                str[k++] = md5String[byte0 & 0xf];   //   F  
	            }  
	               
	            //���ؾ������ܺ���ַ���  
	            return new String(str);  
	               
	        } catch (Exception e) {  
	            return null;  
	        }  
	    } 
	 public static void main(String[] args) {
		 String s=MD5Tools.MD5("123");
		 System.out.println(s);
	}
}
