package tests.algorithm.leetcode;

import java.util.*;

public class ForRamdomTests {
	
	public static void main(String[] args) {
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		
		table.put(10, 10);
		System.out.println(table.containsKey(10));
		
		System.out.println(table.get(10));
	}
}
