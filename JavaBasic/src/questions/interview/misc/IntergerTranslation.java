package questions.interview.misc;

import java.util.*;

public class IntergerTranslation {

	public static void main(String[] args) {
		int []testCases = {
				1_234_567_891,
				32,
				320,
				1200,
				200000,
				};
		for(int val:testCases) {
			System.out.println(val + ": " + integerTranslation(val));
		}
	}

	private static String integerTranslation(int val) {
		StringBuffer sb = new StringBuffer();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		while(val != 0) {
			int tmp = val %10;
			queue.add(tmp);
			val = val / 10;
		}
		
		int counter = 0;
		int[][] numbers = new int[4][3];
		
		while(!queue.isEmpty()) {
			numbers[counter/3][2 - counter%3] = queue.poll();
			counter++;
		}
		
		int[] singles = numbers[0];
		int[] thousands = numbers[1];
		int[] millions = numbers[2];
		int[] billions = numbers[3];
		
		String bStr = arrayToStringTranslation(billions);
		if(bStr != null && !bStr.equals("")) {
			sb.append(bStr).
			append("Billion");
		}
		
		String mStr = arrayToStringTranslation(millions);
		if(mStr != null && !mStr.equals("")) {
			sb.append(mStr).append("Million");
		}
		

		String tStr = arrayToStringTranslation(thousands);
		if(tStr != null && !tStr.equals("")) {
			sb.append(tStr).append("Thousand");
		}
		
		sb.append( arrayToStringTranslation(singles) );
		
		return sb.toString();
	}
	
	private static String arrayToStringTranslation(int[] arr) {
		StringBuffer sb = new StringBuffer();
		HashMap<Integer, String> mapSingle = new HashMap<Integer, String>();
		mapSingle.put(0, "");
		mapSingle.put(1, "One");
		mapSingle.put(2, "Two");
		mapSingle.put(3, "Three");
		mapSingle.put(4, "Four");
		mapSingle.put(5, "Five");
		mapSingle.put(6, "Six");
		mapSingle.put(7, "Seven");
		mapSingle.put(8, "Eight");
		mapSingle.put(9, "Nine");
		
		HashMap<Integer, String> mapTens = new HashMap<Integer, String>();
		mapTens.put(0, "");
		mapTens.put(1, "");
		mapTens.put(2, "Twenty");
		mapTens.put(3, "Thirty");
		mapTens.put(4, "Forty");
		mapTens.put(5, "Fifty");
		mapTens.put(6, "Sixty");
		mapTens.put(7, "Seventy");
		mapTens.put(8, "Eighty");
		mapTens.put(9, "Ninty");
		
		HashMap<Integer, String> mapSpecial = new HashMap<Integer, String>();
		mapSpecial.put(10, "Ten");
		mapSpecial.put(11, "Eleven");
		mapSpecial.put(12, "Twelve");
		mapSpecial.put(13, "Thirteen");
		mapSpecial.put(14, "Fourteen");
		mapSpecial.put(15, "Fifteen");
		mapSpecial.put(16, "Sixteen");
		mapSpecial.put(17, "Seventeen");
		mapSpecial.put(18, "Eighteen");
		mapSpecial.put(19, "Ninteen");
		
		if(arr[0] != 0) {
			sb.append(mapSingle.get(arr[0]))
			.append("Hundred");
		}
		if(arr[0] != 0 && arr[1] != 0) {
			sb.append("And");
		}
		if(arr[1] == 1){
			int val = arr[1]*10 + arr[2];
			sb.append(mapSpecial.get(val));
			return sb.toString();
		} else {
			sb.append(mapTens.get(arr[1]));
		}
		if(arr[2] != 0) {
			sb.append(mapSingle.get(arr[2]));
		}
		
		return sb.toString();
	}

}
