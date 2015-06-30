package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode225 implements ILCSolution {
	private Queue<Integer> queue1 = new LinkedList<Integer>();
	private Queue<Integer> queue2 = new LinkedList<Integer>();
		
	public void push(int x) {
		queue1.add(x);
	}
	
	public void pop() {
		while(queue1.size() > 1) {
			queue2.add(queue1.poll());
		}
		queue1.poll();
		queue1 = queue2;
		queue2 = new LinkedList<Integer>();
	}
	
	public int top() {
		while(queue1.size() > 1) {
			queue2.add(queue1.poll());
		}
		int val = queue1.peek();
		queue2.add(val);
		queue1 = queue2;
		queue2 = new LinkedList<Integer>();
		return val;
	}
	
	public boolean empty() {
		return (queue1.isEmpty() && queue2.isEmpty());
	}

	@Override
	public void myPrint() {
		
	}

}
