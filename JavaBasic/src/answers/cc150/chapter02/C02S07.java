package answers.cc150.chapter02;

import java.util.*;

public class C02S07 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>().new LinkedListBuilder()
				.addVal(12)
				.addVal(3)
				.addVal(-1)
				.addVal(-1)
				.addVal(3)
				.addVal(12)
				.buildList();
		
		list.printList(2);
		System.out.println(checkPalindromeList(list));
		
		System.out.println("=================================================");
		LinkedList<Integer> list2 = new LinkedList<Integer>().new LinkedListBuilder()
				.addVal(12)
				.addVal(3)
				.addVal(-1)
				.addVal(3)
				.addVal(12)
				.buildList();
		list2.printList(2);
		System.out.println(checkPalindromeList(list2));
		
		System.out.println("=================================================");
		LinkedList<Integer> list3 = new LinkedList<Integer>().new LinkedListBuilder()
				.addVal(12)
				.addVal(3)
				.addVal(-1)
				.addVal(5)
				.addVal(12)
				.buildList();
		list3.printList(2);
		System.out.println(checkPalindromeList(list3));
		
	}
	
	private static boolean checkPalindromeList(LinkedList<Integer> list) {
		if(list == null || list.size() == 0 || list.size() == 1) return true;
		Stack<Integer> stack = new Stack<Integer>();
		MyNode<Integer> node = list.getHead();
		while(node != null) {
			stack.push(node.getValue());
			node = node.next;
		}
		
		node = list.getHead();
		while(node != null) {
			if(!node.getValue().equals(stack.pop())) return false;
			node = node.next;
		}
		return true;
	}
}
