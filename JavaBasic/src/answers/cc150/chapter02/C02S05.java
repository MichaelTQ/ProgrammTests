package answers.cc150.chapter02;

public class C02S05 {

	public static void main(String[] args) {
		int i1 = 13538;
		int i2 = 39149;
		
		LinkedList<Integer> list = addList(i1, i2);
		list.printList(3);
	}

	public static LinkedList<Integer> addList(Integer i1, Integer i2) {
		LinkedList<Integer> list1 = convertToList(i1);
		LinkedList<Integer> list2 = convertToList(i2);
		LinkedList<Integer> list = new LinkedList<Integer>();
		if( list1 == null ||
			list2 == null ||
			list1.size() != list2.size()) {
				return null;
			}
		MyNode<Integer> node1 = list1.getHead();
		MyNode<Integer> node2 = list2.getHead();
		while(node1 != null) {
			list.addVal(node1.getValue() + node2.getValue());
			node1 = node1.next;
			node2 = node2.next;
		}
		return list;
	}
	
	private static LinkedList<Integer> convertToList(Integer i) {
		if(i == null) return null;
		int tmp = i % 10;
		LinkedList<Integer> list = new LinkedList<Integer>();
		while(tmp != 0) {
			list.addVal(tmp);
			i = i/10;
			tmp = i % 10;
		}
		return list;
	}
}
