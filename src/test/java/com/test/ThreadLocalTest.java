package com.test;

public class ThreadLocalTest {
private static final ThreadLocal<String> user=new ThreadLocal<String>();
//private static final ThreadLocal<String>  =new ThreadLocal<String>();
public static void addUser(String userId)
{
	user.set(userId);
}
public static String getUser()
{
	return user.get();
}
public static void main(String[] args) {
	ThreadLocalTest.addUser("ding");
	System.out.println(ThreadLocalTest.getUser());
}
}
