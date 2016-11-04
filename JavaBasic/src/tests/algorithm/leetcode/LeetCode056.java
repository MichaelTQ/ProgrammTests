package tests.algorithm.leetcode;

import java.util.*;

public class LeetCode056 {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0) {
			return result;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start > o2.start) {
					return 1;
				} else if (o1.start == o2.start) {
					return o1.end - o2.end;
				} else {
					return -1;
				}
			}
		});
		Interval prev = intervals.get(0);
		int i = 0;
		boolean addLast = true;
		for(; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if(prev.start != interval.start || prev.end != interval.end) {
				while(interval.start <= prev.end && i < intervals.size()) {
					i++;
//					prev.start = prev.start<interval.start?prev.start:interval.start;
					prev.end = interval.end>prev.end?interval.end:prev.end;
					if(i < intervals.size()) {
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

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
//		intervals.add(new Interval(1, 3));
//		intervals.add(new Interval(2, 6));
//		intervals.add(new Interval(8, 10));
//		intervals.add(new Interval(15, 18));
		
//		intervals.add(new Interval(1, 3));
//		intervals.add(new Interval(1, 3));
//		intervals.add(new Interval(1, 3));
//		intervals.add(new Interval(1, 4));
		
//		intervals.add(new Interval(1, 4));
//		intervals.add(new Interval(2, 5));
		
//		intervals.add(new Interval(1, 2));
//		intervals.add(new Interval(0, 2));
		List<Interval> result = new LeetCode056().merge(intervals);
		for(Interval interval: result) {
			System.out.print(interval + ", ");
		}
	}
}

class Interval {
	int start;
	int end;
	Interval() {
		this.start = 0;
		this.end = 0;
	}
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return "[" + this.start + ", " + this.end + "]";
	}
}