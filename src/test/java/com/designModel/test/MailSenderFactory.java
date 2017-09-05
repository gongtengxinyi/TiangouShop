package com.designModel.test;

public class MailSenderFactory implements Provider{

	public Sender produce() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
