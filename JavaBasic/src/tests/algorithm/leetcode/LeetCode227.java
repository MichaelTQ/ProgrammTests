// calcuate(String s) method is the solution of the following Question:
// https://leetcode.com/problems/basic-calculator-ii/
// Author: Michael Tong

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode227 implements ILCSolution {
	private int result;
	private String expression;
	
	public LeetCode227() {
		result = 0;
		expression = null;
	}
	
	public LeetCode227(String expression) {
		this.expression = expression;
		this.result = this.calculate(expression);
	}
	
	public int calculate(String s) {
		final char PLUS = '+';
		final char MULT = '*';
		final char SUB = '-';
		final char DIV = '/';
		
		List<Long> lstSum = new ArrayList<Long>();
		
		int startInd = 0;
		long tmpResult = 0;
		char preExp = '0';
		char prePlusSub = '0';
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == MULT || c == DIV) {
				String num = s.substring(startInd, i);
				long curValue = Long.parseLong(num.trim());
				if(preExp != '0') {
					if(preExp == '*') {
						tmpResult = tmpResult * curValue;
					} else if (preExp == '/') {
						tmpResult = tmpResult / curValue;
					}
				} else {
					tmpResult = curValue;
				}
				preExp = c;
				startInd = i + 1;
			} else if (c == SUB || c == PLUS) {
				String num = s.substring(startInd, i);
				long curValue = Long.parseLong(num.trim());
				if(preExp != '0') {
					if(preExp == '*') {
						curValue = tmpResult*curValue;
					} else if (preExp == '/') {
						curValue = tmpResult/curValue;
					}
				}
				
				if(prePlusSub == '-') {
					lstSum.add(0 - curValue);
				} else {
					lstSum.add(curValue);
				}
				
				if(c == PLUS) {
					prePlusSub = '+';
				} else if (c == SUB){
					prePlusSub = '-';
				}
				preExp = '0';
				startInd = i + 1;
			} else {
				if (i == s.length() - 1) {
					String num = s.substring(startInd, s.length());
					long curValue = Long.parseLong(num.trim());
					if(preExp != '0') {
						if(preExp == '*') {
							curValue = tmpResult * curValue;
						} else if(preExp == '/'){
							curValue = tmpResult / curValue;
						}
					}
					
					if(prePlusSub == '-') {
						lstSum.add(0 - curValue);
					} else {
						lstSum.add(curValue);
					}
				} else {
					continue;
				}
			}
		}
		
		long iResult = 0;
		for(long i:lstSum) {
			iResult = i + iResult;
		}
		
		return (int)iResult;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public void myPrint() {
		System.out.println();
		System.out.print(this.getClass().getSimpleName() + " --- The result is: ");
		System.out.println(this.result);
	}

}
