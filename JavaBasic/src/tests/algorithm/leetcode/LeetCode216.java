// https://leetcode.com/problems/combination-sum-iii/

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode216 implements ILCSolution {
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		if(k == 1 && n <= 9){
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			innerList.add(n);
			ArrayList<List<Integer>> returnList = new ArrayList<List<Integer>>();
			returnList.add(innerList);
			return returnList;
		} else if(k == 0) {
			return new ArrayList<List<Integer>>();
		}
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i = 1; i <= n && i <= 9; i++) {
			List<List<Integer>> subList = combinationSum3(k - 1, n - i);
			for(List<Integer> innerList:subList) {
				innerList.add(0, i);
			}
		}
		
		return list;
	}

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
