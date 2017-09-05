package com.tiangou.cache;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author dingjianlei 监听器 ，spring启动之后，将所需要的前台显示页面加载到内存中
 * 
 */
@Component
public class StartUpListenerSpring implements ApplicationListener<ContextRefreshedEvent> {

	public void onApplicationEvent(ContextRefreshedEvent event) {
   
	}

}
