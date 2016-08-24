package testing.justfor;

import java.util.Arrays;
import java.util.Comparator;

public class RandomTesting3 {
	public static void main(String[] args) {
		PersonTest [] p = {
			new PersonTest("1"),
			new PersonTest("2"),
			new PersonTest("3"),
		};
		Arrays.sort(p);
		
		for(PersonTest person:p) {
			System.out.println(person);
		}
		
		Arrays.sort(p, new Comparator<PersonTest>() {
			@Override
			public int compare(PersonTest p1, PersonTest p2) {
				return 1;
			}
		});
		
		for(PersonTest person:p) {
			System.out.println(person);
		}
	}
}

class PersonTest implements Comparable<PersonTest> {
	String name;
	public PersonTest(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(PersonTest p) {
		return -1;
	}
	@Override
	public String toString() {
		return name;
	}
}