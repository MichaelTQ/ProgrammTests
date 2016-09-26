package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode036 {
	private boolean isValidSubs(char[][] board) {
		Set<Character> set = new HashSet<Character>();
		int[]arr = {0, 3, 6};
		for(int x: arr) {
			for(int y: arr) {
				for(int i = x; i < x+3; i++) {
					for(int j = y; j < y+3; j++) {
						if(board[i][j] == '.') {
							continue;
						}
						if(!set.add(board[i][j])) {
							return false;
						}
					}
				}
				set.clear();
			}
		}
		return true;
	}
	private boolean isValidCol(char[][] board) {
		Set<Character> set = new HashSet<Character>();
		for(int col = 0; col < 9; col++) {
			for(int i = 0; i < 9; i++) {
				if(board[col][i] == '.') {
					continue;
				}
				if(!set.add(board[col][i])) {
					return false;
				}
			}
			set.clear();
		}
		return true;
	}
	private boolean isValidRow(char[][] board) {
		Set<Character> set = new HashSet<Character>();
		for(int row = 0; row < 9; row++) {
			for(int i = 0; i < 9; i++) {
				if(board[i][row] == '.') {
					continue;
				}
				if(!set.add(board[i][row])) {
					return false;
				}
			}
			set.clear();
		}
		return true;
	}
	public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidCol(board) && isValidSubs(board);
    }
	public static void main(String[] args) {
		String[] boardStr = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char [][] board = new char[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				board[i][j] = boardStr[i].charAt(j);
			}
		}
		System.out.println(new LeetCode036().isValidSudoku(board));
	}
}
