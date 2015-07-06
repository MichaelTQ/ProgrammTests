package tests.algorithm.leetcode;

import java.util.*;

public class ForRamdomTests {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 9, 5};
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		for(int val:arr) {
			treeSet.add(val);
		}
		
		for(int val:treeSet) {
			System.out.println(val);
		}
		
		System.out.println("================");
		
		System.out.println( treeSet.headSet(3) );
		
		System.out.println( treeSet.headSet(3).getClass() );
		
		System.out.println( treeSet.tailSet(3) );
		
		System.out.println( treeSet.ceiling(4) );
		
		System.out.println( treeSet.floor(4) );
		
	}
}
