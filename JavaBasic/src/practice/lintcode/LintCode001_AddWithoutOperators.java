package practice.lintcode;

public class LintCode001_AddWithoutOperators {

	public static void main(String[] args) {
		int [][]arrTests = {
				{3, 14},
				{7, 1},
				{-4, 9},
				{10, -5},
				{4, 0},
		};
		
		for(int[] arr:arrTests) {
			System.out.println(arr[0] + " + " + arr[1] + " => " + aplusb(arr[0], arr[1]));
		}
	}

	public static int aplusb(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			return aplusb(a^b, (a&b) << 1);
		}
	}
}
