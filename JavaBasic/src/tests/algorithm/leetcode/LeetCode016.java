package tests.algorithm.leetcode;

public class LeetCode016 {
    public int threeSumClosest(int[] nums, int target) {
        java.util.Arrays.sort(nums);
        int result;
        result = nums[0]+nums[1]+nums[2];
        int diff = result>target?result-target:target-result;
        if(diff == 0) return result;
        for(int i = 0; i < nums.length-2; i++) {
        	int left = i+1;
        	int right = nums.length-1;
        	while(left<right){
	        	int sum = nums[left] + nums[right] + nums[i];
	        	int curDiff = sum>target?sum-target:target-sum;
	        	if(curDiff < diff) {
	        		diff = curDiff;
	        		result = sum;
//	        		left++;
//	        		right--;
	        	}
	        	if(sum < target) {
	        		left++;
	        	} else {
	        		right--;
	        	}
        	}
        }
        return result;
    }
    
	public static void main(String[] args) {
		int[][] testCases = {
				{-1, 2, 1, -4},
				{0, 2, 1, -3},
		};
		for(int[]testCase: testCases) {
			System.out.println(new LeetCode016().threeSumClosest(testCase, 1));
		}
	}

}
