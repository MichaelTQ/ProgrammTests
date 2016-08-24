/**
 * String to Integer
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * */

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode008 {

	public int myAtoi(String str) {
		if(str==null || "".equals(str)) return 0;
		str = str.trim();
		if("+".equals(str) || "-".equals(str)) return 0;
		StringBuffer sb = new StringBuffer(str);
		for(int i = 0; i < sb.length(); i++) {
			if(Character.isLetter(sb.charAt(i))) {
				sb = sb.replace(i, sb.length(), "");
			}
		}
		try {
			long result = Long.parseLong(sb.toString());
			if(result > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if(result < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.parseInt(sb.toString());
			}
		} catch(Exception e) {
			return 0;
		}
    }

	public static void main(String[] args) {
		List<TestCaseUniversalDiff<String, Integer>> testList =
				new ArrayList<TestCaseUniversalDiff<String, Integer>>();
		testList.add(new TestCaseUniversalDiff<String, Integer>("123", 123));
		testList.add(new TestCaseUniversalDiff<String, Integer>(null, 0));
		testList.add(new TestCaseUniversalDiff<String, Integer>("112", 112));
		testList.add(new TestCaseUniversalDiff<String, Integer>("-112", -112));
		testList.add(new TestCaseUniversalDiff<String, Integer>("0000", 0));
		testList.add(new TestCaseUniversalDiff<String, Integer>("+", 0));
		testList.add(new TestCaseUniversalDiff<String, Integer>("  -0012a42", -12));
		testList.add(new TestCaseUniversalDiff<String, Integer>("+-2", 0));
		testList.add(new TestCaseUniversalDiff<String, Integer>("-+2", 0));
		testList.add(new TestCaseUniversalDiff<String, Integer>("2147483648", Integer.MAX_VALUE));
		testList.add(new TestCaseUniversalDiff<String, Integer>("+1", 1));
		
		TestUtils.printTestHeader();
		for(TestCaseUniversalDiff<String, Integer> test: testList) {
			String input = test.input;
			int expected = test.getExpected();
			int actual = new LeetCode008().myAtoi(input);
			String str = String.format("%-10s | %-10d | %-10d | %-10s",
					input, expected, actual, actual == expected);
			TestUtils.printTestRow(str);
			
		}
	}
}
