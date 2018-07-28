package isPalindrome;

import java.util.Stack;

public class App {

	public static void main(String[] args) {

		LinkedListNode root = new LinkedListNode(1);
		root.next = new LinkedListNode(2);
		root.next.next = new LinkedListNode(3);
		root.next.next.next = new LinkedListNode(4);
		root.next.next.next.next = new LinkedListNode(3);
		root.next.next.next.next.next = new LinkedListNode(2);
		root.next.next.next.next.next.next = new LinkedListNode(1);
		boolean isPalindrom = isPalindrome(root);
		System.out.println(isPalindrom);
	}

	private static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;

		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

}
