/**
 * LeetCode Question #1 - two sum: https://leetcode.com/problems/two-sum/
 * 
 * */

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode001 {

	public static void main(String[] args) {
		int [][]arrTest = {
				{2, 7, 11, 15}, {9},
				{7, 2, 15, 11}, {13},
				{2, -10, 8, 3, 6}, {-8}
		};
		for(int i = 0; i < arrTest.length; i=i+2) {
			int target = arrTest[i+1][0];
			int[] arr = arrTest[i];
			int[] result = twoSum(arr, target);
			System.out.println("**********************");
			System.out.print("orig arr: [");
			for(int v: arr) {
				System.out.print(v + " ");
			}
			System.out.println("]");
			System.out.println("target: " + target);
			System.out.print("result: [");
			for(int v: result) {
				System.out.print(v + " ");
			}
			System.out.println("]");
		}
	}
	
	private static int[] twoSum(int[] nums, int target) {
//		int[] result = new int[2];
//		if(nums == null || nums.length < 2) return null;
//		for(int i = 0; i < nums.length; i++) {
//			for(int j = i + 1; j < nums.length; j++) {
//				if(nums[i] + nums[j] == target) {
//					result[0] = i;
//					result[1] = j;
//					break;
//				}
//			}
//		}
//		return result;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		if(nums == null || nums.length < 2) return null;
		for(int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			if(map.containsKey(val)) {
				result[0] = i;
				result[1] = map.get(val);
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}
}
