package testing.justfor;

import java.util.*;
import java.util.Map.Entry;

public class RandomTesting2 {
	public static void main(String[] args) {
		TreeMap<String, String> treemap = new TreeMap<String, String>();
		
		treemap.put("ABD", "2");
		treemap.put("ABC", "3");
		
		Set<Entry<String, String>> set = treemap.entrySet();
		for(Entry<String, String> entry:set) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		new RandomTesting2.InnerClassTest();
	}
	
	public static class InnerClassTest {
		
	}
}
