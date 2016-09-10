package tests.algorithm.leetcode;

public class LeetCode021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        ListNode node1 = l1;
        ListNode node2 = l2;
        if(node1.val > node2.val) {
        	head = node2;
        	node2 = node2.next;
        } else {
        	head = node1;
        	node1 = node1.next;
        }
        ListNode tmpNode = head;
        while(node1 != null || node2 != null) {
        	if (node1 == null) {
        		tmpNode.next = node2;
        		break;
        	} else if (node2 == null) {
        		tmpNode.next = node1;
        		break;
        	} else if(node1.val < node2.val) {
        		tmpNode.next = node1;
        		node1 = node1.next;
        	} else {
        		tmpNode.next = node2;
        		node2 = node2.next;
        	}
        	tmpNode = tmpNode.next;
        }
        return head;
    }
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1);
    	ListNode l12 = new ListNode(2);
    	ListNode l13 = new ListNode(3);
    	l1.next = l12;
    	l12.next = l13;
    	ListNode l2 = new ListNode(5);
    	
    	ListNode head = new LeetCode021().mergeTwoLists(l1, l2);
    	while(head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	} 
    	System.out.println();
    }
}