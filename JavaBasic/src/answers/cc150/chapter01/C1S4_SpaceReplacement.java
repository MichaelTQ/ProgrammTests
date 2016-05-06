package answers.cc150.chapter01;

public class C1S4_SpaceReplacement {

	public static void main(String[] args) {
		String testCase = new String("ad dig  ia i   i");
		char arr[] = new char[1000];
		for(int i = 0; i < testCase.length(); i++) {
			arr[i] = testCase.charAt(i);
		}
		arr = spaceReplacement(arr, testCase.length());
		System.out.println(String.valueOf(arr));
		
		spaceReplacement2(arr, testCase.length());
		System.out.println(String.valueOf(arr));
	}

	private static char[] spaceReplacement(char[] arr, int length) {
		int spaceCount = 0;
		for(char c: arr) {
			if(c == ' ') spaceCount++;
		}
		
		int end = spaceCount * 2 + length;
		arr[end] = '\0';
		char[] arr2 = new char[1000];
		int j = 0;
		for(int i = 0; i < length; i++) {
			char c = arr[i];
			if(c == ' ') {
				arr2[j++] = '%';
				arr2[j++] = '2';
				arr2[j++] = '0';
			} else {
				arr2[j++] = arr[i];
			}
		}
		return arr2;
	}
	
	private static void spaceReplacement2(char[] arr, int length) {
		int spaceCount = 0;
		for(char c: arr) {
			if(c == ' ') spaceCount++;
		}
		
		int end = spaceCount * 2 + length;
		arr[end] = '\0';
		for(int i = length - 1; i>=0; i--) {
			char c = arr[end];
			if(c == ' ') {
				arr[end--] = '0';
				arr[end--] = '2';
				arr[end--] = '%';
			} else {
				arr[end--] = c;
			}
		}
	}
}
