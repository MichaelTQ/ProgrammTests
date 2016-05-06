package answers.cc150.chapter04;

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
			node = new Node(val);
		} else if(node.val > val) {
			add(val, node.left);
		} else if(node.val < val) {
			add(val, node.right);
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
		default:
			betterPrint(head);
		}
		System.out.println();
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
	
	private void betterPrint(Node node) {}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(5);
		bst.add(3);
		bst.add(15);
		bst.add(10);
		bst.add(17);
		
		bst.printTree(EnumTraverseMethods.DFS_PRE_ORDER);
		bst.printTree(EnumTraverseMethods.DFS_IN_ORDER);
		bst.printTree(EnumTraverseMethods.DFS_POST_ORDER);
	}

}