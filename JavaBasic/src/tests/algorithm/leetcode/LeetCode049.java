package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode049 {
	public List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}
	
	private Map<Character, Integer> stringToMap(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}
	public List<List<String>> groupAnagramsOwn(String[] strs) {
        Map<Map<Character, Integer>, List<String>> result = new HashMap<Map<Character, Integer>, List<String>>();
        for(String str: strs) {
        	Map<Character, Integer> map = this.stringToMap(str);
        	if(result.containsKey(map)) {
        		result.get(map).add(str);
        	} else {
        		List<String> list = new ArrayList<String>();
        		list.add(str);
        		result.put(map, list);
        	}
        }
        List<List<String>> newResult = new ArrayList<List<String>>();
        newResult.addAll(result.values());
        return newResult;
    }
	
	public static void main(String[] args) {
		String[] strs = {
				"pup",
				"bob",
				"bob",
				"abc",
				"cba",
				"pup",
		};
		
		List<List<String>> result = new LeetCode049().groupAnagrams(strs);
		for(List<String> list: result) {
			System.out.print("[");
			for(String str: list) {
				System.out.print(str + ", ");
			}
			System.out.println("]");
		}
	}
}
