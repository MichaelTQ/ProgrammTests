package tests.algorithm.leetcode;

public class LeetCode217 implements ILCSolution {
	
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0) {
			return false;
		}
		
		java.util.HashSet<Integer> set = new java.util.HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(!set.add(nums[i])) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
