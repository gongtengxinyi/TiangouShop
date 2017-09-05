package com.tiantou.springTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUnitTest {
public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
	  
    context.start();  
            
}
}
