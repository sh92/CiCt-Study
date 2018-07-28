package sort;

import java.util.Stack;

public class App {

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		s.push(1);
		s.push(3);
		s.push(9);
		s.push(2);
		s.push(8);
		s.push(6);
		Stack<Integer> ret = sort(s);
		printStack(ret);

	}

	private static void printStack(Stack<Integer> ret) {
		Stack<Integer> s = ret;
		while (!s.isEmpty()) {
			int tmp = s.pop();
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
}
