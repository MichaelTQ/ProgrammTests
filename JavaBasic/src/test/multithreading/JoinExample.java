package test.multithreading;

import java.util.Date;

public class JoinExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(new Date() + " " + Thread.currentThread().getName() + " started...");
				try {
					System.out.println(new Date() + " starting sleep() in t1.run()");
					Thread.sleep(1000);
					System.out.println(new Date() + " stopped sleep() in t1.run()");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(new Date() + " " + Thread.currentThread().getName() + " completed...");
			}
		}, "Thread#1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(new Date() + " " + Thread.currentThread().getName() + " started...");
				try {
					System.out.println(new Date() + " starting sleep() in t2.run()");
					Thread.sleep(2000);
					System.out.println(new Date() + " stopped sleep() in t2.run()");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(new Date() + " " + Thread.currentThread().getName() + " completed...");
			}
		}, "Thread#2");
		t2.start();
		t1.start();
		try {
			System.out.println("before t1.join();");
			t2.join();
			System.out.println("after t1.join();");

//			System.out.println(new Date() + " starting sleep() in main()");
//			Thread.sleep(1000);
//			System.out.println(new Date() + " stopped sleep() in main()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}
}
