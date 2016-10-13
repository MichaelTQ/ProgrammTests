package tests.algorithm.leetcode;

public class LeetCode055 {
	public boolean canJump(int[] nums) {
		if(nums == null || nums.length == 0) return false;
		int farthest = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(i <= farthest && nums[i]+i >= farthest) {
				farthest = nums[i]+i;
			}
		}
		return farthest >= nums.length - 1;
	}
	
	public boolean canJumpDP(int[] nums) {
		boolean[] can = new boolean[nums.length];
		can[0] = true;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(can[j] && j + nums[j] >= i) {
					can[i] = true;
				}
			}
		}
		return can[nums.length-1];
	}
	
	public static void main(String[] args) {
		int[][] testCases = {
				{2, 3, 1, 1, 4},
				{3, 2, 1, 0, 4},
				{0},
				{4},
				{2, 1, 1, 0, 5},
				{2, 0},
				{1, 0},
		};
		for(int[] testCase: testCases) {
			TestUtils.printArr(testCase);
			System.out.println("Result: " + new LeetCode055().canJumpDP(testCase));
		}
	}
}
