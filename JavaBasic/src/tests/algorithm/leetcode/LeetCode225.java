package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode225 implements ILCSolution {
	private Queue<Integer> queue1 = new LinkedList<Integer>();
	private Queue<Integer> queue2 = new LinkedList<Integer>();
		
	public void push(int x) {
		if(!queue1.isEmpty()) {
			while(!queue1.isEmpty()) {
				queue2.add(queue1.poll());
			}
			queue2.add(x);
		} else {
			while(!queue2.isEmpty()) {
				queue1.add(queue2.poll());
			}
			queue1.add(x);
		}
	}
	
	public void pop() {
		if(!queue1.isEmpty()) {
			while(queue1.size() > 1) {
				queue2.add(queue1.poll());
			}
			queue1.poll();
		} else {
			while(queue2.size() > 1) {
				queue1.add(queue2.poll());
			}
			queue2.poll();
		}
	}
	
	public int top() {
		if(!queue1.isEmpty()) {
			while(queue1.size() > 1) {
				queue2.add(queue1.poll());
			}
			int val = queue1.peek();
			queue2.add(queue1.poll());
			return val;
		} else {
			while(queue2.size() > 1) {
				queue1.add(queue2.poll());
			}
			int val = queue2.peek();
			queue1.add(queue2.poll());
			return val;
		}
	}
	
	public boolean empty() {
		return (queue1.isEmpty() && queue2.isEmpty());
	}

	@Override
	public void myPrint() {
		
	}

}
