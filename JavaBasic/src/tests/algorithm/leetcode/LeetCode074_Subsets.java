package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode074_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) return result;
		List<Integer> item = new ArrayList<Integer>();
		Arrays.sort(nums);
		helper(nums, 0, result, item);
		return result;
	}
	
	private void helper(int[] nums, int start, List<List<Integer>> result, List<Integer> item) {
		result.add(new ArrayList<Integer>(item));
		for(int i = start; i < nums.length; i++) {
			item.add(nums[i]);
			helper(nums, i+1, result, item);
			item.remove(item.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[][] testCases = {
				{1, 2, 3},
		};
		for(int[] testCase: testCases) {
			List<List<Integer>> result = new LeetCode074_Subsets().subsets(testCase);
			for(int i = 0; i < result.size(); i++) {
				System.out.print("[");
				for(int j = 0; j < result.get(i).size(); j++) {
					System.out.print(result.get(i).get(j) + ", ");
				}
				System.out.println("]");
			}
			System.out.println("================");
		}
	}
}
