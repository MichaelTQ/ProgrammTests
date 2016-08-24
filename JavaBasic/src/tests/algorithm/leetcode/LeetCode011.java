/**
 * Container with most water problem
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * */

package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode011 {
	public int maxArea(int[] height) {
		if(height == null || height.length <= 1) return 0;
		int maxArea = 0;
		int indStart = 0;
		int indEnd = height.length-1;
		int prevStartHeight = 0;
		int prevEndHeight = 0;
		while(indStart<indEnd) {
			int minHeight = height[indStart]<height[indEnd]?height[indStart]:height[indEnd];
			int curArea = minHeight*(indEnd-indStart);
			prevStartHeight = height[indStart];
			prevEndHeight = height[indEnd];
			if(curArea > maxArea) {
				maxArea = curArea;
			}
			if(height[indStart] < height[indEnd]) {
				while(height[indStart] <= prevStartHeight && indStart<indEnd) indStart++;
			} else {
				while(height[indEnd] <= prevEndHeight && indStart<indEnd) indEnd--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		List<TestCase> list = new ArrayList<TestCase>();
		list.add(new TestCase(new int[]{1, 1}, 1));
		list.add(new TestCase(new int[]{0, 2}, 0));
		list.add(new TestCase(new int[]{1, 2}, 1));
		list.add(new TestCase(new int[]{1,2,4,3}, 4));
		
		for(TestCase test: list) {
			System.out.print("Input: ");
			TestUtils.printArr(test.arr);
			System.out.println("Expected: " + test.expected);
			int actual = new LeetCode011().maxArea(test.arr);
			System.out.println("Actual: " + actual);
			System.out.println("Pass? " + (actual==test.expected));
			System.out.println("=================");
		}
	}
	
	static class TestCase {
		int[] arr;
		int expected;
		
		public TestCase(int[] arr, int expected) {
			this.arr = arr;
			this.expected = expected;
		}
	}
}
