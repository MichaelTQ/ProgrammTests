package tests.algorithm.leetcode;

public class ArrayAlgorithmTest {
	public static void main(String[] args) {
		System.out.println("Hello, world!");
		
		/* Leet Code 228 *******************************
		 * https://leetcode.com/problems/summary-ranges/
		 * *********************************************/
		LC228Test();
	}
	
	public static void LC228Test() {
		int[][] nums = {
				{0, 1, 2, 4, 5, 7},
				{5},
				{1, 3, 4, 9},
				{}
		};
		for(int[] arr: nums) {
			ILCSolution lc228 = new LeetCode228(arr);
			lc228.myPrint();
		}
	}
}