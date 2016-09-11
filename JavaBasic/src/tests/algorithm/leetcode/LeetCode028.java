package tests.algorithm.leetcode;

public class LeetCode028 {
	// TODO: I need to learn KMP Algorithm
    public int strStr(String haystack, String needle) {
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
				{"aaa", "a"}
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
