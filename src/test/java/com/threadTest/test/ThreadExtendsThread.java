package com.threadTest.test;

public class ThreadExtendsThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(currentThread().getName() + "start");
	}

}
