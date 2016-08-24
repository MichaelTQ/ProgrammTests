package test.multithreading;

public class YieldExample {
	public static void main(String[] args) {
		Thread producer = new ProducerYield();
		Thread consumer = new ConsumerYield();
		
		producer.setPriority(Thread.MIN_PRIORITY);
		consumer.setPriority(Thread.MAX_PRIORITY);
		
		producer.start();
		consumer.start();
	}

}

class ProducerYield extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Producer produces item: " + i);
			Thread.yield();
		}
	}
}
class ConsumerYield extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Consumer procudes item: " + i);
			Thread.yield();
		}
	}
}