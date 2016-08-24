package testing.justfor;

import java.util.*;

public class StringPermutation {

	public static void main(String[] args) {
		String [] testStrs = {
				"abc",
				"abcd",
		};
		
		for(String str: testStrs) {
			System.out.println("=============");
			List<String> list = permutation(str);
			for(String str2:list) {
				System.out.println(str2);
			}
			System.out.println("list size(how many ways):" + list.size());
		}
	}

	private static List<String> permutation(String str) {
		List<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer(str);
		permutaionHelper(list, sb, 0, str.length() - 1);
		return list;
	}
	
	private static void permutaionHelper(
			List<String> list,
			StringBuffer sb,
			int l, int r) {
		if(l == r) {
			list.add(sb.toString());
		} else {
			for(int i = l; i <= r; i++) {
				swap(sb, l, i);
				permutaionHelper(list, sb, l+1, r);
				swap(sb, l, i);
			}
		}
	}
	
	private static void swap(StringBuffer sb, int ind1, int ind2) {
		char cTmp = sb.charAt(ind1);
		sb.setCharAt(ind1, sb.charAt(ind2));
		sb.setCharAt(ind2, cTmp);
		
	}
}
