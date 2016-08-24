package test.multithreading;

public class CounterThread2 implements Runnable {
	private Counter counter = new Counter();
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			counter.add(1);
		}
	}
}
