package answers.cc150.chapter04;

public class C04S07_CommonAncestor {

	public static void main(String[] args) {
		Node head1 = new Node(10);
		Node node2 = new Node(5);
		Node node3 = new Node(17);
		Node node4 = new Node(3);
		Node node5 = new Node(12);
		Node node6 = new Node(7);
		Node node7 = new Node(20);

		head1.left = node2;
		head1.right = node3;
		node2.left = node4;
		node2.right = node6;
		node3.left = node5;
		node3.right = node7;

		BinarySearchTree.display(head1);
		System.out.println("===============");
		
		System.out.println(commonAncester(head1, node2, node6).val); //5, 7
		System.out.println(commonAncester(head1, node2, node3).val); //5, 17
		System.out.println(commonAncester(head1, node4, node6).val); //3, 7
		System.out.println(commonAncester(head1, node4, node5).val); //3, 12
	}

	private static Node commonAncester(Node head, Node node1, Node node2) {
		if(!isSubNode(head, node1) || !isSubNode(head, node2)) {
			return null;
		}
		return commonAncesterHelper(head, node1, node2);
	}
	
	private static Node commonAncesterHelper(Node head, Node node1, Node node2) {
		if(head == null) {
			return null;
		}
		if(head == node1 || head == node2) {
			return head;
		}
		boolean isNode1OnLeft = isSubNode(head.left, node1);
		boolean isNode2OnLeft = isSubNode(head.left, node2);
		if(isNode1OnLeft != isNode2OnLeft) {
			return head;
		}
		if(isNode1OnLeft) {
			return commonAncesterHelper(head.left, node1, node2);
		} else {
			return commonAncesterHelper(head.right, node1, node2);
		}
		
	}
	
	private static boolean isSubNode(Node head, Node node) {
		if(head == node) return true;
		if(head == null && node != null) return false;
		if(head.left == null) {
			return isSubNode(head.right, node);
		}
		if(head.right == null) {
			return isSubNode(head.left, node);
		}
		return isSubNode(head.left, node) || isSubNode(head.right, node);
	}
}
