package testing.justfor;

import java.util.Arrays;
import java.util.*;

@SuppressWarnings("unused")
public class JustTesting {

	public static void main(String[] args) {
		SubA1 a = new SubA1();
	}
}
class A {
	static {
		System.out.println("parent static method");
	}
	public A() {
		System.out.println("parent contructor");
	}
	{
		System.out.println("parent instance block");
	}
}

class SubA1 extends A{
	static {
		System.out.println("child static method");
	}
	public SubA1() {
		System.out.println("child constructor");
	}
	{
		System.out.println("child instance block");
	}
}
class SubA2 extends A{
	
}