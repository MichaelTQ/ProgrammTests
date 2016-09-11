package tests.algorithm.leetcode;

public class LeetCode027 {
    public int removeElement(int[] nums, int val) {
        if(nums == null) return 0;
        int startInd = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != val) {
        		nums[startInd] = nums[i];
        		startInd++;
        	}
        }
        return startInd;
    }
    
	public static void main(String[] args) {
		int [][] testCases = {
				{3, 2, 2, 3},
		};
		for(int[] testCase: testCases) {
			System.out.println("Before calling:");
			TestUtils.printArr(testCase);
			System.out.println("Result:");
			System.out.println(new LeetCode027().removeElement(testCase, 3));
			System.out.println("After calling:");
			TestUtils.printArr(testCase);
			System.out.println("=============================");
		}
	}
}
