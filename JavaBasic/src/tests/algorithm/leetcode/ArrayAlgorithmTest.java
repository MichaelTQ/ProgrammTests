package tests.algorithm.leetcode;

import java.util.List;

public class ArrayAlgorithmTest {
	public static void main(String[] args) {
		System.out.println("Hello, world!");
		
		/* Leet Code 228 *******************************
		 * https://leetcode.com/problems/summary-ranges/
		 * *********************************************/
		
	}
	
	public static void LC228Test() {
		int[] nums = {0, 1, 2, 4, 5, 7};
		List<String> lstResult = new LeetCode228().summaryRanges(nums);
		
		new LeetCode228().myPrint(lstResult);
	}
}