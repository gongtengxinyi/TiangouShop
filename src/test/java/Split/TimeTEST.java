package Split;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTEST {
public static void main(String[] args) {
	SimpleDateFormat f=new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss:sss");
	Date nowDate=new Date();
	System.out.println("³ÌÐò  START ["+f.format(nowDate)+"]");
	for(int i=0;i<10000;i++)
	{
	int	a=10;
	a++;
	}
	nowDate=new Date();
	System.out.println("³ÌÐò END ["+f.format(nowDate)+"]");
}
}
