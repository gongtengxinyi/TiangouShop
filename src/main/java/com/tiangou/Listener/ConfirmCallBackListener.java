package com.tiangou.Listener;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;

import com.tiangou.entity.Indent;
import com.tiangou.util.JsonUtils;
/**
 * // 只确认生产者消息发送成功，消费者是否处理成功不做保证
 * @author Zlyj
 *
 */
public class ConfirmCallBackListener implements ConfirmCallback{  
    public void confirm(CorrelationData correlationData, boolean ack) {
		// TODO Auto-generated method stub
    	  System.out.println("confirm--:correlationData:"+correlationData+",ack:"+ack);  
    	  Indent indent = JsonUtils.jsonToPojo(correlationData.getId(), Indent.class);
  System.err.println(indent);
	}

}  