package tests.algorithm.leetcode;

public class ForRamdomTests {
	
	public static void main(String[] args) {
		String []tests = {
			"a",
			"abd",
			"aba",
			"abba",
		};
		
		for(String s:tests) {
			System.out.println(isPalindrome(s));
		}
	}
	
	private static boolean isPalindrome(String s) {
		if(s == null) {
			return false;
		}
		int start = 0;
		int end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
