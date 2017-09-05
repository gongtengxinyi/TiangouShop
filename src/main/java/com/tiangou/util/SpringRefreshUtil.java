package com.tiangou.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tiangou.cache.StartUpListenerSpring;

public class SpringRefreshUtil {
	public static void refreshSpring()
	{
		 AbstractApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");            
         ac.start(); //´¥·¢ContextStartedEventÊÂ¼þ  
	}

}
