package tests.algorithm.leetcode;

public class LeetCode059 {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		if(n <= 0) {
			return result;
		}
		int left = 0;
		int right = n-1;
		int up = 0;
		int down = n-1;
		int val = 1;
		while(left <= right && up <= down) {
			for(int i = left; i <= right; i++, val++) {
				result[up][i] = val;
			}
			up++;
			for(int i = up; i <= down; i++, val++) {
				result[i][right] = val;
			}
			right--;
			for(int i = right; i >= left; i--, val++) {
				result[down][i] = val;
			}
			down--;
			for(int i = down; i >= up; i--, val++) {
				result[i][left] = val;
			}
			left++;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] testCases = {
				0,
				1,
				2,
				3
		};
		for(int test: testCases) {
			int[][] result = new LeetCode059().generateMatrix(test);
			printMatrix(result);
		}
	}
	private static void printMatrix(int[][] result) {
		for(int i = 0; i < result.length; i++) {
			System.out.print("[");
			for(int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.println("]");
		}
		System.out.println("==========================");
	}
}
