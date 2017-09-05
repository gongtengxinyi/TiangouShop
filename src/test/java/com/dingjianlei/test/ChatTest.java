package com.dingjianlei.test;

import com.tiangou.util.HttpClientUtil;

public class ChatTest {
public static void main(String[] args) {
	String re=HttpClientUtil.doGet("ws://localhost:3080/chat/chatServer?userid=8a98206958e83b610158f164da38445f&usertype=ADMIN&TERMINALTYPE=WEB&INDENTID=402812815af3e50c015af46febb50078");
	System.out.println(re);
	
}
}
