package tests.algorithm.leetcode;

public class LeetCode025 {
	private ListNode reverseHelper(ListNode head, ListNode tail) {
		if(head == null) return head;
		if(head == tail) return head;
		if(head.next == tail) {
			ListNode tmp = tail.next;
			tail.next = head;
			head.next = tmp;
			return tail;
		}
		ListNode next = head.next;
		ListNode tmp = tail.next;
		tail.next = head;
		head.next = tmp;
		return reverseHelper(next, tail);
	}
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || head.next == null) {
    		return head;
    	}
        ListNode node = head;
        ListNode newHead = null;
        for(int i = 0; i < k-1; i++) {
        	node = node.next;
        	if(node.next == null && i == k-2) {
        		return reverseHelper(head, node);
        	} else if (node.next == null) {
        		return head;
        	}
        }
        ListNode tmpHead = node.next;
        ListNode prev = head;
        newHead = reverseHelper(head, node);
        int i = 0;
        node = tmpHead;
        while(node != null && tmpHead != null) {
        	if(node.next == null && i == k-1) {
        		ListNode tmpNode = reverseHelper(tmpHead, node);
        		prev.next = tmpNode;
        		break;
        	} else if(node.next == null) {
        		break;
        	}
        	if(i == k-1) {
        		ListNode tmpPrev = tmpHead;
        		tmpHead = reverseHelper(tmpHead, node);
        		prev.next = tmpHead;
        		prev = tmpPrev;
        		node = tmpPrev.next;
        		tmpHead = node;
        		i = 0;
        		continue;
        	}
        	i++;
        	node = node.next;
        }
        return newHead;
    }
    private static ListNode createListNode(int length, int start) {
    	if(length == 0) return null;
    	ListNode head = new ListNode(start);
    	ListNode prev = head;
    	for(int i = 1; i < length; i++) {
    		ListNode node = new ListNode(i+start);
    		prev.next = node;
    		prev = node;
    	}
    	return head;
    }
	public static void main(String[] args) {
		ListNode head = createListNode(6, 1);
//		ListNode head = createListNode(2, 1);
		TestUtils.printLinkedList(head);
		TestUtils.printLinkedList(new LeetCode025().reverseKGroup(head, 3));
//		ListNode tail = head.next.next;
//		TestUtils.printLinkedList(new LeetCode025().reverseHelper(head, tail));
	}
}
