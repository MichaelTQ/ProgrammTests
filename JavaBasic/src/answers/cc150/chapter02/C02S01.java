package answers.cc150.chapter02;

import java.util.*;

public class C02S01 {
	public static void main(String[] args) {
		java.util.List<Integer> list = new java.util.LinkedList<Integer>();
		list.add(123);
		list.add(141);
		list.add(169);
		list.add(93);
		list.add(123);
		list.add(93);
		list.add(141);
		list.add(141);
		list.add(141);
		list.add(169);
		
		System.out.println("Before:");
		for(int i:list) {
			System.out.print(i + " ");
		}
		System.out.println("\n============================");
		
		removeDup(list);
		System.out.println("After:");
		for(int i:list) {
			System.out.print(i + " ");
		}
		System.out.println("\n============================");
		
//		removeDupError(list);
		LinkedList<Integer> mylist = new LinkedList<Integer>().new LinkedListBuilder()
				.addVal(13)
				.addVal(41)
				.addVal(41)
				.addVal(41)
				.addVal(11)
				.addVal(13)
				.addVal(13)
				.addVal(132)
				.addVal(132)
				.addVal(132)
				.addVal(15)
				.buildList();
		System.out.println("Before:");
		mylist.printList(5);
		System.out.println("============================");
		
		removeDupNoExtra(mylist);

		System.out.println("After:");
		mylist.printList(5);
		System.out.println("============================");
	}

	static public void removeDup(List<Integer> list) {
		Set<Integer> set = new HashSet<Integer>();
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			int val = iter.next();
			if(set.contains(val)) {
				iter.remove();
			} else {
				set.add(val);
			}
		}
	}
	
	static public void removeDupError(List<Integer> list) {
		Set<Integer> set = new HashSet<Integer>();
		int i = 0;
		for(int val:list) {
			System.out.println(val);
			System.out.println(i);
			if(set.contains(val)) {
				list.remove(i);
			} else {
				set.add(val);
				i++;
			}
		}
	}
	
	static public void removeDupNoExtra(LinkedList<Integer> list) {
		if(list == null || list.size() == 0 ) return;
		MyNode<Integer> node = list.getHead();
		Integer val = node.getValue();
		while(node.next != null) {
			MyNode<Integer> node2 = node.next;
			MyNode<Integer> prevNode = node;
			while(node2.next != null) {
				if(node2.getValue().equals(val)) {
					prevNode.setNext(node2.getNextNode());
				} else {
					prevNode = prevNode.next;
				}
				node2 = node2.next;
			}
			node = node.getNextNode();
			val = node.getValue();
		}
	}
}
