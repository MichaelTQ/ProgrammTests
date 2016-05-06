package testing.justfor;

import java.util.Arrays;
import java.util.*;

@SuppressWarnings("unused")
public class JustTesting {

	public static void main(String[] args) {
		SubA1 sub1 = null;
		A a = new SubA1();
		System.out.println(a instanceof SubA1);
	}

}
class A {}

class SubA1 extends A{
	public SubA1() {}
}
class SubA2 extends A{}