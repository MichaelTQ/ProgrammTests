package tests.algorithm.leetcode;

public class LeetCode081_SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if(nums == null) return false;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == target) return true;
		}
		return false;
	}
	public boolean searchBinary(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left + 1 < right) {
			int mid = (left+right)/2;
			if(nums[mid] == target) {
				return true;
			}
			if(nums[mid] < nums[right]) {
				if(nums[mid] <= target && target <= nums[right]) {
					left = mid;
				} else {
					right = mid;
				}
			} else {
				if(nums[mid] >= target && target >= nums[left]) {
					right = mid;
				} else {
					left = mid;
				}
			}
		}
		if(nums[left] == target || nums[right] == target) return true;
		return false;
	}
	
	public static void main(String[] args) {
//		int[] nums = {4, 5, 7, 9, 1, 1, 2, 3};
		int[] nums = {1, 1, 3, 1};
//		int[] nums = {3, 1, 1};
		
		TestUtils.printArr(nums);
		for(int i = 0; i < 12; i++) {
			System.out.println("searching for: " + i);
			System.out.println("Result: " + new LeetCode081_SearchInRotatedSortedArrayII().search(nums, i));
			System.out.println("========");
		}
	}
}
