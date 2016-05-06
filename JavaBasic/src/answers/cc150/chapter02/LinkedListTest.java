package answers.cc150.chapter02;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class LinkedListTest {

	@Test
	public void test() {
		LinkedList<Integer>.LinkedListBuilder builder =
				new LinkedList<Integer>().new LinkedListBuilder();
		LinkedList<Integer> list = builder
				.addVal(1)
				.addVal(45)
				.addVal(6)
				.addVal(7)
				.addVal(10)
				.addVal(-19)
				.buildList();
				
		list.printList(5);
		System.out.println("Size: " + list.size());
		
		System.out.println("===========================");
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.addVal(12);
		list2.addVal(54);
		list2.addVal(-3);
		
		list2.printList(7);
		System.out.println("Size: " + list.size());
	}

}
