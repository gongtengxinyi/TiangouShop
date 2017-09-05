//package com.tiangou.websocket;
//import javax.annotation.Resource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
///**
// * WebScoket≈‰÷√¥¶¿Ì∆˜
// * @author dingjianlei	
// * @Date 2016 11 29
// */
//@Component
//@EnableWebSocket
//public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
//@Resource
//MyWebSocketHandler handler;
//public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//registry.addHandler(handler, "/ws").addInterceptors(new HandShake());
//registry.addHandler(handler, "/ws/sockjs").addInterceptors(new HandShake()).withSockJS();
//}
//}