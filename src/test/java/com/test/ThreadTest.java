package com.test;

public class ThreadTest extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ThreadLocalTest.addUser(currentThread().getName());
	
		super.run();
	}

}
