package tests.algorithm.leetcode;

public class LeetCode223 implements ILCSolution {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int xA1 = this.getSmaller(A, C);
		int xA2 = this.getBigger(A, C);
		int yA1 = this.getSmaller(B, D);
		int yA2 = this.getBigger(B, D);
		
		int xB1 = this.getSmaller(E, G);
		int xB2 = this.getBigger(E, G);
		int yB1 = this.getSmaller(F, H);
		int yB2 = this.getBigger(F, H);
		
		int common = 0;
		int aArea = (xA2 - xA1) * (yA2 - yA1);
		int bArea = (xB2 - xB1) * (yB2 - yB1);
		
		if(xA1 <= xB1 && xB1 < xA2) {
			int xTmp = this.getSmaller(xB2, xA2);
			if(yA1 <= yB1 && yB1 < yA2) {
				int yTmp = this.getSmaller(yB2, yA2);
				common = (xTmp - xB1)*(yTmp - yB1);
			} else if (yB1 <= yA1 && yA1 < yB2) {
				int yTmp = this.getSmaller(yA2, yB2);
				common = (xTmp - xB1)*(yTmp - yA1);
			}
		} else if(xB1 <= xA1 && xA1 < xB2) {
			int xTmp = this.getSmaller(xA2, xB2);
			if(yA1 <= yB1 && yB1 < yA2) {
				int yTmp = this.getSmaller(yB2, yA2);
				common = (xTmp - xA1)*(yTmp - yB1);
			} else if (yB1 <= yA1 && yA1 < yB2) {
				int yTmp = this.getSmaller(yA2, yB2);
				common = (xTmp - xA1)*(yTmp - yA1);
			}
		}
		
		return aArea + bArea - common;
	}
	
	private int getSmaller(int a, int b) {
		if(a < b) {
			return a;
		} else {
			return b;
		}
	}
	
	private int getBigger(int a, int b) {
		if(a < b) {
			return b;
		} else {
			return a;
		}
	}
	
	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
