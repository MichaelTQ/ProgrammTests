package tests.algorithm.leetcode;

public class TestCaseUniversal<T> implements ITestCase<T> {
	T input;
	T expected;
	public TestCaseUniversal(T input, T expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Override
	public T getExpected() {
		return expected;
	}
}
