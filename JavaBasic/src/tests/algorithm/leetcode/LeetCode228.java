// summaryReanges(int[] nums) method is the solution of the following Question:
// https://leetcode.com/problems/summary-ranges/
// Author: Michael Tong

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode228 implements ILCSolution {
	private List<String> lstResult;
	
	public LeetCode228() {
		this.lstResult = new ArrayList<String>();
	}
	
	public LeetCode228(int[] nums) {
		this.lstResult = this.summaryRanges(nums);
	}
	
	public List<String> summaryRanges(int[] nums) {
		List<String> lstReturn = new ArrayList<String>();
		
		if(nums.length == 0) {
			return lstReturn;
		}
		
		int preValue = nums[0];
		int nextValue = nums[0];
		
		for(int i = 0; i < nums.length; i++) {
			if(i<nums.length-1) {
				nextValue = nums[i+1];
				if(nextValue != nums[i]+1) {
					if(preValue != nums[i]) {
						lstReturn.add(new Integer(preValue).toString() + "->" + new Integer(nums[i]).toString());
					} else {
						lstReturn.add(new Integer(preValue).toString());
					}
					preValue = nums[i+1];
					nextValue = nums[i+1];
				} else {
					continue;
				}
			} else {
				if(preValue != nums[i]) {
					lstReturn.add(new Integer(preValue).toString() + "->" + new Integer(nums[i]).toString());
				} else {
					lstReturn.add(new Integer(preValue).toString());
				}
			}
		}
		
		return lstReturn;
	}
	
	@Override
	public void myPrint() {
		System.out.println();
		System.out.print(this.getClass().getSimpleName() + " --- The results are: ");
		for(int i = 0; i < lstResult.size(); i++) {
			if(i != lstResult.size() - 1) {
				System.out.print(lstResult.get(i) + ", ");
			}
			else {
				System.out.println(lstResult.get(i));
			}
		}
	}
}
