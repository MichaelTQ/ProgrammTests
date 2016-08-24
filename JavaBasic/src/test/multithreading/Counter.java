package test.multithreading;

public class Counter {
	private int counter;
	public synchronized void syncAdd(int val) {
		counter = counter + val;
	}
	public void add(int val) {
		counter = counter + val;
	}
	public int getCount() {
		return counter;
	}
}
