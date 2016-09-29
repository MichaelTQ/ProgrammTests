package tests.algorithm.leetcode;

public class LeetCode041 {
	public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
        	while(nums[i] != i+1) {
        		if(nums[i] <= 0 || nums[i] >= n) break;
        		if(nums[i] == nums[nums[i]-1]) break;
        		int tmp = nums[i];
        		nums[i] = nums[tmp-1];
        		nums[tmp-1] = tmp;
        	}
        }
        for(int i = 0; i < n; i++) {
        	if(nums[i] != i+1) {
        		return i+1;
        	}
        }
        return n+1;
    }
	
	public static void main(String[] args) {
		int[][] testCases = {
				{0, 4, 7, 1, 3, -1},
				{3, -8, 1, 0, 3, 4},
		};
		for(int[] testCase:testCases) {
			TestUtils.printArr(testCase);
			new LeetCode041().firstMissingPositive(testCase);
			TestUtils.printArr(testCase);
			System.out.println("=-=-=-=-=-=-=");
		}
	}
}
