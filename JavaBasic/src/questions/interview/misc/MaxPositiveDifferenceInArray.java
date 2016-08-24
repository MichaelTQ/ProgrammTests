package questions.interview.misc;

public class MaxPositiveDifferenceInArray {

	public static void main(String[] args) {
		int [][] intArrs = {
				{10, 3, 5, 2, 8, 7},
				{19, 1, 9, 30, 2, 6},
				{3, -1, -1, -1, -1, -1, 2, 0, 0, 0},
				{-1, 3, -5, 4, 6, -1, 2, -7, 13, -3},
				{-6,-2,-3,-4,-1,-5,-5},
		};

		for(int[] arr:intArrs) {
//			maxPositiveDifferenceInArray(arr);
			maxPositiveDifferenceInArray2(arr);
			System.out.println("==============");
		}
	}
	
	private static void maxPositiveDifferenceInArray2(int[] arr) {
		if(arr == null || arr.length <= 1) return;
		int minInd = 0;
		int maxInd = 0;
		int maxDiff = 0;
		int lastDiff = 0;
		
		for(int curInd = 0; curInd < arr.length; curInd++) {
			if(arr[curInd] - arr[minInd] > lastDiff) {
				maxInd = curInd;
				maxDiff = arr[curInd] - arr[minInd];
				lastDiff = maxDiff;
			} else if(arr[curInd] < arr[minInd]) {
				minInd = curInd;
				lastDiff = maxDiff;
			}
		}
		
		System.out.println("minInd: " + minInd);
		System.out.println("maxInd: " + maxInd);
		System.out.println("maxDiff: " + maxDiff);
	}
	
	@SuppressWarnings("unused")
	private static void maxPositiveDifferenceInArray(int[] arr) {
		if(arr == null || arr.length <= 1) return;
		int minInd = 0;
		int maxInd = 0;

		int maxDiff = 0;
		int lastDiff = 0;

		for(int curInd = 0; curInd < arr.length; curInd++) {
			int curVal = arr[curInd];
			int curDiff = curVal - arr[minInd];
			if(curDiff > lastDiff) {
				maxDiff = curDiff;
				maxInd = curInd;
				lastDiff = maxDiff;
			}
			if(arr[curInd] < arr[minInd]) {
				minInd = curInd;
			}
		}
		System.out.println("The max increment is: " + maxDiff);
		System.out.println("minimun index is: " + minInd);
		System.out.println("maximun index is: " + maxInd);
	}
}
