package tests.algorithm.leetcode;

public class LeetCode053 {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length==0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int minSum = 0;
		for(int num: nums) {
			sum += num;
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[][] testCases = {
				{-2,1,-3,4,-1,2,1,-5,4},	// 6
		};
		
		for(int[] testCase: testCases) {
			int result = new LeetCode053().maxSubArray(testCase);
			TestUtils.printArr(testCase);
			System.out.println("Result is: " + result);
		}
	}
}
