package test.multithreading;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class ConsumerProducerExample {
	public static void main(String[] args) {
		System.out.println("How to use wait and notify method in Java");
		System.out.println("Solving Producer Consumer Problem");
		
		Queue<Integer> buffer = new LinkedList<>();
		int maxSize = 10;
		
		Thread producer = new Producer(buffer, maxSize, "PRODUCER");
		Thread consumer = new Consumer(buffer, maxSize, "CONSUMER");
		
		producer.start();
		consumer.start();
	}
}

class Producer extends Thread {
	private Queue<Integer> queue;
	private int maxSize;
	
	public Producer(Queue<Integer> queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(queue) {
				while(queue.size() == maxSize) {
					try {
						System.out.println("Queue is full, "
								+ "Producer thread waiting for"
								+ "Consumer to take something from queue");
						queue.wait();
						Thread.sleep(10);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				int i = new Random().nextInt();
				System.out.println("Producing value: " + i);
				queue.add(i);
				queue.notifyAll();
			}
		}
	}
}

class Consumer extends Thread {
	private Queue<Integer> queue;
	@SuppressWarnings("unused")
	private int maxSize;
	
	public Consumer(Queue<Integer> queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(queue) {
				while(queue.isEmpty()) {
					System.out.println("Queue is empty, "
							+ "Consumer thread is waiting "
							+ "for Producer thread to put something in");
					try {
						queue.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				System.out.println("Consuming value: " + queue.remove());
				queue.notifyAll();
			}
		}
	}
}