package tests.algorithm.leetcode;

public class LeetCode083_RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode prev = head;
		ListNode node = head;
		while(node != null) {
			if(node != head) {
				if(node.val == prev.val) {
					prev.next = node.next;
				} else {
					prev = node;
				}
			}
			node = node.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		
	}
}
