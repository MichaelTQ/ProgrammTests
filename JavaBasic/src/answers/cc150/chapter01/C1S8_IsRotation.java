package answers.cc150.chapter01;

public class C1S8_IsRotation {

	public static void main(String[] args) {
		Tuple []testCases = {
			new Tuple( "waterbottle", "erbottlewat" ),
			new Tuple( "", "" ),
			new Tuple( "abcdd", "ddabc" ),
		};
		
		System.out.println(String.format("%-14s | %-14s | %-5s ", "String1", "String2", "Result"));
		for(Tuple t: testCases) {
			System.out.println(String.format("%-14s | %-14s | %-5s ", t.s1, t.s2, isRotation(t.s1, t.s2)));
		}
	}
	
	public static boolean isRotation(String s1, String s2) {
		StringBuffer sb1 = new StringBuffer(s1);
		sb1.append(s1);
				
		return isSubString(sb1.toString(), s2);
	} 
	
	private static boolean isSubString(String s1, String s2) {
		return s1.contains(s2);
	} 

	private static class Tuple {
		public String s1;
		public String s2;
		
		public Tuple(String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}
	}
}
