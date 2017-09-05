package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransaction {
	public static void main(String[] args) {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		TransactionService bean = (TransactionService)applicationContext.getBean("transactionService");
//		List <Customer>list=new ArrayList<Customer>();
//		Customer customer=new Customer();
//		Customer customer2=new Customer();
//		customer.setAddress("dd");
//		customer.setCustomerid("3333");
//		customer2.setAddress("1dd");
//		customer2.setCustomerid("13333");
//		
//		list.add(customer);
//		list.add(customer2);
//		bean.insertCustomer(list);
	}
	
}
