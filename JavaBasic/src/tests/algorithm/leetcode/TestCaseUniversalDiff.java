package tests.algorithm.leetcode;

public class TestCaseUniversalDiff<I, E> implements ITestCase<E> {
	I input;
	E expected;
	public TestCaseUniversalDiff(I input, E expected) {
		this.input = input;
		this.expected = expected;
	}
	@Override
	public E getExpected() {
		return expected;
	}
}
