package answers.cc150.chapter02;

public class C02S04 {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>().new LinkedListBuilder()
				.addVal(13)
				.addVal(43)
				.addVal(3)
				.addVal(2)
				.addVal(34)
				.buildList();
		
		MyNode<Integer> node = linkedListPartition(linkedList.getHead(), 30);
		
		while(node != null) {
			System.out.println(node.getValue());
			node = node.next;
		}
	}
	
	public static MyNode<Integer> linkedListPartition(MyNode<Integer> head, Integer mid) {
		MyNode<Integer> node1 = null;
		MyNode<Integer> head1 = null;
		MyNode<Integer> node2 = null;
		MyNode<Integer> head2 = null;
		
		MyNode<Integer> node = head;
		while(node != null) {
			Integer val = node.getValue();
			if(val.compareTo(mid) < 0) {
				if(node1 == null) {
					node1 = new MyNode<Integer>(val);
					head1 = node1;
				} else {
					node1.next = new MyNode<Integer>(val);
					node1 = node1.next;
				}
			} else {
				if(node2 == null) {
					node2 = new MyNode<Integer>(val);
					head2 = node2;
				} else {
					node2.next = new MyNode<Integer>(val);
					node2 = node2.next;
				}
			}
			node = node.next;
		}
		
		node1.next = head2;
		return head1;
	}

}
