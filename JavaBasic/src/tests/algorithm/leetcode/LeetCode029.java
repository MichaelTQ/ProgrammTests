package tests.algorithm.leetcode;

public class LeetCode029 {
	// 
    public int divide(int dividend, int divisor) {
    	if(divisor == 0) return Integer.MAX_VALUE;
    	if(divisor == -1 && dividend == Integer.MIN_VALUE) {
    		return Integer.MAX_VALUE;
    	}
    	long pDivident = Math.abs((long)dividend);
    	long pDivisor = Math.abs((long)divisor);
    	int result = 0;
    	while(pDivident >= pDivisor) {
    		int numShift = 0;
    		while(pDivident>=(pDivisor<<numShift)) {
    			numShift++;
    		}
    		result += 1<<(numShift-1);
    		pDivident -= (pDivisor<<(numShift-1));
    	}
    	if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)) {
    		return result;
    	} else {
    		return -result;
    	}
    }
	public static void main(String[] args) {
		
	}
}
