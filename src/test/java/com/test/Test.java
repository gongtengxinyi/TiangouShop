package com.test;
import java.util.Date;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiangou.entity.Indent;
import com.tiangou.mapper.IndentMapper;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class Test {  
	@Autowired
	private IndentMapper indentMapper;	
	@org.junit.Test
	public void getIndex() {
//		for (int a = 0; a <= 10; a++) {
//			Indent indent = new Indent();
//			indent.setId(String.valueOf(a));
//			indent.setAddress("a" + a);
//			indent.setCreateDate(new Date());
//			indent.setName("b" + a);
//			indent.setPrice(a);
//			indentMapper.insertOneIndent(indent);
//		}
//		return ;
Indent selectOneIndent = indentMapper.selectOneIndent("4");
System.out.println(selectOneIndent.getAddress());
	}
	
	
} 