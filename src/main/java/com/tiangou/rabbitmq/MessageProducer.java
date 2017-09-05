package com.tiangou.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MessageProducer {
	@Autowired
	private AmqpTemplate amqpTemplate;

	
	public  void sendMessage(Object message){
	  amqpTemplate.convertAndSend("queueTestKey",message);
	System.out.println("ЩњВњеп"+message);
	}
}
