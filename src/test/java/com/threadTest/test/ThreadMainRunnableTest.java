package com.threadTest.test;

public class ThreadMainRunnableTest {
public static void main(String[] args) {
	new Thread(new ThreadImplementsRunnable()).start();
	new Thread(new ThreadImplementsRunnable()).start();
}
}
