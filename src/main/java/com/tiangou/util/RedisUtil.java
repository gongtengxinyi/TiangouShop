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
	 * 初始化Redis连接池
	 */
	static {
		try {
			Properties properties = new Properties();
			properties = PropertiesLoaderUtils.loadAllProperties("redis.properties");//从配置文件中读取配置信息

			JedisPoolConfig config = new JedisPoolConfig();
			String host = properties.getProperty("redis.host");//主机
			int port = Integer.parseInt(properties.getProperty("redis.port"));//端口
			int timeout = Integer.parseInt(properties.getProperty("redis.timeout"));//超时设置
			String auth = properties.getProperty("redis.password");//密码
			int maxTotal =Integer.parseInt(properties.getProperty("redis.pool.maxTotal"));//最大活动连接数
			int maxIdle = Integer.parseInt(properties.getProperty("redis.pool.maxIdle"));//最大空闲连接数
			int minIdle = Integer.parseInt(properties.getProperty("redis.pool.minIdle"));//最小空闲连接数
			long maxWaitMillis =Long.parseLong( properties.getProperty("redis.pool.maxWaitMillis"));//最大等待毫秒数
			boolean testOnBorrow = properties.getProperty("redis.pool.testOnBorrow")=="true"?true:false ;
			boolean testOnReturn = properties.getProperty("redis.pool.testOnReturn")=="true"?true:false ;
			
			config.setMaxTotal(maxTotal);
			config.setMaxIdle(maxIdle);
			config.setMinIdle(minIdle);
			config.setMaxWaitMillis(maxWaitMillis);
			config.setTestOnBorrow(testOnBorrow);
			config.setTestOnReturn(testOnReturn);
			
			jedisPool = new JedisPool(config, host, port, timeout, auth);//建立jedis连接池
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取Jedis实例
	 * 
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();//获取一个jedis连接
				return resource;
			} else {
				logger.error("getJedis: jedisPool is null!");//记一条日志
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getJedis: redis connection error !",e);//记一条日志
			return null;
		}
	}

	/**
	 * 释放jedis资源
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {

			jedisPool.returnResource(jedis);
		}
	}
}
