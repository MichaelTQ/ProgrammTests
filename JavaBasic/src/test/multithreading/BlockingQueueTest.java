package test.multithreading;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
		Iterator<String> iter = queue.iterator();
		
		queue.add("13");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
