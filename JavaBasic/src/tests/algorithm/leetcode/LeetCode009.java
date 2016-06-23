/**
 * Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 * 
 * */

package tests.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode009 {
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		else if(x>=0 && x<=1) return true;
		return isPalindromeHelper(new Integer(x).toString());
    }
	
	private boolean isPalindromeHelper(String str) {
		if(str == null || str.length() <= 1) return true;
		if(str.charAt(0) == str.charAt(str.length() - 1)) {
			return isPalindromeHelper(str.substring(1, str.length()-1));
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		List<TestCaseUniversalDiff<Integer, Boolean>> testList =
				new ArrayList<TestCaseUniversalDiff<Integer, Boolean>>();
		testList.add(new TestCaseUniversalDiff<Integer, Boolean>(1, true));
		testList.add(new TestCaseUniversalDiff<Integer, Boolean>(121, true));
		testList.add(new TestCaseUniversalDiff<Integer, Boolean>(12, false));
		testList.add(new TestCaseUniversalDiff<Integer, Boolean>(-1, false));
		
		TestUtils.printTestHeader();
		for(TestCaseUniversalDiff<Integer, Boolean> test: testList) {
			int input = test.input;
			boolean expected = test.getExpected();
			boolean actual = new LeetCode009().isPalindrome(input);
			boolean result = expected == actual;
			TestUtils.printTestRow(String.format("%-10s | %-10s | %-10s | %-10s",
					input, expected, actual, result));
		}
	}
}
