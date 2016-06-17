package practice.lintcode;

public class LintCode002_TrailingZeros {

	public static void main(String[] args) {
		factorialTesting();

	}
	
	private static void factorialTesting() {
		System.out.println(String.format("%-5s | %10s", "num", "result"));
		for(int i = 1; i < 31; i++) {
			System.out.println(String.format("%-5d | %40d", i, factorial( (long)i )));
		}
		
	}
	
	private static long factorial(long n) {
		long result = 1;
		for(int i = 1; i <= n; i++) {
			result = i*result;
		}
		return result;
	}

}
