package binarytree.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class MyBST {
	private TreeNode head;
		
	public MyBST() {}
	
	public MyBST(TreeNode head) {
		this.head = head;
	}
	
	public void addNode(int value) {
		if(head != null) {
			this.addNodeTraverse(head, value);
		} else {
			this.head = new TreeNode(value);
		}
	}
	
	private TreeNode addNodeTraverse(TreeNode node, int value) {
		if(node == null) {
			node = new TreeNode(value);
		} else if(node.val > value) {
			node.left = this.addNodeTraverse(node.left, value);
		} else {
			node.right = this.addNodeTraverse(node.right, value);
		}
		
		return node;
	}
	
	public void levelPrint() {
		this.traverse(ETraverseType.LEVEL);
	}
	
	public void traverse(ETraverseType e) {
		switch(e) {
		case PRE:
			System.out.print("Pre-order:\t");
			traversePre(this.head);
			System.out.println();
			break;
		case IN:
			System.out.print("In-order:\t");
			traverseIn(this.head);
			System.out.println();
			break;
		case POST:
			System.out.print("Post-order:\t");
			traversePost(this.head);
			System.out.println();
			break;
		case LEVEL:
			System.out.print("by-Level:\t");
			levelTraverse(head);
			System.out.println();
			break;
		}
	}
	
	private void traversePre(TreeNode node) {
		if(node != null) {
			System.out.print(node.val + " ");
			traversePre(node.left);
			traversePre(node.right);
		}
	}
	
	private void traverseIn(TreeNode node) {
		if(node != null) {
			traverseIn(node.left);
			System.out.print(node.val + " ");
			traverseIn(node.right);
		}
	}
	
	private void traversePost(TreeNode node) {
		if(node != null) {
			traversePost(node.left);
			traversePost(node.right);
			System.out.print(node.val + " ");
		}
	}
	
	public void myPrintTree() {
		System.out.println("Print this Binary Search Tree Level-by-level:");
		this.levelTraverseNewLine(head);
	}
	
	public void levelTraverse(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(node != null) {
			queue.add(node);
		}
		while(!queue.isEmpty()) {
			node = queue.peek();
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
			System.out.print(queue.poll().val + " ");
		}
		System.out.println();
	}
	
	public void levelTraverseNewLine(TreeNode node) {
		Queue<TreeNode> curQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
		if(node != null) {
			curQueue.add(node);
		}
		while(!curQueue.isEmpty()) {
			node = curQueue.peek();
			if(node.left != null) {
				nextQueue.add(node.left);
			}
			if(node.right != null) {
				nextQueue.add(node.right);
			}
			System.out.print(curQueue.poll().val + " ");
			if(curQueue.isEmpty()) {
				System.out.println();
				curQueue = nextQueue;
				nextQueue = new LinkedList<TreeNode>();
			}
		}
	}

	public TreeNode getHead() {
		return head;
	}

	public void setHead(TreeNode head) {
		this.head = head;
	}
	
}
