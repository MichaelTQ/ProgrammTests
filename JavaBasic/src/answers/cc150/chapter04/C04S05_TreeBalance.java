package answers.cc150.chapter04;

public class C04S05_TreeBalance {

	public static void main(String[] args) {
		Node head1 = new Node(6);
		Node node1 = new Node(10);
		head1.left = node1;
		System.out.println(isBinarySearchTree(head1));
		
		Node head2 = new Node(10);
		Node node2 = new Node(5);
		Node node3 = new Node(17);
		Node node4 = new Node(3);
		Node node5 = new Node(12);
		Node node6 = new Node(7);
		Node node7 = new Node(20);
		
		head2.left = node2;
		head2.right = node3;
		node2.left = node4;
		node2.right = node6;
		node3.left = node5;
		node3.right = node7;
		
		BinarySearchTree.display(head2);
		System.out.println(isBinarySearchTree(head2));
		
		node3.right = null;
		BinarySearchTree.display(head2);
		System.out.println(isBinarySearchTree(head2));
		
		Node node8 = new Node(9);
		node3.right = node8;
		BinarySearchTree.display(head2);
		System.out.println(isBinarySearchTree(head2));
	}

	public static boolean isBinarySearchTree(Node node) {
		if(node == null) return true;
		if(node.left != null && node.right != null) {
			if(node.left.val < node.val && node.right.val > node.val) {
				return isBinarySearchTree(node.left) && isBinarySearchTree(node.right);
			} else return false;
		} else if(node.left == null && node.right != null) {
			if(node.right.val > node.val) {
				return isBinarySearchTree(node.right);
			} else return false;
		} else if(node.right == null && node.left != null) {
			if(node.left.val < node.val) {
				return isBinarySearchTree(node.left); 
			} else return false;
		}
		return true;
	}
	
}
