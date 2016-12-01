package tests.algorithm.leetcode;

public class LeetCode097_InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) return false;
		
		boolean [][] interleaved = new boolean[s1.length()+1][s2.length()+1];
		interleaved[0][0] = true;
		
		for (int i = 1; i <= s1.length(); i++) {
			if(s3.charAt(i-1) == s1.charAt(i-1) && interleaved[i-1][0]) {
				interleaved[i][0] = true;
			}
		}
		
		for(int i = 1; i <= s2.length(); i++) {
			if(s3.charAt(i-1) == s2.charAt(i-1) && interleaved[0][i-1]) {
				interleaved[0][i] = true;
			}
		}
		
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if((s3.charAt(i+j-1)==s1.charAt(i-1) && interleaved[i-1][j]) ||
						(s3.charAt(i+j-1)==s2.charAt(j-1) && interleaved[i][j-1])) {
					interleaved[i][j] = true;
				}
			}
		}
		
		return interleaved[s1.length()][s2.length()];
	}
	public static void main(String[] args) {
		String[][] testCases = {
				{"aabcc", "bddca", "aadbbcbcac"},
				{"aabcc", "bddca", "aadbbbaccc"},
		};
		
		for(String[] strs: testCases) {
			String s1 = strs[0];
			String s2 = strs[1];
			String s3 = strs[2];
			System.out.println("s1: " + s1 + " s2: " + s2 + " s3: " + s3);
			System.out.println("Result: " + new LeetCode097_InterleavingString().isInterleave(s1, s2, s3));
		}
	}
}
