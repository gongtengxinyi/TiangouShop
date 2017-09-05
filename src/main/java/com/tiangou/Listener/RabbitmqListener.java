package com.tiangou.Listener;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;
import com.tiangou.entity.Indent;
import com.tiangou.util.JsonUtils;

public class RabbitmqListener implements ChannelAwareMessageListener {
	public void onMessage(Message message, Channel channel) {
		// TODO Auto-generated method stub
		try {
			byte[] body = message.getBody();
		Indent indent =JsonUtils.jsonToPojo(new String(body,"UTF-8"), Indent.class);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			System.out.println(body);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();// TODO 业务处理
			try {
				channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
