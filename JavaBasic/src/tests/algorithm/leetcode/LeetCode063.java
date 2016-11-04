package tests.algorithm.leetcode;

public class LeetCode063 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null) return 0;
		int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(i == 0) {
					if(isNObstacled(i, obstacleGrid)) {
						map[i][j] = 0;
					} else {
						map[i][j] = 1;
					}
				} else if(j == 0) {
					if(isMObstacled(j, obstacleGrid)) {
						map[i][j] = 0;
					} else {
						map[i][j] = 1;
					}
				} else if(isMObstacled(i, obstacleGrid)) {
					if(isNObstacled(j, obstacleGrid)) {
						map[i][j] = 0;
					} else {
						map[i][j] = map[i][j-1];
					}
				} else if(isNObstacled(j, obstacleGrid)) {
					map[i][j] = map[i-1][j];
				} else {
					map[i][j] = map[i-1][j] + map[i][j-1];
				}
			}
		}
		return map[obstacleGrid.length-1][obstacleGrid[0].length-1];
	}
	
	private boolean isMObstacled(int m, int[][] grid) {
		for(int j = 0; j < grid[m].length; j++) {
			if(grid[m][j] == 1) return true;
		}
		return false;
	}
	
	private boolean isNObstacled(int n, int[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			if(grid[i][n] == 1) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] grid = {
				{0, 0},
				{1, 0},
		};
		
		System.out.println(new LeetCode063().uniquePathsWithObstacles(grid));
	}
}
