package test.multithreading;

import java.util.Date;

public class JoinExample2 {

	public static void main(String[] args) {
		Thread t2 = new Thread(new Thread2());
		
		Thread1 t1 = new Thread1(t2);
		Thread t01 = new Thread(t1);
		
		t01.start();
		t2.start();
	}
}

class Thread1 implements Runnable {
	Thread t2;
	public Thread1(Thread t) {
		t2 = t;
	}
	@Override
	public void run() {
		System.out.println(new Date() + ": t1 start run()");
		try {
			System.out.println(new Date() + ": before join()!");
			t2.join();
			System.out.println(new Date() + ": after join()!");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println(new Date() + ": before t1 sleep()");
			Thread.sleep(1000);
			System.out.println(new Date() + ": after t1 sleep()");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date() + ": t1 finished run()");
	}
}

class Thread2 implements Runnable {
	@Override
	public void run() {
		System.out.println(new Date() + ": t2 start run()");
		try {
			System.out.println(new Date() + ": before t2 sleep()");
			Thread.sleep(2000);
			System.out.println(new Date() + ": after t2 sleep()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date() + ": t2 finished run()");
	}
}