package tests.algorithm.leetcode;

import java.util.List;
import java.util.ArrayList;

public class LeetCode015 {
		public List<List<Integer>> threeSum2(int[] num) {
		
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if(num == null || num.length < 3) {
			return rst;
		}
		java.util.Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					rst.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to skip duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return rst;
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length == 0) {
    		return result;
    	}
        java.util.Arrays.sort(nums);
        int indSt = 0;
        int indEd = nums.length - 1;
        while(indSt < indEd) {
        	List<Integer> elm = new ArrayList<Integer>();
        	int indTmp = indSt+1;
        	int valSt = nums[indSt];
        	int valEd = nums[indEd];
        	int exp = 0 - valSt - valEd;
        	if(valSt > 0 || valEd < 0) {
        		break;
        	}
        	while(indTmp < indEd) {
        		if(exp == nums[indTmp]) {
        			elm.add(valSt);
        			elm.add(exp);
        			elm.add(valEd);
        			if(!result.contains(elm)) {
        				result.add(elm);
        			}
        			elm = new ArrayList<Integer>();
        		}
        		indTmp++;
        	}
        	if(valSt + valEd + nums[indTmp] < 0) {
        		indSt++;
        	} else {
        		indEd--;
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		int testCases[][] = {
			{-1, 0, 1, 2, -1, -4},
			{0, 0, 0, 0},
			{-2, 0, 1, 1, 2},
			{-2, -1, -1, 0, 2},
		};
		for(int[] testCase: testCases) {
			List<List<Integer>> result = new LeetCode015().threeSum2(testCase);
			LeetCode015.printResult(result);
		}
	}
	
	private static void printResult(List<List<Integer>> result) {
		for(List<Integer> list: result) {
			System.out.print("[");
			for(Integer val:list) {
				System.out.print(val + ", ");
			}
			System.out.print("]");
		}
		System.out.println();
	}
}
