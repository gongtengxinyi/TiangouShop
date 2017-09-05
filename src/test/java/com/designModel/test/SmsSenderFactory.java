package com.designModel.test;

public class SmsSenderFactory implements Provider{

	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
