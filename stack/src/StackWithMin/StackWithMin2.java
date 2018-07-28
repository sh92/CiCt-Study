package StackWithMin;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> s2;

	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}

	private int min() {
		if (this.empty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}
}
