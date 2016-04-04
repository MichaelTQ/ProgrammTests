package answers.cc150.chapter01;

import java.util.*;

public class StringUniqueChar {
	public static void main(String args[]) {
		String[] testCases = {
			"abc",
			null,
			"aa",
			"abccdaddd",
			"bdi82yhrjsjjia",
			"1",
		};
		
		System.out.printf("String to Test | Result\n");
		for(String str: testCases) {
			System.out.println(String.format( "%-14s | %6s", str, isUniqueChar0(str) ) );
		}
		System.out.println("========================");
		
		System.out.printf("String to Test | Result\n");
		for(String str: testCases) {
			System.out.println(String.format( "%-14s | %6s", str, isUniqueChar1(str) ) );
		}
		System.out.println("========================");
	}
	static boolean isUniqueChar0(String str) {
		Set<Character> set = new HashSet<Character>();
		if(str == null || str.isEmpty()) {
			return true;
		}
		for(int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if(!set.add(c)) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isUniqueChar1(String str) {
		if(str == null || str.isEmpty() ) {
			return true;
		}
		boolean[] map = new boolean[1000];
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int ind = ((c - 'A')>=0)?(c - 'A'):(1000 + (c - 'A'));
			if(ind > 1000) {
				throw(new RuntimeException("Unable to compare Special Character: " + c));
			}
			if(map[ind] == true) {
				return false;
			} else {
				map[ind] = true;
			}
		}
		return true;
	}
}
