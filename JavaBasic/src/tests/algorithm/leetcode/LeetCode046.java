package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode046 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if(nums == null) return result;
        if(nums.length == 0) {
        	return result;
        }
        if(nums.length == 1) {
        	List<Integer> elem = new ArrayList<Integer>();
        	elem.add(nums[0]);
        	result.add(elem);
        	return result;
        }
        int[] subNums = Arrays.copyOfRange(nums, 1, nums.length);
        List<List<Integer>> subList = permute(subNums);
        result = new ArrayList<List<Integer>>();
        for(List<Integer> l: subList) {
        	for(int i = 0; i<l.size()+1; i++) {
            	List<Integer> elem = new ArrayList<Integer>(l);
        		elem.add(i, nums[0]);
        		result.add(elem);            		
        	}
        }
        return result;
    }

	public static void main(String[] args) {
//		int[] nums = {1, 2, 3};
		int[] nums = {1, 2, 3};
		List<List<Integer>> list = new LeetCode046().permute(nums);
		for(List<Integer>l:list) {
			System.out.print("[");
			for(int v:l){
				System.out.print(v + ", ");
			}
			System.out.println("]");
		}
	}
}
