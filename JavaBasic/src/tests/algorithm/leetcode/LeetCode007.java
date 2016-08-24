/**
 * Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 * */

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode007 {
	public int reverse(int x) {
		boolean isNeg = false;
		long val = (long)x;
		if(val<0) {
			val = 0-val;
			isNeg = true;
		}
		long result = 0;
		while(val != 0) {
			if (result != 0 && Integer.MAX_VALUE / result < 10
	                   && Integer.MAX_VALUE / result > -10)
	               return 0;
			result *= 10;
			long digit = val%10;
			val = val/10;
			result += digit;
		}
		if(isNeg) {
			return (int)(0-result);
		} else {
			return (int)result;
		}
	}

	public static void main(String[] args) {
		List<TestCase> testList = new ArrayList<TestCase>();
		testList.add(new TestCase(0, 0));
		testList.add(new TestCase(1, 1));
		testList.add(new TestCase(12, 21));
		testList.add(new TestCase(-123, -321));
		testList.add(new TestCase(123, 321));
		
		System.out.println(String.format("%-10s | %-10s | %-10s | %-10s",
				"Input", "Expected", "Actual", "Result"));
		for(TestCase test: testList) {
			int actual = new LeetCode007().reverse(test.x);
			System.out.println(String.format("%-10d | %-10d | %-10d | %-10s", 
					test.x, test.expected, actual, test.expected == actual));
		}
	}
	
	static class TestCase {
		int x;
		int expected;
		public TestCase(int x, int expected) {
			this.x = x;
			this.expected = expected;
		}
	}
}
