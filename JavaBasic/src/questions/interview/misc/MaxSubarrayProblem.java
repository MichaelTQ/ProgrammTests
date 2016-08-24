package questions.interview.misc;

public class MaxSubarrayProblem {

	public static void main(String[] args) {
		int [][] intArrs = {
				{3, -1, -1, -1, -1, -1, 2, 0, 0, 0},
				{-1, 3, -5, 4, 6, -1, 2, -7, 13, -3},
				{-6,-2,-3,-4,-1,-5,-5},
		};

		for(int[] arr:intArrs) {
			maxSubArray(arr);
			System.out.println("==============");
		}
	}

	private static void maxSubArray(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		int startInd = 0;
		int endInd = 0;
		int maxSum = Integer.MIN_VALUE;
	
		int cumuSum = 0;
		int maxStartIndUtilNow = 0;
		for(int i = 0; i < arr.length; i++) {
			int elem = arr[i];
			cumuSum += elem;
	
			if(cumuSum > maxSum) {
				endInd = i;
				startInd = maxStartIndUtilNow;
				maxSum = cumuSum;
			} else if (cumuSum < 0 ) {
				maxStartIndUtilNow = i + 1;
				cumuSum = 0;
			}
		}
		System.out.println(String.format("Max sum: %-15d", maxSum ));
		System.out.println(String.format("Max start index: %-15d", startInd));
		System.out.println(String.format("Max end index: %-15d", endInd));
	}

}
