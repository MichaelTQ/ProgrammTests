package tests.algorithm.leetcode;

public class LeetCode035 {
    public int searchInsert(int[] nums, int target) {
    	if(nums == null || nums.length == 0) {
    		return -1;
    	}
    	int start = 0;
    	int end = nums.length - 1;
    	int mid = (start+end)/2;
    	boolean found = true;
    	while(nums[mid] != target) {
    		if(start > mid || end < mid) {
    			found = false;
    			break;
    		}
    		if(nums[mid] > target) {
    			end = mid-1;
    		} else {
    			start = mid+1;
    		}
    		mid = (start+end)/2;
    	}
    	if(found) {
    		return mid;
    	} else {
    		if(target>nums[mid]){
    			return mid+1;
    		} else {
    			return mid;
    		}
    	}
    }

	public static void main(String[] args) {
		int [][][]testCases = {
				{{1, 3, 5, 6}, {5}},
				{{1, 3, 5, 6}, {2}},
				{{1, 3, 5, 6}, {7}},
				{{1, 3, 5, 6}, {0}},
				{{1, 3, 5, 6}, {4}},
		};
		for(int [][]testCase: testCases) {
			int[] nums = testCase[0];
			int target = testCase[1][0];
			System.out.print("numbers: ");
			TestUtils.printArr(nums);
			System.out.println("target: " + target);
			System.out.println("result: " + new LeetCode035().searchInsert(nums, target));
			System.out.println("===============");
		}
	}
}
