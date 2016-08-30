package tests.algorithm.leetcode;

public class LeetCode014 {
	private boolean isCharSameAtInd(int ind, String[] strs) {
		char c;
		if (strs[0].length() <= ind) {
			return false;
		} else {
			c = strs[0].charAt(ind);
		}
		for(int i = 0; i < strs.length; i++) {
			String str = strs[i];
			if (str.length() <= ind) {
				return false;
			} else if (c == str.charAt(ind)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int ind = 0;
		while(isCharSameAtInd(ind, strs)) {
			ind++;
		}
		return strs[0].substring(0, ind);
    }
	public static void main(String[] args) {
		String[][] testCases = {
				{"aabcc", "aabccdeds"},
		};
		for(int i = 0; i < testCases.length; i++) {
			String[] testCase = testCases[i];
			System.out.println(new LeetCode014().longestCommonPrefix(testCase));
		}
	}
}
