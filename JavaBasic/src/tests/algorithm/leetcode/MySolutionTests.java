package tests.algorithm.leetcode;

public class MySolutionTests {
	public static void LC228Test() {
		int[][] nums = {
				{0, 1, 2, 4, 5, 7},
				{5},
				{1, 3, 4, 9},
				{},
		};
		for(int[] arr: nums) {
			ILCSolution lc228 = new LeetCode228(arr);
			lc228.myPrint();
		}
	}
	
	public static void LC227Test() {
		String[] expressions = {
				"1*3",
				"1+2",
				"1 * 3 - 5 / 7",
				"0-2147483648",
				"2-1",
				"2*3+4",
		};
		
		for(String expression:expressions) {
			ILCSolution lc227 = new LeetCode227(expression);
			lc227.myPrint();
		}
	}
}
