package answers.cc150.chapter01;

import java.util.*;
import java.util.Map.Entry;

public class C1S3_StringPermutationCheck {

	public static void main(String[] args) {
		DoubleString[] testCases = {
			new DoubleString(null, null),
			new DoubleString("a", ""),
			new DoubleString(null, ""),
			new DoubleString("bac", "dog"),
			new DoubleString("dog", "god"),
			new DoubleString("MIT", "ITM"),
			new DoubleString("abd8eads", "esdb8ada"),
			new DoubleString("abd8eads", "esdb8aea"),
		};
		
		System.out.println("String No.1    | String No.2    | Result");
		for(DoubleString ds:testCases) {
			System.out.println(String.format( "%-15s| %-15s| %5s", ds.str1, ds.str2, ds.isPermutation1()) );
		}
		System.out.println("========================================\n");
		
		System.out.println("String No.1    | String No.2    | Result");
		for(DoubleString ds:testCases) {
			System.out.println(String.format( "%-15s| %-15s| %5s", ds.str1, ds.str2, ds.isPermutation2()) );
		}
		System.out.println("========================================\n");
	}
	
	public static boolean permutationCheck2(String str1, String str2) {
		if(str1 == null && str2 == null) {
			return true;
		} else if(str1 == null || str2 == null) {
			return false;
		}
		if(str1.length() != str2.length()) return false;
		Map<Character, Integer> map1 = getMap(str1);
		Map<Character, Integer> map2 = getMap(str2);
		
		Set<Entry<Character, Integer>> entrySet = map1.entrySet();
		for(Entry<Character, Integer> entry: entrySet) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			if(map2.get(key) != val) return false;
		}
		return true;
	}
	
	private static Map<Character, Integer> getMap(String str) {
		Map<Character, Integer> map = new Hashtable<Character, Integer>();
		for(int i = 0; i < str.length(); i++ ) {
			if(map.containsKey(str.charAt(i))) map.put(str.charAt(i), map.get(str.charAt(i)) + 1); 
			else map.put(str.charAt(i), 1);
		}
		return map;
	}
	
	public static boolean permutationCheck1(String str1, String str2) {
		if(str1 == null && str2 == null) {
			return true;
		} else if (str1 == null || str2 == null) {
			return false;
		}
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();
		Arrays.sort(charArr1);
		Arrays.sort(charArr2);
		
		if(charArr1.length != charArr2.length) {
			return false;
		}
		for(int i = 0; i < charArr1.length; i++) {
			if( charArr1[i] != charArr2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	static class DoubleString {
		String str1;
		String str2;
		public DoubleString(String str1, String str2) {
			this.str1 = str1;
			this.str2 = str2;
		}
		public boolean isPermutation1() {
			return permutationCheck1(this.str1, this.str2);
		}
		public boolean isPermutation2() {
			return permutationCheck2(this.str1, this.str2);
		}
	}
}
