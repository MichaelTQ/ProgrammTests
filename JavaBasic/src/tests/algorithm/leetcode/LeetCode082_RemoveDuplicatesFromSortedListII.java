package tests.algorithm.leetcode;

public class LeetCode082_RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode newHead = null;
		
		return newHead;
	}
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(6);
		ListNode node70 = new ListNode(6);
		ListNode node8 = new ListNode(7);
		ListNode node9 = new ListNode(8);
		head1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node70;
		node70.next = node8;
		node7.next = node8;
		node8.next = node9;
		
		ListNode result = new LeetCode082_RemoveDuplicatesFromSortedListII().deleteDuplicates(head1);
		
		ListNode node = result;
		while(node != null) {
			if(node.next == null) {
				System.out.print(node.val);
			} else {
				System.out.print(node.val + " => ");
			}
			node = node.next;
		}
	}
}
