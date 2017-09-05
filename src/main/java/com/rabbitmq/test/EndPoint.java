package com.rabbitmq.test;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



public abstract class EndPoint {
	   
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;
     
    public EndPoint(String endpointName) throws IOException{
         this.endPointName = endpointName;
         
         //Create a connection factory
         ConnectionFactory factory = new ConnectionFactory();
         
         //hostname of your rabbitmq server
         factory.setHost("192.168.146.128");
         factory.setPort(5672);
         factory.setUsername("hxb");
         factory.setPassword("hxb");
         
         //getting a connection
         connection = factory.newConnection();
         
         //creating a channel
         channel = connection.createChannel();
         
         //declaring a queue for this channel. If queue does not exist,
         //it will be created on the server.
         channel.queueDeclare(endpointName, false, false, false, null);
    }
     
     
    /**
     * �ر�channel��connection�����Ǳ��룬��Ϊ�������Զ����õġ�
     * @throws IOException
     */
     public void close() throws IOException{
         this.channel.close();
         this.connection.close();
     }
}
