package answers.cc150.chapter03;

import java.util.*;

public class C03S04_Hanoi {
	
	public static void main(String[] args) {
		Stack<String> stack1 = new Stack<String>();
		Stack<String> stack2 = new Stack<String>();
		Stack<String> stack3 = new Stack<String>();
		
		stack1.push("D");
		stack1.push("C");
		stack1.push("B");
		stack1.push("A");
		
		moveHanoi(stack1.size(), stack1, stack2, stack3);
	}

	public static void moveHanoi(int top, Stack<String> stack1, Stack<String> stack2, Stack<String> stack3) {
		if(top == 1) {
			stack3.push(stack1.pop());
		} else {
			moveHanoi(top-1, stack1, stack3, stack2);
			printStacks(stack1, stack2, stack3);
			stack3.push(stack1.pop());
			printStacks(stack1, stack2, stack3);
			moveHanoi(top-1, stack2, stack1, stack3);
		}
	}
	
	private static void printStacks(Stack<String> stack1, Stack<String> stack2, Stack<String> stack3) {
		int length = stack1.size() + stack2.size() + stack3.size();
		
		LinkedList<String> list1 = new LinkedList<String>(stack1);
		LinkedList<String> list2 = new LinkedList<String>(stack2);
		LinkedList<String> list3 = new LinkedList<String>(stack3);
		
		String val1 = "";
		String val2 = "";
		String val3 = "";
		for(int i = length - 1; i >= 0; i--) {
			if(list1.size() > i) val1 = list1.get(i);
			if(list2.size() > i) val2 = list2.get(i);
			if(list3.size() > i) val3 = list3.get(i);
			System.out.println(String.format("%-3s | %-3s | %-3s", val1, val2, val3));
		}
		System.out.println("=================");
	}
}
