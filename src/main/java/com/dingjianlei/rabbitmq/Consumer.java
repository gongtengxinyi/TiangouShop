package com.dingjianlei.rabbitmq;

import java.io.IOException;

import com.mchange.v2.resourcepool.TimeoutException;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Consumer {
	private final static String QUEUE_NAME = "queue1";

	public static void main(String[] args) throws IOException, TimeoutException {
		// �������ӹ���
		ConnectionFactory factory = new ConnectionFactory();
		// ����RabbitMQ��ַ
		factory.setHost("192.168.146.146");
		factory.setUsername("hxb");
		factory.setPassword("hxb");
		factory.setPort(5672);
		// ����һ���µ�����
		Connection connection = factory.newConnection();
		// ����һ��ͨ��
		Channel channel = connection.createChannel();
		// ����Ҫ��ע�Ķ���
		channel.queueDeclare(QUEUE_NAME, false, false, true, null);
		// DefaultConsumer��ʵ����Consumer�ӿڣ�ͨ������һ��Ƶ����
		// ���߷�����������Ҫ�Ǹ�Ƶ������Ϣ�����Ƶ��������Ϣ���ͻ�ִ�лص�����handleDelivery
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("Customer Received '" + message + "'");
			}
		};
		// �Զ��ظ�����Ӧ�� -- RabbitMQ�е���Ϣȷ�ϻ���
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}