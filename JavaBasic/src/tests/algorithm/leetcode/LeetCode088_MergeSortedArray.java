package tests.algorithm.leetcode;

public class LeetCode088_MergeSortedArray {
	private void mergeHelper(int[] nums1, int i1, int m, int[] nums2, int i2, int n, int[] nums1_cp) {
		while(true) {
			if(nums1_cp[i1] <= nums2[i2]) {
				nums1[i1+i2] = nums1_cp[i1];
				if(i1 < m-1) i1++;
			} else {
				nums1[i1+i2] = nums2[i2];
				if(i2 < n-1) i2++;
			}
			if(i1 + i2 == m+n-1) return;
			System.out.println(i1 + ", " + i2 + ", " + m + ", " + n);
			TestUtils.printArr(nums1);
		}
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] nums1_copy = new int[nums1.length];
		System.arraycopy(nums1, 0, nums1_copy, 0, nums1.length);
		mergeHelper(nums1, 0, m, nums2, 0, n, nums1_copy);
	}
	public static void main(String[] args) {
		int[] nums1 = {2, 3, 9, 0, 0, 0};
		int[] nums2 = {1, 6, 10};
		
		new LeetCode088_MergeSortedArray().merge(nums1, 3, nums2, nums2.length);
		System.out.println("result:");
		TestUtils.printArr(nums1);
	}
}
