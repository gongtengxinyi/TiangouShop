package com.tiangou.util;



import java.util.Random;
import java.util.UUID;

public class IDUtils {

	/**
	 * 鍥剧墖鍚嶇敓鎴�
	 */
	public static String genImageName() {
		//鍙栧綋鍓嶆椂闂寸殑闀挎暣褰㈠�煎寘鍚绉�
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//鍔犱笂涓変綅闅忔満鏁�
		Random random = new Random();
		int end3 = random.nextInt(999);
		//濡傛灉涓嶈冻涓変綅鍓嶉潰琛�0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * 鍟嗗搧id鐢熸垚
	 */
	public static long genItemId() {
		//鍙栧綋鍓嶆椂闂寸殑闀挎暣褰㈠�煎寘鍚绉�
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//鍔犱笂涓や綅闅忔満鏁�
		Random random = new Random();
		int end2 = random.nextInt(99);
		//濡傛灉涓嶈冻涓や綅鍓嶉潰琛�0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	public static String getId()
	{
		   UUID uuid = UUID.randomUUID();
		   return uuid.toString();
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(genImageName());
	}
}
