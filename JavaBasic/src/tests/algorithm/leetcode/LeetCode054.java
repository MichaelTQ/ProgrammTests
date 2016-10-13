package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode054 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0) return result;
		int up = 0;
		int down = matrix.length;
		int left = 0;
		int right = matrix[0].length;
		while(up < down && left < right) {
			if(left==right-1) {
				for(int i = up; i < down; i++) result.add(matrix[i][left]);
				break;
			}
			if(up == down-1) {
				for(int i = left; i < right; i++) result.add(matrix[up][i]);
				break;
			}
			for(int i = left; i < right; i++) {
				result.add(matrix[up][i]);
			}
			up++;
			for(int i = up; i < down; i++) {
				result.add(matrix[i][right-1]);
			}
			right--;
			for(int i = right-1; i >= left; i--) {
				result.add(matrix[down-1][i]);
			}
			down--;
			for(int i = down-1; i >= up; i--) {
				result.add(matrix[i][left]);
			}
			left++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][][] matrixes = {
				{
					{1, 2, 3},
					{4, 5, 6},
					{7, 8, 9},
				},
				{
					{1},
				},
				{
					{1, 2, 3, 7},
					{4, 5, 6, 8},
				},
				{
					{1, 2},
					{3, 4},
					{5, 6},
				},
				{
					{2, 3},
				},
				{
					{1},
					{3},
					{5},
				},
				{
					{1, 2, 3, 4},
					{5, 6, 7, 8},
					{9, 10, 11, 12},
				},
		};
		
		for(int[][]matrix: matrixes) {
			List<Integer> result = new LeetCode054().spiralOrder(matrix);
			for(int v: result) {
				System.out.print(v + ", ");
			}
			System.out.println();
			System.out.println("==============");
		}
	}
}
