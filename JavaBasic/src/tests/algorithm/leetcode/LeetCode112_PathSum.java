package tests.algorithm.leetcode;

public class LeetCode112_PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		else if(root.val == sum && root.left == null && root.right == null) return true;
		else {
			return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
		}
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
