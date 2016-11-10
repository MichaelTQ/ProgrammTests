package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode077 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(k <= 0 || n <= 0) return result;
		List<Integer> item = new ArrayList<Integer>();
		helper(result, item, n, k, 1);
		return result;
	}
	
	public void helper(List<List<Integer>> result, List<Integer> item, int n, int k, int i) {
		if(item.size() == k) {
			List<Integer> newItem = new ArrayList<Integer>(item);
			result.add(newItem);
		} else {
			for(int j = i; j <= n; j++) {
				item.add(j);
				helper(result, item, n, k, j+1);
				item.remove(item.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> result = new LeetCode077().combine(4, 2);
		for(int i = 0; i < result.size(); i++) {
			System.out.print("[");
			for(int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + ", ");
			}
			System.out.println("]");
		}
		System.out.println("====================");
	}
}
