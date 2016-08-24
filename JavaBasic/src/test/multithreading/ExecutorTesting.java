package test.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTesting {
	public static void main(String[] args) {
//		Executor executor = Executors.newFixedThreadPool(10);
//		executor.execute(new Task(10));
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 10; i++) {
			service.submit(new Task(i));
		}
		service.shutdown();
//		service.execute(new Task(11));
	}
}

final class Task implements Runnable {
	private int taskId;

	public Task(int id) {
		this.taskId = id;
	}
	
	@Override
	public void run() {
		System.out.println("Task ID: " + this.taskId + " performed by "
				+ Thread.currentThread().getName());
	}
}