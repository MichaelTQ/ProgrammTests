package tests.algorithm.leetcode;

public class LeetCode061 {
	private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        int length = getLength(head);
        n = n % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
	
	public ListNode rotateRightMine(ListNode head, int k) {
		if(head == null || head.next == null || k == 0) return head;
		int length = 0;
		ListNode node = head;
		while(node != null) {
			node = node.next;
			length++;
		}
		
		node = head;
		k = k % length;
		if(k == 0) {
			return head;
		}
		
		ListNode prev = null;
		int count = 0;
		while(count < length-k) {
			prev = node;
			node = node.next;
			count++;
		}
		
		ListNode tail = node;
		while(tail.next != null) {
			tail = tail.next;
		}
		tail.next = head;
		prev.next = null;
		
		return node;
	}
	
	public static void main(String[] args) {
		ListNode head0 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		head0.next = node1;
		node1.next = node2;
		ListNode newHead = new LeetCode061().rotateRightMine(head0, 5);
		while(newHead != null) {
			System.out.print(newHead.val+ ", ");
			newHead = newHead.next;
		}
	}
}
