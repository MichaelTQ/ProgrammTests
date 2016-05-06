package answers.cc150.chapter03;

import java.util.*;

public class C03S05_SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < 100; i++) {
			stack.push( new Random().nextInt(10) );
		}
		
		sortStack(stack);
		
		System.out.println(stack);
	}

	@SuppressWarnings("unused")
	private static void sortStackLazy(Stack<Integer> stack) {
		Collections.sort(stack);
	}
	
	private static void sortStack(Stack<Integer> stack) {
		if(stack == null || stack.isEmpty() || stack.size() == 1) return;
		Stack<Integer> stack2 = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int val = stack.pop();
			if(stack2.isEmpty()) {
				stack2.push(val);
			} else {
				if(val <= stack2.peek()) {
					stack2.push( val );
				} else {
					while(!stack2.isEmpty() && stack2.peek() <= val) {
						stack.push(stack2.pop());
					}
					stack2.push(val);
				}
			}
		}
		while(!stack2.isEmpty()) {
			stack.push(stack2.pop());
		}
	}
}
