package tests.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode047 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this.permuteUnique(nums, 0, result);
		return result;
    }
	
	private void permuteUnique(int[] num, int start, List<List<Integer>> result) {
		if(start >= num.length) {
			List<Integer> item = convertList(num);
			result.add(item);
		}
		for(int i = start; i<num.length; i++) {
			if(containsDuplicate(num, start, i)) {
				this.swap(num, start, i);
				permuteUnique(num, start+1, result);
				this.swap(num, start, i);
			}
		}
	}
	
	private boolean containsDuplicate(int[] num, int start, int end) {
		for(int i = start; i < end; i++) {
			if(num[i] == num[end]) {
				return false;
			}
		}
		return true;
	}
	
	private List<Integer> convertList(int[] num) {
		List<Integer> item = new ArrayList<Integer>();
		for(int i = 0; i < num.length; i++) {
			item.add(num[i]);
		}
		return item;
	}
	
	private void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	public static void main(String[] args) {
//		int[] nums = {1, 2, 3};
		int[] nums = {1, 2, 1};
//		int[] nums = {1, 1, 2};
		List<List<Integer>> list = new LeetCode047().permuteUnique(nums);
		for(List<Integer>l:list) {
			System.out.print("[");
			for(int v:l){
				System.out.print(v + ", ");
			}
			System.out.println("]");
		}
	}
}
