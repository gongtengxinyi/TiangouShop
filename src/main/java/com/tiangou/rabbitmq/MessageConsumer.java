package com.tiangou.rabbitmq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;
@Component
public class MessageConsumer implements MessageListener {
	
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		
	System.out.println("Ïû·ÑÕß"+message);
	}

}
