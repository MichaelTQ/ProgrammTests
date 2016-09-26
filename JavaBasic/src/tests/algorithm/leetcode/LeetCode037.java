package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode037 {
	public boolean isValid(char[][] board, int a, int b){
        Set<Character> contained = new HashSet<Character>();
        for(int j=0;j<9;j++){
            if(contained.contains(board[a][j])) return false;
            if(board[a][j]>'0' && board[a][j]<='9')
                contained.add(board[a][j]);
        }
        
        contained = new HashSet<Character>();
        for(int j=0;j<9;j++){
            if (contained.contains(board[j][b])) {
                return false;
            }
            if (board[j][b]>'0' && board[j][b]<='9') {
                contained.add(board[j][b]);
            }
        }
        
        contained = new HashSet<Character>();
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++){
                int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
                if (contained.contains(board[x][y])) {
                    return false;
                }
                if (board[x][y] > '0' && board[x][y] <= '9') {
                        contained.add(board[x][y]);
                }
            } 
        }
    
        return true;
    }
	public boolean solve(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] != '.') continue;
				for(int k = 0; k < 9; k++) {
					board[i][j] = (char)(k+'1');
					if(isValid(board, i, j) && solve(board)) {
						return true;
					}
					board[i][j] = '.';
				}
				return false;
			}
		}
		return true;
	}
    public void solveSudoku(char[][] board) {
    	solve(board);
    }
	
	public static void main(String[] args) {
		String[][] testCases = {
				{
					"..9748...",
					"7........",
					".2.1.9...",
					"..7...24.",
					".64.1.59.",
					".98...3..",
					"...8.3.2.",
					"........6",
					"...2759.."},
			};
		for(String[] testCase: testCases) {
			char[][] board = new char[9][9];
			for(int i = 0; i < testCase.length; i++) {
				String s = testCase[i];
				for(int j = 0; j < s.length(); j++) {
					char c = s.charAt(j);
					board[i][j] = c;
				}
			}
			new LeetCode037().solveSudoku(board);
			for(int i = 0; i < board.length; i++) {
				System.out.print("[");
				for(int j = 0; j < board[0].length; j++) {
					System.out.print(board[i][j] + ", ");
				}
				System.out.println("]");
			}
		}
	}
}
