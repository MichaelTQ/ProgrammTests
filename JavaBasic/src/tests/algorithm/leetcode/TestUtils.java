package tests.algorithm.leetcode;

public class TestUtils {
	public static <T> void printArr(T[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(i != arr.length - 1) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
	
	public static <T> void printArr(int [] arr) {
		if(arr == null) {
			System.out.println("[]");
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			if(i != arr.length - 1) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
	
	public static void printTestHeader() {
		System.out.println(String.format("%-10s | %-10s | %-10s | %-10s",
				"Input", "Expected", "Actual", "Result"));
	}
	
	public static void printTestRow(String str) {
		System.out.println(str);
	}
	
	public static void printLinkedList(ListNode node) {
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
}
