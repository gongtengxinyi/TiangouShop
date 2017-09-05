package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author map±éÀú²âÊÔ
 *
 */
public class MapTest {
public static void main(String[] args) {
Map<String,Integer> map=new HashMap<String,Integer>();
map.put("ding", 12);
map.put("wang", 14);
map.put("fu", 15);
for (Map.Entry<String, Integer> entry:map.entrySet()) {
	System.out.println(entry.getKey()+"..."+entry.getValue());
	}

Iterator <Map.Entry<String, Integer>> iterator= map.entrySet().iterator();

	
}
}


