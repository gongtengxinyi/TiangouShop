package com.designModel.test;

/**
 * @author 普通工厂方法+多个工厂+静态工厂
 * 
 *总体来说，工厂模式适合：凡是出现了大量的产品需要创建
 *，并且具有共同的接口时，可以通过工厂方法模式进行创建
 *。在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象
 *，第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下
 *，我们会选用第三种——静态工厂方法模式。
 */
public class PutongFactoryTest {
public static void main(String[] args) {
	/*普通工厂测试
	 * SenderFactory senderFacotry=new SenderFactory();
	Sender sms = senderFacotry.produce("sms");
	Sender mail = senderFacotry.produce("mail");
sms.Send();
mail.Send();
*/
	 /*多个工厂测试
	  * SenderFactory senderFacotry=new SenderFactory();
	 senderFacotry.getMailSender().Send();
senderFacotry.getSmsSender().Send();*/
	/**
	 * 静态工厂测试
	 */
	 /*SenderFactory.getMailSender().Send();
	 SenderFactory.getSmsSender().Send();*/
}
}
