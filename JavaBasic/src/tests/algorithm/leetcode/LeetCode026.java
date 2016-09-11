package tests.algorithm.leetcode;

public class LeetCode026 {
    public int removeDuplicates(int[] nums) {
    	int count = 0;
    	if (nums.length < 1) {
    		return count;
    	}
    	int curr = nums[0];
    	count++;
    	int ind = 0;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] == curr) {
    			continue;
    		} else {
    			curr = nums[i];
    			ind++;
    			nums[ind] = curr;
    			count++;
    		}
    	}
        return count;
    }
    
	public static void main(String[] args) {
		int [][] testCases = {
				{1, 1, 2},
				{1, 1, 2, 2, 5, 9},
		};
		for(int[] testCase: testCases) {
			System.out.println("Before calling method:");
			TestUtils.printArr(testCase);
			System.out.println("Function result:");
			System.out.println(new LeetCode026().removeDuplicates(testCase));
			System.out.println("After calling method:");
			TestUtils.printArr(testCase);
			System.out.println("==========================");
		}
	}
}
