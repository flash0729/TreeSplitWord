package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import love.cq.util.CollectionUtil;
import love.cq.util.MapCount;

public class MapCountTest {
	public static void main(String[] args) {
		MapCount<String> mc = new MapCount<String>() ;
		
		mc.add("java"); 
		mc.add("java") ;
		mc.add("php") ;
		
		HashMap<String, Integer> hashMap = mc.get() ;
		
		System.out.println(hashMap);
		
		List<Entry<String, Integer>> sortMapByValue = CollectionUtil.sortMapByValue(hashMap, 1) ;
		
		System.out.println(sortMapByValue);
		
		List<Entry<String, Integer>> sortMapByValue2 = CollectionUtil.sortMapByValue(hashMap, -1) ;
		
		System.out.println(sortMapByValue2);
	}
}
