package testing.justfor;

public class RandomTesting {

	public static void main(String[] args) {
		try {
			new Thread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.yield();
		
		Object object = new Object();
		synchronized(object) {
			object.notify();
			object.notifyAll();
			try {
				object.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
