package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode005 {
    public String longestPalindrome(String s) {
    	if(s == null || s.length() <= 1) return s;
    	String longest = null;
    	for(int i = 0; i < s.length(); i++) {
    		String str1 = getLongestPalindrome(s, i, i);
    		String str2 = getLongestPalindrome(s, i, i+1);
    		String str = str1.length()>str2.length()?str1:str2;
    		if(longest == null || str.length() > longest.length()) {
    			longest = str;
    		}
    	}
        return longest;
    }

    private String getLongestPalindrome(String s, int ind1, int ind2) {
    	while(ind1 >= 0 && ind2 <= s.length()-1 &&
    			s.charAt(ind1) == s.charAt(ind2)) {
    		ind1--;
    		ind2++;
    	}
    	return s.substring(ind1 + 1, ind2);
    }

    public static void main(String[] args) {
    	LeetCode005 s = new LeetCode005();
    	List<TestCase> tests = new ArrayList<TestCase>();
    	// Adding test cases
    	tests.add(new TestCase("a", "a"));
    	tests.add(new TestCase(null, null));
    	tests.add(new TestCase("eabcbad", "abcba"));
    	tests.add(new TestCase("aabbaeedd", "abba"));
    	tests.add(new TestCase("bb", "bb"));
    	tests.add(new TestCase("aaa", "aaa"));
    	
    	System.out.println(String.format("%-20s | %-20s | %-20s | %7s",
    			"Test String", "Expected Result", "Actual Result", "PASS?"));
    	for(TestCase testCase:tests) {
    		String actual = s.longestPalindrome(testCase.s);
    		System.out.println(String.format(
    				"%-20s | %-20s | %-20s | %7b",
    				testCase.s,
    				testCase.expected,
    				actual,
    				testCase.expected==null?testCase.expected==actual:testCase.expected.equals(actual) ));
    	}
    }

    static class TestCase {
    	String s;
    	String expected;
    	public TestCase(String s, String expected) {
    		this.s = s;
    		this.expected = expected;
    	}
    }
}
