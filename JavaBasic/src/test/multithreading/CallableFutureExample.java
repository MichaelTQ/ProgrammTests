package test.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {

	public static void main(String[] args) throws ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(4);
		Future<Long> result10 = es.submit(new FactorialCalculator(10));
		Future<Long> result15 = es.submit(new FactorialCalculator(15));
		Future<Long> result20 = es.submit(new FactorialCalculator(20));
		
		result20.cancel(true);
		
		long factorialof20;
		try {
			factorialof20 = result20.get();
			System.out.println("factorial of 20 is: " + factorialof20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long factorialof10;
		try {
			factorialof10 = result10.get();
			System.out.println("factorial of 10 is: " + factorialof10);
			long factorialof15 = result15.get();
			System.out.println("factorial of 15 is: " + factorialof15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		es.shutdown();
	}
}

class FactorialCalculator implements Callable<Long> {
	private int number;
	
	public FactorialCalculator(int number) {
		this.number = number;
	}
	
	@Override
	public Long call() throws Exception {
		return factorial(number);
	}
	
	private long factorial(int n) {
		long result = 1;
		while(n != 0) {
			result = n*result;
			n=n-1;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}