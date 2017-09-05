package com.tiangou.util;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

	private static JedisPool jedisPool = null;
	private static Log logger = LogFactory.getLog(RedisUtil.class);
	/**
	 * ��ʼ��Redis���ӳ�
	 */
	static {
		try {
			Properties properties = new Properties();
			properties = PropertiesLoaderUtils.loadAllProperties("redis.properties");//�������ļ��ж�ȡ������Ϣ

			JedisPoolConfig config = new JedisPoolConfig();
			String host = properties.getProperty("redis.host");//����
			int port = Integer.parseInt(properties.getProperty("redis.port"));//�˿�
			int timeout = Integer.parseInt(properties.getProperty("redis.timeout"));//��ʱ����
			String auth = properties.getProperty("redis.password");//����
			int maxTotal =Integer.parseInt(properties.getProperty("redis.pool.maxTotal"));//���������
			int maxIdle = Integer.parseInt(properties.getProperty("redis.pool.maxIdle"));//������������
			int minIdle = Integer.parseInt(properties.getProperty("redis.pool.minIdle"));//��С����������
			long maxWaitMillis =Long.parseLong( properties.getProperty("redis.pool.maxWaitMillis"));//���ȴ�������
			boolean testOnBorrow = properties.getProperty("redis.pool.testOnBorrow")=="true"?true:false ;
			boolean testOnReturn = properties.getProperty("redis.pool.testOnReturn")=="true"?true:false ;
			
			config.setMaxTotal(maxTotal);
			config.setMaxIdle(maxIdle);
			config.setMinIdle(minIdle);
			config.setMaxWaitMillis(maxWaitMillis);
			config.setTestOnBorrow(testOnBorrow);
			config.setTestOnReturn(testOnReturn);
			
			jedisPool = new JedisPool(config, host, port, timeout, auth);//����jedis���ӳ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡJedisʵ��
	 * 
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();//��ȡһ��jedis����
				return resource;
			} else {
				logger.error("getJedis: jedisPool is null!");//��һ����־
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getJedis: redis connection error !",e);//��һ����־
			return null;
		}
	}

	/**
	 * �ͷ�jedis��Դ
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {

			jedisPool.returnResource(jedis);
		}
	}
}
