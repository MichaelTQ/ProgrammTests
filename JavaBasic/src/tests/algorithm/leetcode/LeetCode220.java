// Contains Duplicate III:
// URL: https://leetcode.com/problems/contains-duplicate-iii/
// This need to be fixed, now it is O(n*n), BAD.

package tests.algorithm.leetcode;

public class LeetCode220 implements ILCSolution {
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		java.util.TreeSet<Integer> treeSet = new java.util.TreeSet<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			int floor = nums[i] - t;
			int ceiling = nums[i] + t + 1;
			
			if ((long) nums[i] - (long) (t) < -2147483647) floor = Integer.MIN_VALUE;
            if ((long) nums[i] + (long) (t) + 1 > 2147483646)  ceiling = Integer.MAX_VALUE;
			
			if(t >= 0 && !treeSet.subSet(floor, ceiling).isEmpty()) {
				return true;
			}
			
			treeSet.add(nums[i]);
			
			if(i >= k) {
				treeSet.remove(nums[i - k]);
			}
		}
		
		return false;
	}
	
	public boolean containsNearbyAlmostDuplicateBad(int[] nums, int k, int t) {
		if(nums == null || nums.length <= 1) {
			return false;
		}
		
		java.util.Arrays.sort(nums);
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
				if(j == i) {
					continue;
				} else {
					if(j - i <= k && nums[j] - nums[i] <= t) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
