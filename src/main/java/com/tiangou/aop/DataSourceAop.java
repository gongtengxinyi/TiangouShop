package com.tiangou.aop;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tiangou.annotation.DataSource;
import com.tiangou.dataSource.DataSourceContextHolder;
@Component
@Aspect
@Order(1)
public class DataSourceAop {
	/**
	 * @param joinPoint
	 */
	
	 @Before("@annotation(com.tiangou.annotation.DataSource)") 
	public void changeDataSource(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		  Class<?> targetClass=null;
		try {
			targetClass = Class.forName(joinPoint.getTarget().getClass().getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method[] methods = targetClass.getMethods();
		for (Method method : methods) {
			if (StringUtils.equals(method.getName(), methodName)) {
				if (joinPoint.getArgs().length == method.getParameterTypes().length) {
					DataSource dataSource = method.getAnnotation(DataSource.class);
					DataSourceContextHolder.setDbType(dataSource.name());			
				}
			}
		}
	}
}
