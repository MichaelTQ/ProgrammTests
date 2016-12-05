package tests.algorithm.leetcode;

public class LeetCode111_MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		else if(root.left == null && root.right == null) {
			return 1;
		} else if(root.left == null && root.right != null) {
			return minDepth(root.right)+1;
		} else if(root.right == null && root.left != null) {
			return minDepth(root.left)+1;
		} else {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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
