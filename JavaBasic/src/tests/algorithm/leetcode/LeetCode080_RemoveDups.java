package tests.algorithm.leetcode;

public class LeetCode080_RemoveDups {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int length = 1;
		int count = 1;
		int idx = 1;
		int prev = nums[0];
		for(int i = 0; i < nums.length; i++) {
			if(i != 0) {
				nums[idx] = nums[i];
				if(prev!= nums[i]) {
					count = 1;
					idx++;
					length++;
					prev = nums[i];
				} else {
					count++;
					if(count > 2) {
						continue;
					} else {
						idx++;
						length++;
					}
				}
			}
		}
		return length;
	}
	
	public static void main(String[] args) {
		int[][] testCases = {
				{1, 1, 1, 2, 2, 3},
				{1, 1},
				{1, 1, 2},
				{1, 1, 1, 1, 1, 2},
				{1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 6, 7},
		};
		for(int[] nums: testCases) {
			System.out.println("Before:");
			TestUtils.printArr(nums);
			System.out.println("Result Length: " + new LeetCode080_RemoveDups().removeDuplicates(nums));
			System.out.println("After:");
			TestUtils.printArr(nums);
			System.out.println("==============");
		}
		
	}
}
