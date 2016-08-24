package answers.cc150.chapter09;

import java.util.Arrays;
import java.util.Date;

public class C09S01_StairCase {

	public static void main(String[] args) {
		System.out.println(new Date());
		System.out.println(recursiveSteps(50));
		System.out.println(new Date());
		int[]map = new int[100000];
		Arrays.fill(map, -1); // i don't really think it's that good.
		System.out.println(dpSteps(50, map));
		System.out.println(new Date());
	}

	public static int dpSteps(int n, int[] map) {
		if(n < 0) {
			return 0;
		} else if(n==1) {
			map[1] = 1;
			return 1;
		} else if(n==2) {
			map[2] = 2;
			return 2;
		} else if(map[n] > -1) {
			return map[n];
		} else {
			map[n] = dpSteps(n-1, map) +
					dpSteps(n-2, map);
			return map[n];
		}
	}

	public static int recursiveSteps(int n) {
		if(n<0) {
			return 0;
		} else if(n==1) {
			return 1;
		} else if(n==2) {
			return 2;
		} else {
			return recursiveSteps(n - 1) + recursiveSteps(n - 2);
		}
	} 
}
