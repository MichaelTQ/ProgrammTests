package tests.algorithm.leetcode;

public class LeetCode044 {
	public boolean isMatch(String s,String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;
		
		while(i < s.length()) {
			if(j<p.length() && (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i))) {
				i++;j++;
			} else if (j<p.length() && p.charAt(j)=='*') {
				starIndex=j;
				iIndex=i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex+1;
				i = iIndex+1;
				iIndex++;
			} else {
				return false;
			}
		}
		while(j<p.length() && p.charAt(j)=='*') {
			j++;
		}
		return j==p.length();
	}
	
	private boolean wildCardHelper(String s, String p) {
		if(p.length() == 1) {
			return true;
		}
		for(int i = 0; i < s.length(); i++) {
			String sub = s.substring(i);
			if(isMatchSlow(sub, p.substring(1))) {
				return true;
			}
		}
		return false;
	}
	public boolean isMatchSlow(String s, String p) {
		if(s.equals(p) || p.equals("*")) return true;
		if(s == null || s.length() == 0) return false;
		int i = 0;
		for(; i < s.length(); i++) {
			if(i >= p.length()) {
				return false;
			}
			if(p.charAt(i) == '*') {
				return wildCardHelper(s.substring(i), p.substring(i));
			}
			if(p.charAt(i) == '?') {
				continue;
			}
			if(p.charAt(i) == s.charAt(i)) {
				continue;
			} else {
				return false;
			}
		}
		while(i < p.length() && p.charAt(i) == '*') {
			i++;
		}
		if(i==p.length()) {
			return true;
		} else {
			return false;
		}
    }
	
	public static void main(String[] args) {
		TestCase[] testCases = {
				new TestCase("aa", 	"a", 		false),
				new TestCase("aa", 	"aa", 		true),
				new TestCase("aaa", "aa", 		false),
				new TestCase("aa", 	"*", 		true),
				new TestCase("aa", 	"a*", 		true),
				new TestCase("ab", 	"?*", 		true),
				new TestCase("aab", "c*a*b", 	false),
				new TestCase("a", 	"aa", 		false),
				new TestCase("a", 	"a*", 		true),
				new TestCase("a", 	"?*", 		true),
				new TestCase("a",	"??",		false),
				new TestCase("e", 	"*??",		false),
				new TestCase("abce","abc*??",	false),
				new TestCase(	"abefcdgiescdfimde",
								"ab*cd?i*de",
								true),
		};
		for(TestCase testCase: testCases) {
			boolean actual = new LeetCode044().isMatch(testCase.s, testCase.p);
			System.out.println(testCase);
			System.out.println("expected: " + testCase.result);
			System.out.println("actual:   " + actual);
			if(actual != testCase.result) {
				System.out.println("***** FAIL!!!! *****");
			}
			System.out.println("================");
		}
	}
	private static class TestCase {
		private String s;
		private String p;
		private boolean result;
		public TestCase(String s, String p, boolean result) {
			this.s = s;
			this.p = p;
			this.result = result;
		}
		@Override
		public String toString() {
			return "s: " + s + " p: " + p;
		}
	}
}
