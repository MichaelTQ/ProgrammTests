// Contains Duplicate II Problem
// URL: https://leetcode.com/problems/contains-duplicate-ii/

package tests.algorithm.leetcode;

//import java.util.*;

public class LeetCode219 implements ILCSolution {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length <= 1) {
			return false;
		}
		
		java.util.Hashtable<Integer, Integer> tableValueKey = new java.util.Hashtable<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(tableValueKey.containsKey(nums[i])) {
				if(i - tableValueKey.get(nums[i]) <= k) {
					return true;
				} else {
					tableValueKey.put(nums[i], i);
				}
			} else {
				tableValueKey.put(nums[i], i);
			}
		}
		
		
		return false;
	}

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
