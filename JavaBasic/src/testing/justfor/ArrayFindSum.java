package testing.justfor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayFindSum {

	public static void main(String[] args) {
		Integer[] arrTest = {-2, -1, 0, 3, 5, 6, 7, 9, 13, 14};
		List<Integer> list = Arrays.asList(arrTest);
		Collections.shuffle(list);
		
		for(int val: arrTest) {
			System.out.print(val + " ");
		}
		System.out.println();
		
		findSumPairs(list, 7);
	}

	private static void findSumPairs(List<Integer> list, int sum) {
		Collections.sort(list);
		int startInd = 0;
		int endInd = list.size() - 1;
		while(startInd < endInd) {
			if(list.get(startInd) + list.get(endInd) > sum) {
				endInd--;
			} else if(list.get(startInd) + list.get(endInd) < sum) {
				startInd++;
			} else {
				System.out.println("==================");
				System.out.println("Found result:");
				System.out.println("startInd: " + startInd);
				System.out.println("startValue: " + list.get(startInd));
				System.out.println("endInd: " + endInd);
				System.out.println("endValue: " + list.get(endInd));
				startInd++;
				endInd--;
			}
		}
	}
}
