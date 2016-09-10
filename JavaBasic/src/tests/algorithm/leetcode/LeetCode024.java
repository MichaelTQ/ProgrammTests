package tests.algorithm.leetcode;

public class LeetCode024 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
        	return head;
        }
        ListNode node = head;
        ListNode prev = null;
        ListNode newHead = null;
        if(head.next != null) {
        	prev = head;
        	node = head.next.next;
        	newHead = head.next;
        	ListNode tmp = newHead.next;
        	newHead.next = head;
        	head.next = tmp;
        } else {
        	return head;
        }
        while(node != null) {
        	ListNode nodeNext = node.next;
        	if(nodeNext == null) {
        		break;
        	}
        	prev.next = nodeNext;
        	ListNode tmp = nodeNext.next;
        	nodeNext.next = node;
        	node.next = tmp;
        	prev = node;
        	node = node.next;
        }
        return newHead;
    }

    private static void printLinkedList(ListNode node) {
    	System.out.print("[");
    	while(node != null) {
    		if(node.next != null) {
    			System.out.print(node.val + ", ");
    		} else {
    			System.out.print(node.val);
    		}
    		node = node.next;
    	}
    	System.out.println("]");
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		ListNode node3 = new ListNode(4);
		node2.next = node3;
		ListNode node4 = new ListNode(5);
		node3.next = node4;
		ListNode node5 = new ListNode(6);
		node4.next = node5;
		printLinkedList(head);
		printLinkedList(new LeetCode024().swapPairs(head));
	}

}
