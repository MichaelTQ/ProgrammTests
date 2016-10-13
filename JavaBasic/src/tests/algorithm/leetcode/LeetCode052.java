package tests.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode052 {
	public int totalNQueens(int n) {
		List<List<String>> resultList = new ArrayList<List<String>>();
		if (n <= 0) {
			return 0;
		}
		int[] row = new int[n];
		solveNQueensCore(resultList,row, n, 0);
		return resultList.size();
	}
	
	private void solveNQueensCore(List<List<String>> resultList, int[] row, int n, int index) {
		if(index == n) {
			List<String> singleResult = translateString(row);
			resultList.add(singleResult);
			return;
		}
		for(int i = 0; i < n; i++) {
			if(isValid(row, index, i)) {
				row[index] = i;
				solveNQueensCore(resultList, row, n, index+1);
				row[index] = 0;
			}
		}
	}
	
	private List<String> translateString(int[] row) {
		List<String> resultList = new ArrayList<String>();
		for(int i = 0; i < row.length; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < row.length; j++) {
				if(j == row[i]) sb.append("Q");
				else sb.append(".");
			}
			resultList.add(sb.toString());
		}
		return resultList;
	}
	
	private boolean isValid(int[] row, int rowNum, int columnNum) {
		for(int i = 0; i < rowNum; i++) {
			if(row[i] == columnNum) return false;
			if(Math.abs(row[i] - columnNum) == Math.abs(i - rowNum)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		
	}
}
