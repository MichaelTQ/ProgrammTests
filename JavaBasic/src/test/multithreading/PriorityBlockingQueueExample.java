package test.multithreading;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
	public static void main(String[] args) {
		PriorityBlockingQueue<String> blockingQueue =
				new PriorityBlockingQueue<String>(10);
		Thread consumer = new Thread(new ConsumerTest1(blockingQueue));
		Thread producer = new Thread(new ProducerTest1(blockingQueue));
		
		consumer.start();
		producer.start();
	}
}

class ProducerTest1 implements Runnable {
	PriorityBlockingQueue<String> blockingQueue;
	
	public ProducerTest1(PriorityBlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}
	
	@Override
	public void run() {
		try {
			blockingQueue.put("1");
			Thread.sleep(1000);
			blockingQueue.put("2");
			Thread.sleep(1000);
			blockingQueue.put("3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ConsumerTest1 implements Runnable {
	PriorityBlockingQueue<String> blockingQueue;
	
	public ConsumerTest1(PriorityBlockingQueue<String> queue) {
		blockingQueue = queue;
	}
	
	@Override
	public void run() {
		try {
			System.out.println( blockingQueue.take() );
			System.out.println( blockingQueue.take() );
			System.out.println( blockingQueue.take() );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}