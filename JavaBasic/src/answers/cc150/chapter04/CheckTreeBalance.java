package answers.cc150.chapter04;

public class CheckTreeBalance {

	public static void main(String[] args) {
		Node headBalance = new Node(10);
		Node node1 = new Node(5);
		Node node2 = new Node(7);
		Node node3 = new Node(13);
		Node node4 = new Node(16);
		headBalance.left = node1;
		node1.right = node2;
		headBalance.right = node3;
		node3.right = node4;
		
		System.out.println(isBST(headBalance));
		
		Node headNonBalance = new Node(10);
		Node node5 = new Node(15);
		Node node6 = new Node(17);
		headNonBalance.right = node6;
		node6.right = node5;
		System.out.println(isBST(headNonBalance));
	}

	public static boolean isBST(Node head) {
		if(head == null) {
			return true;
		} else if(head.left == null && head.right != null) {
			if(head.right.val > head.val) {
				return isBST(head.right);
			} else return false;
		} else if(head.right == null && head.left != null) {
			if(head.left.val < head.val) {
				return isBST(head.left);
			} else return false;
		} else {
			return isBST(head.left) && isBST(head.right);
		}
	}
}
