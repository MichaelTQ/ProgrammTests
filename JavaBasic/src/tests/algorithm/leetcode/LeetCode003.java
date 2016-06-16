/**
 * LeetCode002 - Length of Longest Substring Without Repeating Characters:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

package tests.algorithm.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class LeetCode003 {

	@Test
	public void test() {
		TestCase[] testCases = {
				new TestCase("abcabcbb", 3),
				new TestCase("bbbbb", 1),
				new TestCase("pwwkew", 3),
				new TestCase("abac", 3),
				new TestCase("aabcde", 5),
		};
		for(TestCase c: testCases) {
			String str = c.str;
			int expected = c.expected;
			try {
				assertTrue(c.str + " expected: " + c.expected + " wrongAnswer: " + lengthOfLongestSubstring(str)
						, expected == lengthOfLongestSubstring(str));
				assertTrue(c.str + " expected: " + c.expected + " wrongAnswer: " + lengthOfLongestSubstringMine(str)
						, expected == lengthOfLongestSubstringMine(str));
			} catch(AssertionError e) {
				e.printStackTrace();
				
			}
		}
	}
	
	public int lengthOfLongestSubstringMine(String s) {
		if(s == null || s.length() == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLen = 0;
		int startInd = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				if(maxLen < i - startInd) maxLen = i - startInd;
				if(startInd < map.get(c) + 1) startInd = map.get(c) + 1;
			}
			map.put(c, i);
		}
		if(maxLen < s.length() - startInd) maxLen = s.length() - startInd;
		return maxLen;
	}
	
	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0) return 0;

        int[] letters=new int[128];
        for(int i=0;i<letters.length;i++) {
            letters[i]=-1;
        }
        int start=0;
        int maxLen=0;

        for(int i=0;i<s.length();i++) {
          int idx=(int)s.charAt(i)-0;
          if(letters[idx]!=-1) {
              start=letters[idx]+1;
              resetArray(letters,start-1);
          }
          letters[idx]=i;
          maxLen=Math.max(maxLen,(i-start)+1);
        }
        return maxLen;
	}

	private void resetArray(int[] arr,int index) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=index) {
                arr[i]=-1;
            }
        }
    }
	
	@SuppressWarnings("unused")
	private int lengthOfLongestSubstringSlow(String s) {
		if(s == null || "".equals(s)) {
			return 0;
		}
		int maxLength = 0;
		for(int i = 0; i < s.length(); i++) {
			int length = 0;
			int j = i;
			Set<Character> set = new HashSet<Character>();
			while(j < s.length()) {
				char c = s.charAt(j);
				if(set.add(c)) {
					j++;
					length++;
				} else {
					break;
				}
			}
			if(length > maxLength) maxLength = length;
		}
		return maxLength;
	}
	
	class TestCase {
		String str;
		int expected;
		public TestCase(String str, int expected) {
			this.str = str;
			this.expected = expected;
		}
	}
}


