package tests.algorithm.leetcode;

public class LeetCode110_BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        else if (root.left == null && root.right == null) {
        	return true;
        } else {
        	return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
        }
    }
	
	private int getHeight(TreeNode root) {
		if(root == null) return 0;
		else if(root.left == null && root.right == null) {
			return 1;
		} else {
			return Math.max(getHeight(root.left), getHeight(root.right))+1;
		}
	}

	public static void main(String[] args) {

	}
	
	@SuppressWarnings("unused")
	private static class TreeNode {
		public TreeNode left;
		public TreeNode right;
		public int val;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
}
