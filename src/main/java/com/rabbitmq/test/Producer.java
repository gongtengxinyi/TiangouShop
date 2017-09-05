package com.rabbitmq.test;



import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;


 
 
/**
 * 
 * 功能概要：消息生产者
 * 
 * @author dingjianlei
 * @since  2016年1月11日
 */
public class Producer extends EndPoint{
     
    public Producer(String endPointName) throws IOException{
        super(endPointName);
    }
 
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }  
}
