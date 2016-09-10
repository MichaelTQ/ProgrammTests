package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode020 {
    public boolean isValid(String s) {
    	if(s == null || s.length()<=1) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if("[{(".indexOf(c) != -1) {
        		stack.push(c);
        	} else {
        		if(stack.isEmpty()) return false;
        		char top = stack.peek();
        		if(	(c == ']' && top == '[') ||
        			(c == ')' && top == '(') ||
        			(c == '}' && top == '{') ) {
        			stack.pop();
        		} else {
        			return false;
        		}
        	}
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    
	public static void main(String[] args) {
		String[] testCases = {
			"()",
			"()[]{}",
			"(]",
			"([)]",
		};
		
		for(String s: testCases) {
			System.out.println(s + ":\t\t" + new LeetCode020().isValid(s));
		}
	}

}
