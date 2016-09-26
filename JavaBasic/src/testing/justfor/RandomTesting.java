package testing.justfor;

public class RandomTesting {
	public static void main(String[] args) {
		test(3, 5);
		test(4, 7);
		test(8, 1);
		
	}
	private static void test(int i, int j) {
		int iStart = i - i%3;
		int jStart = j - j%3;
		System.out.println(iStart);
		System.out.println(jStart);
		System.out.println("==========");
	}
}
