package test.multithreading;

public class NotifyNotifyAllTesting {
	private volatile boolean go = false;

	public static void main(String[] args) {
		final NotifyNotifyAllTesting test = new NotifyNotifyAllTesting();
		Runnable waitTask = new Runnable() {
			@Override
			public void run() {
				try {
					test.shouldGo();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable notifyTask = new Runnable() {
			@Override
			public void run() {
				test.go();
			}
		};
		
		Thread t1 = new Thread(waitTask, "WT1");
		Thread t2 = new Thread(waitTask, "WT2");
		Thread t3 = new Thread(waitTask, "WT3");
		Thread t4 = new Thread(notifyTask, "WT4");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t4.start();
	}

	private synchronized void shouldGo() throws InterruptedException {
		while(go != true) {
			System.out.println(Thread.currentThread() + " is gonna wait");
			wait(1000);
			System.out.println(Thread.currentThread() + " is woken up");
		}
		go = false;
	}
	
	private synchronized void go() {
		System.out.println(Thread.currentThread() + " is gonna notify one or all other thread(s) waiting on this.");
		go = true;
//		notify();
		notifyAll();
	}
}
