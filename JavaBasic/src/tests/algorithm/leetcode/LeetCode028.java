package tests.algorithm.leetcode;

public class LeetCode028 {
	public int strStr(String txt, String pat) {
		if(pat.equals("")) {
			return 0;
		}
		int lps[] = new int[pat.length()];
		int j = 0;
		computeLPSArray(pat, lps);
		for(int i = 0; i < txt.length(); i++) {
			while(j > 0 && txt.charAt(i) != pat.charAt(j)) {
				j = lps[j-1];
			}
			if (txt.charAt(i) == pat.charAt(j)) {
				j++;
				if(j == pat.length()) return i - j + 1;
			}
		}
		return -1;
	}
	private void computeLPSArray(String pat, int lps[]) {
		lps[0] = 0;
		for(int i = 1; i < lps.length-1; i++) {
			int j = lps[i-1];
			while(j > 0 && pat.charAt(i) != pat.charAt(j)) {
				j = lps[j-1];
			}
			if(pat.charAt(i) == pat.charAt(j)) {
				j++;
			}
			lps[i] = j;
		}
	}
	// TODO: I need to learn KMP Algorithm
    public int strStrDumb(String haystack, String needle) {
    	if (haystack.equals(needle) || needle.equals("")) {
    		return 0;
    	}
    	int pos = -1;
    	for(int i = 0; i < haystack.length(); i++) {
    		for(int j = 0; j < needle.length(); j++) {
    			if(i+j > haystack.length()-1) {
    				break;
    			}
    			if(needle.charAt(j) != haystack.charAt(i+j)) {
    				break;
    			} else {
    				if(j == needle.length()-1 &&
   						needle.charAt(j) == haystack.charAt(i+j)) {
    					pos = i;
    				}
    			}
    		}
    		if(pos != -1) {
    			break;
    		}
    	}
        return pos;
    }
	public static void main(String[] args) {
		String[][] testCases = {
				{"abcd", "bcd"},
				{"abcd", "efg"},
				{"aaa", "aa"},
				{"aaa", "a"},
				{"", ""},
				{"mississippi", "issip"},
		};
		for(String[] testCase: testCases) {
			String haystack = testCase[0];
			String needle = testCase[1];
			System.out.print("Inputs:\t\t");
			System.out.println(haystack + ", " + needle);
			System.out.print("Results:\t");
			System.out.println(new LeetCode028().strStr(haystack, needle));
			System.out.println("==============================");
		}
	}
}
