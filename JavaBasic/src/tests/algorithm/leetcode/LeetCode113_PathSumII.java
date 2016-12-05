package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode113_PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<Integer> elem = new ArrayList<Integer>();
        elem.add(root.val);
        helper(root, result, sum-root.val, elem);
        return result;
    }
	
	private void helper(TreeNode root, List<List<Integer>> result, int sum, List<Integer> elem) {
	    if (sum == 0 && root.left == null && root.right == null) {
			List<Integer> newElem = new ArrayList<Integer>();
			newElem.addAll(elem);
			result.add(newElem);
		}
		if(root.left != null) {
		    elem.add(root.left.val);
			helper(root.left, result, sum-root.left.val, elem);
			elem.remove(elem.size()-1);
		}
		if(root.right != null) {
		    elem.add(root.right.val);
			helper(root.right, result, sum-root.right.val, elem);
			elem.remove(elem.size()-1);
		}
	
	// TODO: Why this is not working?!!!
	/*
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<Integer> elem = new ArrayList<Integer>();
        helper(root, result, sum, elem);
        return result;
    }
	
	private void helper(TreeNode root, List<List<Integer>> result, int sum, List<Integer> elem) {
		if (sum == root.val && root.left == null && root.right == null) {
	        elem.add(root.val);
			List<Integer> newElem = new ArrayList<Integer>();
			newElem.addAll(elem);
			result.add(newElem);
		}
		if(root.left != null) {
		    elem.add(root.val);
			helper(root.left, result, sum-root.val, elem);
			elem.remove(elem.size()-1);
		}
		if(root.right != null) {
		    elem.add(root.val);
			helper(root.right, result, sum-root.val, elem);
			elem.remove(elem.size()-1);
		}
		*/
	
//		if(sum <= 0 || root == null) {
//			elem = new ArrayList<Integer>();
//			return;
//		} else {
//			if (sum == root.val && root.left == null && root.right == null) {
//				elem.add(root.val);
//				List<Integer> newElem = new ArrayList<Integer>(elem);
//				result.add(newElem);
//				return;
//			} else if (sum > root.val){
//				if(root.left != null) {
//				    elem.add(root.val);
//					helper(root.left, result, sum-root.val, elem);
//					elem.remove(elem.size()-1);
//				}
//				if(root.right != null) {
//				    elem.add(root.val);
//					helper(root.right, result, sum-root.val, elem);
//					elem.remove(elem.size()-1);
//				}
//			} else {
//				elem = new ArrayList<Integer>();
//				return;
//			}
//		}
	}

	public static void main(String[] args) {

	}
	
	@SuppressWarnings("unused")
	private static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
}
