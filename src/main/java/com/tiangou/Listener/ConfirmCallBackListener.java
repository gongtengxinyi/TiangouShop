package com.tiangou.Listener;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;

import com.tiangou.entity.Indent;
import com.tiangou.util.JsonUtils;
/**
 * // ֻȷ����������Ϣ���ͳɹ����������Ƿ���ɹ�������֤
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