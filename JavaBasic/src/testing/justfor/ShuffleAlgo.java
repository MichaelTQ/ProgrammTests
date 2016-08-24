package testing.justfor;

import java.util.Random;

public class ShuffleAlgo {

	public static void main(String[] args) {
		int[] arrTest = {-10, 3, -3, 8, 4, -8, 30, -12, 6, 7, -2};
		for(int i = 0; i < 30; i++) {
			shuffle(arrTest);
			printList(arrTest);
		}
	}

	public static void shuffle(int[] arr) {
		Random random = new Random();
		for(int i=arr.length-1; i>0; i--) {
			int indTmp = random.nextInt(i);
			swap(arr, indTmp, i);
		}
	}
	
	private static void swap(int[] arr, int ind1, int ind2) {
		int tmp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = tmp;
	}
	
	private static void printList(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(i != arr.length - 1) System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
