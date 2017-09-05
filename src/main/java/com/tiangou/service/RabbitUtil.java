package com.tiangou.service;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 */
@Service
public class RabbitUtil {
	   private final RabbitTemplate rabbitTemplate;  
	   
	    @Autowired  
	    public RabbitUtil(RabbitTemplate rabbitTemplate){  
	        this.rabbitTemplate = rabbitTemplate;  
	    }  	  
    public <T> void sendReliable(String exchange, T message) {
        //ʵ�ֽ�messageͨ��jsonת��&��������
        //convertAndSend(String exchange, String routingKey, Object message, MessagePostProcessor messagePostProcessor, CorrelationData correlationData)
        rabbitTemplate.convertAndSend(exchange, "queueTestKey", message, new MessagePostProcessor() {
            //ʵ��message��������ʵ��
            public Message postProcessMessage(Message message) throws AmqpException {
                //������Ϣ��������Ϣ&���÷���ģʽ��PERSISTENT:�����ģ�
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        }, new CorrelationData(String.valueOf(message)));
    }
}
