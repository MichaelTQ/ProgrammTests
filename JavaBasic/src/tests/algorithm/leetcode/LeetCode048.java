package tests.algorithm.leetcode;

public class LeetCode048 {
	public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length/2; i++) {
        	for(int j = 0; j < Math.ceil((double)matrix.length/2); j++) {
        		int iNew1 = j;
        		int jNew1 = matrix.length-1-i;
        		int iNew2 = matrix.length-i-1;
        		int jNew2 = matrix.length-j-1;
        		int iNew3 = matrix.length-1-j;
        		int jNew3 = i;
        		
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[iNew3][jNew3];
        		matrix[iNew3][jNew3] = matrix[iNew2][jNew2];
        		matrix[iNew2][jNew2] = matrix[iNew1][jNew1];
        		matrix[iNew1][jNew1] = tmp;
        	}
        }
    }
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
		};
		new LeetCode048().rotate(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
