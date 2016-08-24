package answers.cc150.chapter04;

import java.util.*;

public class C04S06_InOrderNote {

	public static void main(String[] args) {
		NodeWithParent head1 = new NodeWithParent(10);
		NodeWithParent node2 = new NodeWithParent(5);
		NodeWithParent node3 = new NodeWithParent(17);
		NodeWithParent node4 = new NodeWithParent(3);
		NodeWithParent node5 = new NodeWithParent(12);
		NodeWithParent node6 = new NodeWithParent(7);
		NodeWithParent node7 = new NodeWithParent(20);

		head1.left = node2;
		head1.right = node3;
		node2.parent = head1;
		node3.parent = head1;
		node2.left = node4;
		node4.parent = node2;
		node2.right = node6;
		node6.parent = node2;
		node3.left = node5;
		node5.parent = node3;
		node3.right = node7;
		node7.parent = node3;

		printTree(head1);
		
		System.out.println("========================");
		NodeWithParent []testNodes = {head1, node2, node3, node4, node5};
		for(NodeWithParent node:testNodes) {
			NodeWithParent next = nextNode(node);
			int result = 0;
			if(next != null) {
				result = next.val;
			}
			System.out.println(node.val + " -- next -- " + result);
		}
	}
	
	private static NodeWithParent nextNode(NodeWithParent node) {
		if(node.right != null) {
			return mostLeftNode(node.right);
		} else {
			NodeWithParent parent = node.parent;
			if (parent==null) {
				return null;
			} else if(parent.val > node.val) {
				return parent;
			} else {
				while(parent != null && parent.val < node.val) {
					parent = parent.parent;
				}
				return parent;
			}
		}
	}
	
	private static NodeWithParent mostLeftNode(NodeWithParent node) {
		if(node.left != null) {
			return mostLeftNode(node.left);
		} else {
			return node;
		}
	}

	private static void printTree(NodeWithParent node) {
		if(node == null) return;
		Queue<NodeWithParent> list1 = new LinkedList<NodeWithParent>();
		Queue<NodeWithParent> list2 = new LinkedList<NodeWithParent>();
		list1.add(node);
		boolean isFirstList = true;
		while(!list1.isEmpty() || !list2.isEmpty() ) {
			if(isFirstList) {
				NodeWithParent tmpNode = list1.poll();
				System.out.print(tmpNode.val + " ");
				if(tmpNode.left != null) {
					list2.add(tmpNode.left);
				}
				if(tmpNode.right != null) {
					list2.add(tmpNode.right);
				}
				if(list1.isEmpty()) {
					isFirstList = false;
					System.out.println();
				}
			} else {
				NodeWithParent tmpNode = list2.poll();
				System.out.print(tmpNode.val + " ");
				if(tmpNode.left != null) {
					list1.add(tmpNode.left);
				}
				if(tmpNode.right != null) {
					list1.add(tmpNode.right);
				}
				if(list2.isEmpty()) {
					isFirstList = true;
					System.out.println();
				}
			}
		}
	}
}
