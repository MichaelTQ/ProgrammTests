package tests.algorithm.leetcode;

public class LeetCode062 {
	public int uniquePaths(int m, int n) {
		int[][] map = new int[m][n];
		if(m <= 0 || n <= 0) return 0;
		if(m == 1 || n == 1) return 1;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 || j == 0) {
					map[i][j] = 1;
				} else {
					map[i][j] = map[i-1][j] + map[i][j-1]; 
				}
			}
		}
		return map[m-1][n-1];
    }
	
	public static void main(String[] args) {
		
	}
}
