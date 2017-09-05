package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		JedisPool pool = (JedisPool) applicationContext.getBean("jedisPool");
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			/**
			 * �����ֹ�����ʵ��
			 * ����˼·;shujuku �½�һ���ֶ�
			 * version���ݰ汾��Ȼ��û����ʱ�������м�⣬����汾�Ų����ϣ�Ȼ��Ͳ���������
			 * @return
			 */
			//@RequestMapping("/testVersion")
			//@ResponseBody
			//public  Map<String,String> getTestVersion()
			//{
//				String customerId="1";
//				String account="11";
//				String version="1";
//				//ģ�����߳�
			//int i =customerService.updateAccount(customerId, account,version);
			//int a=customerService.updateAccount(customerId, account,version);
			//int b=customerService.updateAccount(customerId, account,version);
			//int c=customerService.updateAccount(customerId, account,version);
			//int d=customerService.updateAccount(customerId, account,version);
			//int e=customerService.updateAccount(customerId, account,version);
			//System.out.println(i+".."+a+"..."+b+"..."+c+"..."+d+"..."+e);
			//Map<String,String> map=new HashMap<String, String>();
			//String value=i+".."+a+"..."+b+"..."+c+"..."+d+"..."+e;
			//map.put("status", value);
			//
			//return map;
			//}

//			Map<String, String> map = new HashMap<String, String>();
//			map.put("name", "dingjianlei");
//			map.put("age", "132");
//			map.put("age", "3333");
//			map.put("mobile", "13687672481");
//			map.put("address", "ɽ���ൺ��");
//			jedis.hmset("user", map);
//			List<String> hmget = jedis.hmget("user", "age", "mobile", "address");
//			for (String string : hmget) {
//			}
//			System.out.println(jedis.hdel("user", "address"));
//			System.out.println(jedis.hlen("user"));
//			System.out.println(jedis.hexists("user", "age"));
//			System.out.println(jedis.hexists("user", "address"));
//			System.out.println(jedis.exists("user"));
//			Set<String> hkeys = jedis.hkeys("user");
//			for (String string : hkeys) {
//				System.out.println(string);
//			}
//			  List<String> hvals = jedis.hvals("user");
//			for (String string : hvals) {
//				System.out.println(string);		
//			}
		jedis.lpush("javaee", "stuts");
		jedis.lpush("javaee", "hibernate");
		jedis.lpush("javaee", "stuts2");
		jedis.lpush("javaee","SPRING");
		List<String> lrange = jedis.lrange("javaee", 0, -1);
			for (String string : lrange) {
				System.out.println(string);
			}
			
//			List<String> rrange = jedis.rrange("javaee", 0, -1);
//			for (String string : lrange) {
//				System.out.println(string);
//			}
			jedis.del("javaee");
			jedis.lpush("javaee", "stuts");
			jedis.lpush("javaee", "hibernate");
			jedis.lpush("javaee", "stuts2");
			jedis.lpush("javaee","SPRING");
			jedis.rpush("javaee", "1");
			jedis.rpush("javaee", "2");
			jedis.rpush("javaee", "3");
			jedis.rpush("javaee","4");
			
			List<String> lrange1 = jedis.lrange("javaee", 0, -1);
				for (String string : lrange1) {
					System.out.println(string);
				}
//			jedis.sadd("user2", "1","2","3","4");
//			jedis.sadd("user", "1");
//			jedis.sadd("user", "2");
//			jedis.sadd("user", "3");
//			jedis.sadd("user", "4");
			
//			jedis.srem("user2", "1");
//			Set<String> smembers = jedis.smembers("user2");
//		for (String string : smembers) {
//			System.out.println(string);
//		}
//		System.out.println(jedis.sismember("user2", "5"));
//		System.out.println(jedis.sismember("user2", "3"));
//		System.out.println(jedis.srandmember("user2"));
//		System.out.println(jedis.scard("user2"));
			jedis.zadd("indent", 100, "java");
			Map<String,Double	> map=new HashMap<String, Double>();
			map.put("c",90.0);
			map.put("x++",101.0);
			jedis.zadd("indent", map);
			
//			Set<String> zrange = jedis.zrange("indent", 0, -1);
//			for (String string : zrange) {
//				System.out.println(string);	
//			}
//			Set<String> zrange = jedis.zrangeByScore("indent",90.0,98.0);
//			for (String string : zrange) {
//				System.out.println(string);	
//			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (jedis != null) {
				// �ر�����
				jedis.close();
			}
		}
	}
}
