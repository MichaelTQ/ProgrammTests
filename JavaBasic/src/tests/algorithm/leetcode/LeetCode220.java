// Contains Duplicate III:
// URL: https://leetcode.com/problems/contains-duplicate-iii/
// This need to be fixed, now it is O(n*n), BAD.

package tests.algorithm.leetcode;

public class LeetCode220 implements ILCSolution {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
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
