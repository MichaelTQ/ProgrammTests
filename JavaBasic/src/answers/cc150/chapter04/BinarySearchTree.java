package answers.cc150.chapter04;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	private Node head;
	
	public BinarySearchTree() {
		head = null;
	}
	
	public BinarySearchTree(int val) {
		head = new Node(val);
	}

	public void add(int val) {
		if(head == null) {
			head = new Node(val);
		} else {
			add(val, head);
		}
	}
	
	private void add(int val, Node node) {
		if(node == null) {
			return;
		} else if(node.val > val) {
			if(node.left == null) {
				node.left = new Node(val);
			} else {
				add(val, node.left);
			}
		} else if(node.val < val) {
			if(node.right == null) {
				node.right = new Node(val);
			} else {
				add(val, node.right);
			}
		}
	}
	
	public void printTree(EnumTraverseMethods method) {
		switch(method) {
		case DFS_PRE_ORDER:
			traverseDFSPre(head);
			break;
		case DFS_IN_ORDER:
			traverseDFSIn(head);
			break;
		case DFS_POST_ORDER:
			traverseDFSPost(head);
			break;
		case BFS:
			traverseBFS(head);
			break;
		case DISPLAY:
			display();
			break;
		default:
			display();
		}
		System.out.println();
	}
	
	public void display() {
		List<Node> list = new ArrayList<Node>();
		list.add(head);
		printTree(list, getHeight(head));
	}
	
	public static void display(Node node) {
		List<Node> list = new ArrayList<Node>();
		list.add(node);
		printTree(list, getHeight(node));
	}
	
	private void traverseDFSPre(Node node) {
		if(node != null) {
			System.out.print(node.val + " ");
			traverseDFSPre(node.left);
			traverseDFSPre(node.right);
		}
	}
	private void traverseDFSIn(Node node) {
		if(node != null) {
			traverseDFSIn(node.left);
			System.out.print(node.val + " ");
			traverseDFSIn(node.right);
		}
	}
	private void traverseDFSPost(Node node) {
		if(node != null) {
			traverseDFSPost(node.left);
			traverseDFSPost(node.right);
			System.out.print(node.val + " ");
		}
	}
	
	private void traverseBFS(Node node) {}
	
	public void displayTree() {
		List<Node> list = new ArrayList<Node>();
		list.add(head);
		printTree(list, getHeight(head));
	}
	
	private static int getHeight(Node head) {
		if(head == null) {
			return 0;
		} else {
			return 1 + Math.max(getHeight(head.left), getHeight(head.right));
		}
	}
	
	private static void printTree(List<Node> levelNodes, int level) {
		List<Node> nodes = new ArrayList<Node>();
		printIndentForLevel(level);
		for(Node node: levelNodes) {
			System.out.print(node == null? " ":node.val);
			printSpacingBetweenNodes(level);
			if(level > 1) {
				nodes.add(node == null? null:node.left);
				nodes.add(node == null? null:node.right	);
			}
		}
		System.out.println();
		if(level > 1) {
			printTree(nodes, level-1);
		}
	}

	private static void printIndentForLevel(int level) {
		for(int i = (int) (Math.pow(2, level - 1)); i > 0; i--) {
			System.out.print(" ");
		}
	}
	
	private static void printSpacingBetweenNodes(int level) {
		for(int i = (int)((Math.pow(2, level - 1))*2)-1; i> 0; i--) {
			System.out.print(" ");
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(5);
		bst.add(3);
		bst.add(15);
		bst.add(10);
		bst.add(17);
		
		bst.printTree(EnumTraverseMethods.DFS_PRE_ORDER);
		bst.printTree(EnumTraverseMethods.DFS_IN_ORDER);
		bst.printTree(EnumTraverseMethods.DFS_POST_ORDER);
		bst.printTree(EnumTraverseMethods.DISPLAY);
	}
}