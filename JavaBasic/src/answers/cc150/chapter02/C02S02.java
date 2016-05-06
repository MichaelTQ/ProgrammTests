package answers.cc150.chapter02;

public class C02S02 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>().new LinkedListBuilder()
				.addVal(1)
				.addVal(2)
				.addVal(3)
				.addVal(4)
				.addVal(5)
				.addVal(6)
				.addVal(7)
				.addVal(8)
				.addVal(9)
				.addVal(10)
				.addVal(11)
				.addVal(12)
				.addVal(13)
				.addVal(14)
				.buildList();
		
		list.printList(3);
		System.out.println("======Answer 1======");
		System.out.println(kthLast(list, 0));
		System.out.println(kthLast(list, 4));
		System.out.println(kthLast(list, 9));
		System.out.println(kthLast(list, list.size()));
		System.out.println(kthLast(list, 154));
		System.out.println(kthLast(null, 100));
		System.out.println(kthLast(list, -1));
		
		System.out.println("======Answer 2======");
//		System.out.println(kthLastRecursive(list.getHead(), 0, new IntWrapper()).getValue());
		System.out.println(kthLastRecursive(list.getHead(), 4, new IntWrapper()).getValue());
		System.out.println(kthLastRecursive(list.getHead(), 9, new IntWrapper()).getValue());
		System.out.println(kthLastRecursive(list.getHead(), list.size(), new IntWrapper()).getValue());
//		System.out.println(kthLastRecursive(list.getHead(), 154, new IntWrapper()).getValue());
//		System.out.println(kthLastRecursive(null, 100, new IntWrapper()).getValue());
//		System.out.println(kthLastRecursive(list.getHead(), -1, new IntWrapper()).getValue());
	}
	
	static Integer kthLast(LinkedList<Integer> list, int k) {
		if(list == null || list.size() < k || k <= 0) {
			return null;
		}
		MyNode<Integer> node = list.getHead();
		for(int i = 0; i < list.size(); i++) {
			if(i-k >= 0) {
				node = node.next;
			}
		}
		return node.getValue();
	}
	
	static MyNode<Integer> kthLastRecursive(MyNode<Integer> node, int k, IntWrapper i) {
		if(node == null || k <= 0) {
			return null;
		}
		MyNode<Integer> node2 = kthLastRecursive(node.next, k, i);
		i.value = i.value + 1;
		if(k == i.value) {
			return node;
		} else {
			return node2;
		}
	}
	
	private static class IntWrapper {
		int value = 0;
	}
}
