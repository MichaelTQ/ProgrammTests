package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode224 implements ILCSolution {
	
	public int calculate(String s) {

		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> elmCount = new ArrayList<Integer>();
		List<Boolean> plusList = new ArrayList<Boolean>();
		int startInd = 0;
		boolean plus = true;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '+' || c == '-') {
				String num = s.substring(startInd, i);
				if(!"".equals(num.trim()) && num != null) {
					int val = Integer.parseInt(num.trim());
					if(elmCount.size() != 0) {
						elmCount.set(elmCount.size() - 1, elmCount.get(elmCount.size() - 1) + 1);
					}
					if(plus) {
						stack.push(val);
					} else {
						stack.push(0 - val);
					}
				}
				if(c == '+') {
					plus = true;
				} else {
					plus = false;
				}
				startInd = i + 1;
			} else if(c == '(') {
				elmCount.add(0);
				if(!plus) {
					plusList.add(plus);
					plus = !plus;
				} else {
					plusList.add(plus);
				}
				startInd = i + 1;
			} else if(c == ')') {
				String num = s.substring(startInd, i);
				if(!"".equals(num.trim()) && num != null) {
					int val = Integer.parseInt(num.trim());
					if(elmCount.size() != 0) {
						elmCount.set(elmCount.size() - 1, elmCount.get(elmCount.size() - 1) + 1);
					}
					if(plus) {
						stack.push(val);
					} else {
						stack.push(0 - val);
					}
				}
				int stackCount = elmCount.get(elmCount.size() - 1);
				elmCount.remove(elmCount.size() - 1);
				int tmpSum = 0;
				while(stackCount > 0) {
					tmpSum += stack.pop();
					stackCount--;
				}
				if(plusList.get(plusList.size() - 1)) {
					stack.push(tmpSum);
				} else {
					stack.push(0 - tmpSum);
				}
				if(!elmCount.isEmpty()) {
					elmCount.set(elmCount.size() - 1, elmCount.get(elmCount.size() - 1) + 1);
				}
				plusList.remove(plusList.size() - 1);
				startInd = i + 1;
			} else if (i == s.length() - 1) {
				if(startInd < s.length()) {
					String num = s.substring(startInd, s.length());
					if(!"".equals(num.trim()) && num != null) {
						int val = Integer.parseInt(num.trim());
						if(plus) {
							stack.push(val);
						} else {
							stack.push(0 - val);
						}
					}
				}
			} 
		}
		
		int sum = 0;
		while(!stack.empty()) {
			sum += stack.pop();
		}
		return sum;
	}
	
	public int calculateRecusive(String s) {

		List<Integer> list = new ArrayList<Integer>();
		boolean plus = true;
		int startInd = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				int pareCount = 1;
				int i0 = i + 1;
				while(pareCount != 0) {
					if(s.charAt(i0) == '(') {
						pareCount++;
					} else if(s.charAt(i0) == ')') {
						pareCount--;
					}
					i0++;
				}
				list.add( calculate( s.substring(i + 1, i0 - 1).trim() ) );
				i = i0;
				startInd = i0;
			} else if(c == '+' || c == '-') {
				String num = s.substring(startInd, i);
				if(num.trim() != "" && num != null) {
					int val = Integer.parseInt(num.trim());
					if(plus) {
						list.add(val);
					} else {
						list.add(0 - val);
					}
				}
				if(c == '+') {
					plus = true;
				} else {
					plus = false;
				}
				startInd = i + 1;
			} else if (i == s.length() - 1) {
				if(startInd < s.length()) {
					String num = s.substring(startInd, s.length());
					if(num.trim() != "" && num != null) {
						int val = Integer.parseInt(num.trim());
						list.add(val);
					}
				}
			}
		}
		
		int sum = 0;
		for(int i:list) {
			sum += i;
		}
		return sum;
	}

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}

}
