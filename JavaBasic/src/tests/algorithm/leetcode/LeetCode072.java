package tests.algorithm.leetcode;

public class LeetCode072 {
	public int minDistance(String word1, String word2) {
		int[][] distance = new int[word1.length()+1][word2.length()+1];
		for(int i = 0; i <= word1.length(); i++) {
			distance[i][0] = i;
		}
		for(int j = 0; j <= word2.length(); j++) {
			distance[0][j] = j;
		}
		for(int i = 0; i < word1.length(); i++) {
			char c1 = word1.charAt(i);
			for(int j = 0; j < word2.length(); j++) {
				char c2 = word2.charAt(j);
				if(c1 == c2) {
					distance[i+1][j+1] = distance[i][j];
				} else {
					int insert = distance[i][j+1]+1;
					int replace = distance[i][j]+1;
					int delete = distance[i+1][j]+1;
					distance[i+1][j+1] = Math.min(insert, Math.min(replace, delete));
				}
			}
		}
		return distance[word1.length()][word2.length()];
	}
	public static void main(String[] args) {
		
	}
}
