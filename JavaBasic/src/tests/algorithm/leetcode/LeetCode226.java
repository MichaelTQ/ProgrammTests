package tests.algorithm.leetcode;

import binarytree.datastructure.*;
import java.util.*;

public class LeetCode226 implements ILCSolution {
	
	private TreeNode head;
	
	public LeetCode226() {}
	
	public LeetCode226(TreeNode root) {
		this.head = root;
	}
	
	public TreeNode invertTreeRecursive(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		invertTreeRecursive(root.left);
		invertTreeRecursive(root.right);
		return root;
	}

	public TreeNode invertTree(TreeNode root) {
		boolean invertFlag;
		if(root == null) {
			return root;
		} else if(root.left == null && root.right == null) {
			return root;
		}
		
		if(root.left != null) {
			if(root.left.val < root.val)
				invertFlag = true;
			else
				invertFlag = false;
		} else {
			if(root.right.val > root.val)
				invertFlag = true;
			else
				invertFlag = false;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		traversePreOrder(root, list);
		
		TreeNode newRoot = null;
		
		for(int val:list) {
			newRoot = add(newRoot, val, invertFlag);
		}
		
		return newRoot;
	}
	
	private TreeNode add(TreeNode node, int val, boolean invertFlag) {
		if(node == null) {
			node = new TreeNode(val);
			return node;
		}
		if(invertFlag) {
			if(val < node.val) {
				node.right = add(node.right, val, invertFlag);
			} else {
				node.left = add(node.left, val, invertFlag);
			}
		} else {
			if(val < node.val) {
				node.left = add(node.left, val, invertFlag);
			} else {
				node.right = add(node.right, val, invertFlag);
			}
		}
		return node;
	}
	
	private void traversePreOrder(TreeNode node, List<Integer> list) {
		if(node == null) {
			return;
		}
		list.add(node.val);
		traversePreOrder(node.left, list);
		traversePreOrder(node.right, list);
	}
	
	@Override
	public void myPrint() {
		TreeNode inverted = this.invertTree(head);
		new MyBST(inverted).myPrintTree();
	}

}
