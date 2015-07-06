package tests.algorithm.leetcode;

import binarytree.datastructure.MyBST;

public class MySolutionTests {
	public static void LC228Test() {
		int[][] nums = {
				{0, 1, 2, 4, 5, 7},
				{5},
				{1, 3, 4, 9},
				{},
		};
		for(int[] arr: nums) {
			ILCSolution lc228 = new LeetCode228(arr);
			lc228.myPrint();
		}
	}
	
	public static void LC227Test() {
		String[] expressions = {
				"1*3",
				"1+2",
				"1 * 3 - 5 / 7",
				"0-2147483648",
				"2-1",
				"2*3+4",
		};
		
		for(String expression:expressions) {
			ILCSolution lc227 = new LeetCode227(expression);
			lc227.myPrint();
		}
	}
	
	public static void LC226Test() {
		MyBST tree = new MyBST();
		tree.addNode(4);
		tree.addNode(2);
		tree.addNode(7);
		tree.addNode(9);
		tree.addNode(1);
		tree.addNode(3);
		tree.addNode(6);
		
		new MyBST( new LeetCode226(tree.getHead()).invertTreeRecursive(tree.getHead())).myPrintTree();
	}
	
	public static void LC224Test() {
		String[] arrTestCases = {
/*			"1 + 1",
			" 2-1 + 2 ",
			"(1+(4+5+2)-3)+(6+8)",
			"()",
			"(1)+(3)",
			"1-(2+3-(4+(5-(1-(2+4-(5+6))))))",
			"1 -1",
			"   (  3 ) ",*/
			"(5-(1+(5)))",
		};
		
		for(String s: arrTestCases) {
			System.out.println("\"" + s + "\"" + " => " + new LeetCode224().calculate(s));
		}
	}
	
	public static void LC223Test() {
		int testCases[][] = {
				{-3, 0, 3, 4, 0, -1, 9, 2},
				{0, 0, 0, 0, -1, -1, -1, -1},
				{0, 0, 0, 0, -1, -1, 1, 1},
				{-2, -2, 2, 2, -2, -2, 2, 2},
				{-2, -2, 2, 2, -3, 1, -1, 3},
				{-2, -2, 2, 2, 1, -3, 3, 3}
		};
		for(int []arr:testCases) {
			System.out.println(new LeetCode223().computeArea(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]) );
		}
	}
	
	public static void LC222Test() {
		MyBST tree = new MyBST();
		tree.addNode(4);
		tree.addNode(2);
		tree.addNode(7);
		//tree.addNode(9);
		tree.addNode(1);
		tree.addNode(3);
		tree.addNode(6);
		
		System.out.println(new LeetCode222().countNodes(tree.getHead()));
	}
	
	public static void LC221Test() {
		char[][][] matrixes = {
				{
					{'1', '0', '1', '0', '0'},
					{'1', '0', '1', '1', '1'},
					{'1', '1', '1', '1', '1'},
					{'1', '1', '1', '1', '1'},
					{'1', '1', '1', '1', '1'},
					{'1', '0', '1', '1', '1'}
				},
				{
					{'1', '0', '1', '0', '0'},
					{'1', '0', '1', '1', '1'},
					{'1', '1', '1', '1', '1'},
					{'1', '0', '0', '1', '0'}
				},
				{
					{'1'},
				},
				{
					{'0'},
				},
				{
					{'1', '1'},
					{'0', '0'},
				},
				{
					{'1', '1', '1', '1', '0'},
					{'1', '0', '1', '1', '1'},
					{'1', '1', '1', '1', '1'},
					{'1', '0', '1', '1', '1'},
					{'1', '1', '0', '1', '0'},
				},
				{
					{'1', '1'},
				},
				{
					{'0', '1'},
				},
				{
					{'1', '0'},
				},
				{
					{'0', '0'},
					{'1', '1'},
				},
				{
					{'1', '1'},
					{'1', '1'},
				},
				{
					{'1', '0', '1', '0', '0'},
					{'1', '0', '1', '1', '1'},
					{'1', '1', '1', '1', '1'},
					{'1', '0', '0', '1', '0'},
				},
		};
		for(char[][] matrix:matrixes) {
			System.out.println(new LeetCode221().maximalSquare(matrix));
		}
	}
	
	public static void LC220Test() {
		int[][] tests = {
				{-1, -1},
			};
			
			System.out.println(new LeetCode220().containsNearbyAlmostDuplicate(tests[0], 1, -1));
	}
	
	public static void LC219Test() {
		class TestCase {
			int[] nums;
			int k;
			
			public TestCase(int[] nums, int k) {
				this.nums = nums;
				this.k = k;
			}
		}
		int[] nums1 = {1, 2, 3, 1};
		int[] nums2 = {3, 3};
		int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] nums4 = {1, 2};
		
		TestCase [] cases = {
			new TestCase(null, 0),
			new TestCase(nums1, 3),
			new TestCase(nums2, 2),
			new TestCase(nums3, 15),
			new TestCase(nums4, 2),
		};
		
		for(TestCase testcase: cases) {
			System.out.println(new LeetCode219().containsNearbyDuplicate(testcase.nums, testcase.k));
		}
	}
	
	public static void LC218Test() {
		System.out.println("Don't like it, skipped!");
	}
	
	public static void LC217Test() {
		int [][] tests = {
			{},
			{1, 3, 55, -19},
			{1},
			{1, 4, -10},
			{1, 9, 8, 1},
		};
		for(int[] arr:tests) {
			System.out.println(new LeetCode217().containsDuplicate(arr));
		}
	}
	
	public static void LC216Test() {
		int[][] tests = {
				{3, 7},
				{3, 9},
				{1, 7},
				{2, 9},
				{2, 18},
		};
		for(int[] test: tests) {
			System.out.println(new LeetCode216().combinationSum3(test[0], test[1]));
		}
	}
}
