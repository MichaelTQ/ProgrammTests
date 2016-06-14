/**
 * Definition for singly-linked list.
 * public class ListNode {
 *	 int val;
 *	 ListNode next;
 *	 ListNode(int x) { val = x; }
 * }
 */
package tests.algorithm.leetcode;

public class LeetCode002 {
	public static void main(String[] args) {
		ListNode head1 = new ListNode(2);
		ListNode node11 = new ListNode(4);
		ListNode node12 = new ListNode(3);
		head1.next = node11;
		node11.next = node12;
		
		ListNode head2 = new ListNode(5);
		ListNode node21 = new ListNode(6);
		ListNode node22 = new ListNode(9);
		ListNode node23 = new ListNode(9);
		head2.next = node21;
		node21.next = node22;
		node22.next = node23;
		
		ListNode result1 = addTwoNumbers(head1, head2);
		
		ListNode head3 = new ListNode(9);
		ListNode node31 = new ListNode(8);
		head3.next = node31;
		
		ListNode head4 = new ListNode(1);
		
		ListNode result2 = addTwoNumbers(head3, head4);
		
		printLinkedList(result1);
		System.out.println("=================");
		System.out.println("input lists:");
		printLinkedList(head3);
		printLinkedList(head4);
		System.out.println("result list:");
		printLinkedList(result2);
		
	}
	
	private static void printLinkedList(ListNode head) {
		ListNode node = head;
		while(node != null) {
			if(node.next != null) {
				System.out.print(node.val + " -> ");
			} else {
				System.out.println(node.val);
			}
			node = node.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		boolean carry = false;
		ListNode current = null;
		ListNode newHead = current;
		while(l1 != null || l2 != null) {
			int val = 0;
			if(l1 == null && l2 != null) {
				val = l2.val;
			} else if (l1 != null && l2 == null) {
				val = l1.val;
			} else {
				val = l1.val + l2.val;
			}
			val = carry==true ? val+1 : val;
			if(val >= 10) {
				carry = true;
				val = val - 10;
			} else {
				carry = false;
			}
			if(current == null) {
				current = new ListNode(val);
				newHead = current;
			} else {
				current.next = new ListNode(val);
				current = current.next;
			}
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		if(carry == true) {
			current.next = new ListNode(1);
		}
		return newHead;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}