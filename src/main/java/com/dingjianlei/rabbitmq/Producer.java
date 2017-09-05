package com.dingjianlei.rabbitmq;

import java.io.IOException;

import com.mchange.v2.resourcepool.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
public class Producer {
	public static final String queue_name="queue1";
public static void main(String[] args)   throws IOException, TimeoutException{
    //�������ӹ���
    ConnectionFactory factory = new ConnectionFactory();
    //����RabbitMQ�����Ϣ
    factory.setHost("192.168.146.146");
  factory.setUsername("hxb");
  factory.setPassword("hxb");
  factory.setPort(5672);
    //����һ���µ�����
    Connection connection = factory.newConnection();
    //����һ��ͨ��
    Channel channel = connection.createChannel();
    //  ����һ������        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String message = "�ҷ�����";
    //������Ϣ��������
//ע1queueDeclare��һ��������ʾ�������ơ��ڶ�������Ϊ�Ƿ�־û���true��ʾ�ǣ����н��ڷ���������ʱ���棩������������Ϊ�Ƿ��Ƕ�ռ���У������߿���ʹ�õ�˽�ж��У��Ͽ����Զ�ɾ���������ĸ�����Ϊ�����������߿ͻ������ӶϿ�ʱ�Ƿ��Զ�ɾ�����С����������Ϊ���е���������
//ע2basicPublish��һ������Ϊ���������ơ��ڶ�������Ϊ����ӳ���·��key������������Ϊ��Ϣ���������ԡ����ĸ�����Ϊ������Ϣ������
    channel.basicPublish("", queue_name, null, message.getBytes("UTF-8"));
    //�ر�ͨ��������
    channel.close();
    connection.close();
}
}
