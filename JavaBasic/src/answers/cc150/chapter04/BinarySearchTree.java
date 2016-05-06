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
		default:
			
		}
	}
	
	private void traverseDFSPre(Node node) {
		if(node != null) {
			System.out.println(node.val);
			traverseDFSPre(node.left);
			traverseDFSPre(node.right);
		}
	}
	private void traverseDFSIn() {}
	private void traverseDFSPost() {}
	
	private void betterPrint() {}

	public static void main(String[] args) {
		
	}

}