package com.tiangou.util;



import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring�����Ļ����ĳ�����.
 * @author dingjianlei
 *
 */
public class SpringContextHolder implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}



    public static void setContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * ȡ�ô洢�ھ�̬�����е�ApplicationContext.
     */
    public static ApplicationContext getContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * �Ӿ�̬����ApplicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        
        return (T) applicationContext.getBean(name);
    }

    /**
     * �Ӿ�̬����ApplicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
     */
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }
    
    
    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        checkApplicationContext();
        return applicationContext.getBeansOfType(type);
    }

    /**
     * ���applicationContext��̬����.
     */
    public static void cleanApplicationContext() {
        applicationContext = null;
    }
    
    public static boolean isContextReady() {
        return applicationContext != null;
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContextδ����...");
        }
    }
}