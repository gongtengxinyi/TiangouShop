//package com.tiangou.websocket;
//import java.io.IOException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//import com.google.gson.GsonBuilder;
//import com.tiangou.util.JsonUtils;
//
///**
// * @author dingjianlei
// * socket ������
// */
//@Component
//public class MyWebSocketHandler implements WebSocketHandler {
//	
//public static final Map<Long, WebSocketSession> userSocketSessionMap;
//static {
//userSocketSessionMap = new HashMap<Long, WebSocketSession>();
//}
///**
// * �������Ӻ�
// */
///* (non-Javadoc)
// * @see org.springframework.web.socket.WebSocketHandler#afterConnectionEstablished(org.springframework.web.socket.WebSocketSession)
// */
//
//public void afterConnectionEstablished(WebSocketSession session)
//throws Exception {
//Long uid = (Long) session.getAttributes().get("uid");
//if (userSocketSessionMap.get(uid) == null) {
//userSocketSessionMap.put(uid, session);
//}
////sendMessageToUser("", message);
//}
///**
// * ��Ϣ�����ڿͻ���ͨ��Websocket API���͵���Ϣ�ᾭ�����Ȼ�������Ӧ�Ĵ���
// */
//public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//if(message.getPayloadLength()==0)return;
////Message msg=new Gson().fromJson(message.getPayload().toString(),Message.class);
//Message msg=JsonUtils.jsonToPojo(message.getPayload().toString(), Message.class);
//msg.setDate(new Date());
////customerService.insertCustomer("2");
//sendMessageToUser(msg.getTo(), new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
//}
//
///**
// * ��Ϣ���������
// */
//public void handleTransportError(WebSocketSession session,
//Throwable exception) throws Exception {
//if (session.isOpen()) {
//session.close();
//}
//Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
//.entrySet().iterator();
//// �Ƴ�Socket�Ự
//while (it.hasNext()) {
//Entry<Long, WebSocketSession> entry = it.next();
//if (entry.getValue().getId().equals(session.getId())) {
//userSocketSessionMap.remove(entry.getKey());
//System.out.println("Socket�Ự�Ѿ��Ƴ�:�û�ID" + entry.getKey());
//break;
//}
//}
//}
///**
// * �ر����Ӻ�
// */
//public void afterConnectionClosed(WebSocketSession session,
//CloseStatus closeStatus) throws Exception {
//System.out.println("Websocket:" + session.getId() + "�Ѿ��ر�");
//Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
//.entrySet().iterator();
//// �Ƴ�Socket�Ự
//while (it.hasNext()) {
//Entry<Long, WebSocketSession> entry = it.next();
//if (entry.getValue().getId().equals(session.getId())) {
//userSocketSessionMap.remove(entry.getKey());
//System.out.println("Socket�Ự�Ѿ��Ƴ�:�û�ID" + entry.getKey());
//break;
//}
//}
//}
//public boolean supportsPartialMessages() {
//return false;
//}
///**
// * �����������û�������Ϣ
// * Ⱥ�� 
// * @param message
// * @throws IOException
// */
//public void broadcast(final TextMessage message) throws IOException {
//Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
//.entrySet().iterator();
//// ���߳�Ⱥ��
//while (it.hasNext()) {
//final Entry<Long, WebSocketSession> entry = it.next();
//if (entry.getValue().isOpen()) {
//// entry.getValue().sendMessage(message);
//new Thread(new Runnable() {
//public void run() {
//try {
//if (entry.getValue().isOpen()) {
//entry.getValue().sendMessage(message);
//}
//} catch (IOException e) {
//e.printStackTrace();
//}
//}
//}).start();
//}
//}
//}
///**
// * ��ĳ���û�������Ϣ
// * 
// * @param userName
// * @param message
// * @throws IOException
// */
//public void sendMessageToUser(Long uid, TextMessage message)
//throws IOException {
//WebSocketSession session = userSocketSessionMap.get(uid);
//if (session != null && session.isOpen()) {
//session.sendMessage(message);
//}
//}
//}