package tests.algorithm.leetcode;

public class LeetCode099_RecoverBST {
	TreeNode first;
	TreeNode second;
	TreeNode prev;
	
	public void recoverTree(TreeNode root) {
		if(root == null) return;
		inorder(root);
		if(second != null && first != null) {
			int val = second.val;
			second.val = first.val;
			first.val = val;
		}
	}
	
	private void inorder(TreeNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		
		if(prev != null) {
			if(root.val < prev.val) {
				if(first == null) {
					first = prev;
				}
				second = root;
			}
		}
		prev = root;
		
		inorder(root.right);
	}
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		@SuppressWarnings("unused")
		TreeNode(int x) {
			this.val = x;
		}
	}
}

