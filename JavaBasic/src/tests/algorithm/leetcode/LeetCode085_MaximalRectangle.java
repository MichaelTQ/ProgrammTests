package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode085_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null) return 0;
		int n = matrix.length;
		int m = matrix[0].length;
		if(n == 0 || m == 0) return 0;
		int maxArea = 0;
		int[][]height = new int[m][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(matrix[i][j] == '0') {
					height[i][j] = 0;
				} else {
					height[i][j] = i == 0?1:height[i-1][j]+1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			int area = getArea(height[i]);
			if(maxArea < area) {
				maxArea = area;
			}
		}
		
		return maxArea;
	}
	
	private int getArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		while(i < height.length) {
			if(stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else{
				int t = stack.pop();
				max = Math.max(max, height[t] * (stack.isEmpty()?i:i-stack.peek()-1));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		
	}
}
