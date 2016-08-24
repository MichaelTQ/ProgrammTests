package test.multithreading;

public class CounterThread extends Thread{
	private Counter counter = new Counter();
	
	@Override
	public void run() {
		System.out.println(this.getClass() + " started!");
		counter.syncAdd(2);
		System.out.println(counter.getCount());
		
	}

	public CounterThread(Counter counter) {
		this.counter = counter;
	}
}
