package tests.algorithm.leetcode;

public class LeetCode075 {
	public void sortColors(int[] nums) {
		if(nums == null || nums.length <= 1) return;
		int[] countArray = new int[3];
		for(int i = 0; i < nums.length; i++) {
			countArray[nums[i]]++;
		}
		int j = 0;
		int k = 0;
		while(j<=2) {
			if(countArray[j] != 0) {
				nums[k++] = j;
				countArray[j]--;
			} else {
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] testCases = {
				{},
				{2, 0, 1, 0, 2},
				{2, 2, 1, 1, 2},
		};
		for(int[] nums: testCases) {
			System.out.println("before sort:");
			TestUtils.printArr(nums);
			System.out.println("after sort:");
			new LeetCode075().sortColors(nums);
			TestUtils.printArr(nums);
			System.out.println("==================");
		}
	}
}
