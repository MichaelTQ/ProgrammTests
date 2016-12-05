package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode107_BTLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        List<Integer> elem = new ArrayList<Integer>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	TreeNode first = queue.poll();
        	elem.add(first.val);
        	if(first.left != null) {
        		next.add(first.left);
        	}
        	if(first.right != null) {
        		next.add(first.right);
        	}
        	if(queue.isEmpty()) {
        		result.add(elem);
        		elem = new ArrayList<Integer>();
        		queue = next;
        		next = new LinkedList<TreeNode>();
        	}
        }
        
        List<List<Integer>> reverse = new ArrayList<List<Integer>>();
        for(List<Integer> e: result) {
        	reverse.add(0, e);
        }
        
        return reverse;
    }

	public static void main(String[] args) {
		TreeNode head = new TreeNode(6);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(8);
		
		head.left = node1;
		head.right = node2;
		node2.left = node3;
		
		List<List<Integer>> result = new LeetCode107_BTLevelOrderTraversalII().levelOrderBottom(head);
		for(List<Integer> l: result) {
			System.out.print("[");
			for(int v: l) {
				System.out.print(v + ", ");
			}
			System.out.println("]");
		}
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
}
