package test.multithreading;

public class SynchronizedTesting {

	public static void main(String[] args) {
		Counter counter = new Counter();
		CounterThread[] threads = new CounterThread[10];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new CounterThread(counter);
		}
		
		for(Thread thread: threads) {
			thread.start();
		}
	}

}
