package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode076 {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < t.length(); i++) {
			if(map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i)+1));
			} else {
				map.put(t.charAt(i), 1);
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			
		}
		return "";
	}
	
	public static void main(String[] args) {

	}
}
