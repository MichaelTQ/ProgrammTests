package tests.algorithm.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode017 {
	public List<String> combinationHelper(String[] strs) {
		List<String> list = new ArrayList<String>();
		if(strs.length==0) {
			return list;
		} else if(strs.length==1) {
			String[] arr = strs[0].split(""); 
//			arr = Arrays.copyOfRange(arr, 1, arr.length);
			list = Arrays.asList(arr);
			return list;
		} else {
			String[] subArr = Arrays.copyOfRange(strs, 0, strs.length-1);
			List<String> subList = combinationHelper(subArr);
			String s = strs[strs.length-1];
			List<String> returnList = new ArrayList<String>();
			for(int i = 0; i < s.length(); i++) {
				for(int j = 0; j < subList.size(); j++) {
					returnList.add(subList.get(j) + s.substring(i, i+1));
				}
			}
			return returnList;
		}
	}
    public List<String> letterCombinations(String digits) {
    	String[] numArr = {
    			"",
    			"abc",
    			"def",
    			"ghi",
    			"jkl",
    			"mno",
    			"pqrs",
    			"tuv",
    			"wxyz",
    	};
    	List<String> strList = new ArrayList<String>();
        for(int i = 0; i < digits.length(); i++) {
        	char c = digits.charAt(i);
        	int num = Integer.parseInt(new Character(c).toString());
        	if (num != 1) {
        		strList.add(numArr[num-1]);
        	}
        }
        List<String> result = combinationHelper(strList.toArray(new String[strList.size()]));
        return result;
    }

	public static void main(String[] args) {
		List<String> result = new LeetCode017().letterCombinations("2");
		for(String s: result) {
			System.out.print(s + ", ");
		}
		System.out.println();
		System.out.println(result.size());
	}

}
