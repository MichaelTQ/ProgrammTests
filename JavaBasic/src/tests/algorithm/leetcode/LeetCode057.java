package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode057 {
	private List<Interval> insertOnly(List<Interval> intervals, Interval newInterval) {
		for(int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if(interval.start > newInterval.start ||
				(interval.start == newInterval.start && interval.end > newInterval.end)) {
				intervals.add(i, newInterval);
				break;
			}
		}
		Interval interval = intervals.get(intervals.size()-1);
		if(interval.start < newInterval.start ||
				(interval.start == newInterval.start && interval.end <= newInterval.end)) {
			intervals.add(intervals.size(), newInterval);
		}
		return intervals;
	}
	private List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		boolean addLast = true;
		int i = 0;
		for(; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if(prev.start != interval.start || prev.end != interval.end) {
				while(interval.start <= prev.end && i < intervals.size()) {
					prev.end = interval.end>prev.end?interval.end:prev.end;
					i++;
					if(i<intervals.size()) {
						interval = intervals.get(i);
					} else {
						addLast = false;
					}
				}
				result.add(prev);
				prev = new Interval(interval.start, interval.end);
			}
		}
		if(i >= intervals.size() && addLast) {
			result.add(intervals.get(intervals.size()-1));
		}
		return result;
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null || intervals.isEmpty()) {
			List<Interval> result = new ArrayList<Interval>();
			result.add(newInterval);
			return result;
		}
        intervals = this.insertOnly(intervals, newInterval);
        System.out.println("After merge:");
        LeetCode057.printIntervals(intervals);
        return this.merge(intervals);
    }
	
	public static void main(String[] args) {
		List<Interval> intervals0 = new ArrayList<Interval>();
		intervals0.add(new Interval(1, 3));
		intervals0.add(new Interval(6, 9));
		
		List<Interval> intervals1 = new ArrayList<Interval>();
		intervals1.add(new Interval(1, 2));
		intervals1.add(new Interval(3, 5));
		intervals1.add(new Interval(6, 7));
		intervals1.add(new Interval(8, 10));
		intervals1.add(new Interval(12, 16));
		
		List<Interval> intervals2 = new ArrayList<Interval>();
		intervals2.add(new Interval(1, 2));
		intervals2.add(new Interval(1, 4));
		
		List<TestCase> testCases = new ArrayList<TestCase>();
		testCases.add(new TestCase(intervals0, new Interval(2, 5)));
		testCases.add(new TestCase(intervals1, new Interval(4, 9)));
		testCases.add(new TestCase(intervals2, new Interval(1, 6)));
		
		for(TestCase testCase: testCases) {
			System.out.println("Intput:");
			printIntervals(testCase.intervals);
			System.out.println("adding Item: " + testCase.newInterval);
			System.out.println("Result:");
			List<Interval> result = new LeetCode057().insert(testCase.intervals, testCase.newInterval);
			printIntervals(result);
			System.out.println("====================");
		}
	}
	
	private static void printIntervals(List<Interval> intervals) {
		System.out.print("[");
		for(Interval interval: intervals) {
			System.out.print(interval);
		}
		System.out.println("]");
	}
	
	private static class TestCase {
		List<Interval> intervals;
		Interval newInterval;
		public TestCase(List<Interval> intervals, Interval newInterval) {
			this.intervals = intervals;
			this.newInterval = newInterval;
		}
	}
}