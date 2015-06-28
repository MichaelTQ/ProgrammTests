package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> listRtn = new ArrayList<String>();
		
		if(nums.length == 0) {
			listRtn.add("");
		}
		
		int startInd = 0;
		int endInd = 0;
		
		
		
		return listRtn;
	}
	
	public void myPrint(List<String> lstResult) {
		System.out.print("The results are: ");
		for(String s:lstResult) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
}
