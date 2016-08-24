package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode004 {
	public double findMedianSortedArrays(int A[], int B[]) {
		if(A == null || B == null || A.length == 0 || B.length == 0) {
			return getMedianWhenOneOfTheArraysIsEmpty(A, B);
		}
		int m = A.length;
		int n = B.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}

	public int findKth(int A[], int B[], int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
	 
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
		
//		System.out.println(String.format("aLen: %d k: %d, bLen: %d", aLen, k, bLen));
	 
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	
	public double getMedianWhenOneOfTheArraysIsEmpty(int[] arr1, int[] arr2) {
		if(arr1 == null || arr1.length == 0) {
			return getMedian(arr2);
		} else {
			return getMedian(arr1);
		}
	}
	
	public double getMedian(int[] arr) {
		if(arr.length%2 == 0) {
			return (double)(arr[arr.length/2] + arr[arr.length/2-1])/2;
		} else {
			return (double)(arr[arr.length/2]);
		}
	}
	
	public static void main(String[] args) {
		List<TestCase> caseList = new ArrayList<TestCase>();
		int[] a1 = {3, 6, 17};
		int[] a2 = {2};
		caseList.add(new TestCase(a1, a2, 4.5));
		int[] a3 = {3};
		int[] a4 = {1, 7};
		caseList.add(new TestCase(a3, a4, 3));
		int[] a5 = {1, 12, 15, 26, 38};
		int[] a6 = {2, 13, 17, 30, 45};
		caseList.add(new TestCase(a5, a6, 16));
		int[] a7 = null;
		int[] a8 = {3};
		caseList.add(new TestCase(a7, a8, 3));
		int[] a9 = {1, 2};
		int[] a10 = null;
		caseList.add(new TestCase(a9, a10, 1.5));
		int[] a11 = {1, 2, 3};
		int[] a12 = {4, 5, 6, 7};
		caseList.add(new TestCase(a11, a12, 4));
		int[] a13 = {1, 2, 3};
		int[] a14 = {4, 5, 6};
		caseList.add(new TestCase(a13, a14, 3.5));
		int[] a15 = {};
		int[] a16 = {1};
		caseList.add(new TestCase(a15, a16, 1));

		for(TestCase c: caseList) {
			LeetCode004 s = new LeetCode004();
			double actual = s.findMedianSortedArrays(c.arr1, c.arr2);
			if(c.expected != actual) {
				System.out.println("Failed!");
			} else {
				System.out.println("Passed!");
			}
			printResult(c.arr1, c.arr2, c.expected, s.findMedianSortedArrays(c.arr1, c.arr2));
		}
	}

	private static void printResult(int[] nums1, int[] nums2, double expected, double actual) {
		System.out.print("array #1: ");
		TestUtils.printArr(nums1);
		System.out.print("array #2: ");
		TestUtils.printArr(nums2);
		System.out.println("expected result: " + expected);
		System.out.println("actual result: " + actual);
		System.out.println("========================");
	}
	
	static class TestCase {
		int [] arr1;
		int [] arr2;
		double expected;
		public TestCase() {
			expected = 0;
		}
		public TestCase(int[] arr1, int[] arr2, double expected) {
			this.arr1 = arr1;
			this.arr2 = arr2;
			this.expected = expected;
		}
	}
}