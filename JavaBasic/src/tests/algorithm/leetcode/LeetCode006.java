/**
 * ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * */

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode006 {
	public String convert(String s, int numRows) {
		if (numRows <= 1) {
	        return s;
	    }
	    int n = s.length();
	    int step = 2 * numRows - 2;
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < numRows; i++) {
	        for (int j = i; j < n; j += step) {
	            sb.append(s.charAt(j));
	            if (i != 0 && i != numRows - 1 && j + step - 2 * i < n) {
	                sb.append(s.charAt(j + step - 2 * i));
	            }
	        }
	    }
	    return sb.toString();
    }
	
	public static void main(String[] args) {
		List<TestCase> list = new ArrayList<TestCase>();
		list.add(new TestCase("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"));
		list.add(new TestCase("PAYPALISHIRING", 4, "PINALSIGYAHRPI"));
		
		for(TestCase testCase: list) {
			if(testCase.s != null) {
				String actual = new LeetCode006().convert(testCase.s, testCase.num);
				System.out.println("Input: " + testCase.s);
				System.out.println("Expected: " + testCase.expected);
				System.out.println("Actual: " + actual);
				System.out.println(testCase.expected.equals(actual));
				System.out.println("======================");
			} else {
				System.out.println("null");
			}
		}
	}
	
	static class TestCase {
		String s;
		int num;
		String expected;
		public TestCase(String s, int num,  String expected) {
			this.s = s;
			this.num = num;
			this.expected = expected;
		}
	}
}
