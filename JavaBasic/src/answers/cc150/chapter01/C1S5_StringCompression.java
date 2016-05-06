package answers.cc150.chapter01;

public class C1S5_StringCompression {

	public static void main(String[] args) {
		String[] testCases = {
			"",
			"1",
			"ad",
			"aaddccdddd",
			"a",
			null,
			"abdiedaaedsedcc",
		};
		System.out.println( String.format("%-15s | %-15s", "String", "Result") );
		for(String str: testCases) {
			System.out.println(String.format("%-15s | %-15s", str, strCompression(str)));
		}
	}

	private static String strCompression(String str) {
		if(str == null || str.length() == 0) {
			return str;
		}
		StringBuffer sb = new StringBuffer();
		char cTmp = str.charAt(0);
		int counter = 0;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == cTmp) {
				counter++;
				if(counter == 1) sb.append(c);
			} else if(i == str.length()-1) {
				if(counter > 1) {
					sb.append(c).append(counter);
				} else {
					sb.append(c).append(1);
				}
			} else {
				sb.append(counter);
				cTmp = c;
				counter = 0;
			}
		}
//		return sb.toString().length() < str.length()?sb.toString():str;
		return sb.toString();
	}
}
