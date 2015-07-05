package tests.algorithm.leetcode;

public class LeetCode221 implements ILCSolution {
	
	public int maximalSquare(char[][] matrix) {
		if(matrix == null) {
			return 0;
		}
		
		if(matrix.length == 0) {
			return 0;
		}
		
		int width = matrix[0].length;
		int height = matrix.length;
		
		int max = 0;
		
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(matrix[i][j] == '0') {
					continue;
				} else {
					if(max < 1) {
						max = 1;
					}
					int j0 = j;
					int i0 = i;
					check1: {
						for(; j0 < width; j0++) {
							for(; i0 < height && i0 - i < j0 - j; i0++) {
								if(matrix[i0][j0] == '0') {
									break check1;
								}
							}
						}
					}
					if(i0 == height - 1 && j0 == width - 1 && matrix[i0][j0] == '1') {
						i0++;
						j0++;
					}
					int tmpLength = (i0 - i)<(j0 - j)?(i0 - i):(j0 - j);
					int tmp = tmpLength*tmpLength;
					max = max>tmp?max:tmp;
				}
			}
		}
		
		return max;
	}

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
