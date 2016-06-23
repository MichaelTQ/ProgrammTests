package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode010 {
    public boolean isMatch(String s, String p) {
    	if(p.length() == 0) return s.length() == 0;
    	if(p.length() == 1) {
    		if(s.length()<1) return false;
    		else if(p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') {
    			return false;
    		} else {
    			return isMatch(s.substring(1), p.substring(1));
    		}
    	}
    	if(p.charAt(1) != '*') {
    		if(s.length() < 1) return false;
    		else if(p.charAt(0) != s.charAt(0) && p.charAt(0)!='.') {
    			return false;
    		} else {
    			return isMatch(s.substring(1), p.substring(1));
    		}
    	} else {
    		if(isMatch(s, p.substring(2))) return true;
    		int i = 0;
    		while(i<s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
    			if(isMatch(s.substring(i+1), p.substring(2))) {
    				return true;
    			}
    			i++;
    		}
    		return false;
    	}
    }

	public static void main(String[] args) {
		List<TestCase> list = new ArrayList<TestCase>();
		list.add( new TestCase("aa", "a", false) );
		list.add( new TestCase("aa","aa", true) );
		list.add( new TestCase("aaa","aa", false) );
		list.add( new TestCase("aa", "a*", true) );
		list.add( new TestCase("aa", ".*", true) );
		list.add( new TestCase("ab", ".*", true) );
		list.add( new TestCase("aab", "c*a*b", true) );
		list.add( new TestCase("ab", ".*b", true));
		list.add( new TestCase("abcd", "d*", false));
		list.add( new TestCase("aaa", "a*a", true));
		list.add( new TestCase("a", "", false));
		list.add( new TestCase("aaa", "aaaa", false));
		list.add( new TestCase("bbbba", ".*a*a", true));
		
		System.out.println(String.format("%-10s | %-10s | %-10s | %-10s | %-10s",
				"String", "Regex", "Expected", "Actual", "Result"));
		System.out.println("--------------------------------------------------------------");
		for(TestCase test: list) {
			boolean actual = new LeetCode010().isMatch(test.input, test.regex);
			boolean result = (actual == test.expected);
			System.out.println(String.format("%-10s | %-10s | %-10s | %-10s | %-10s",
					test.input, test.regex, test.expected, actual, result));
		}
	}
	
	static class TestCase {
		String input;
		String regex;
		boolean expected;
		public TestCase(String input, String regex, boolean expected) {
			this.input = input;
			this.regex = regex;
			this.expected = expected;
		}
	}
}
