package test.multithreading;

import java.util.Date;

public class JoinExample3 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new JoinRunnableTest1(), "thread_name1");
		Thread t2 = new Thread(new JoinRunnableTest1(), "thread_name2");
		Thread t3 = new Thread(new JoinRunnableTest1(), "thread_name3");
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
	}
}

class JoinRunnableTest1 implements Runnable{
	@Override
	public void run() {
		System.out.println("this thread: " + Thread.currentThread().getName());
		System.out.println(new Date() + ": started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date() + ": after sleep");
	}
}
