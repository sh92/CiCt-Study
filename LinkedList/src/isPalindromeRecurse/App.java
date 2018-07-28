package isPalindromeRecurse;

public class App {

	public static void main(String[] args) {

		LinkedListNode root = new LinkedListNode(1);
		root.next = new LinkedListNode(2);
		root.next.next = new LinkedListNode(3);
		root.next.next.next = new LinkedListNode(4);
		root.next.next.next.next = new LinkedListNode(3);
		root.next.next.next.next.next = new LinkedListNode(2);
		root.next.next.next.next.next.next = new LinkedListNode(1);
		boolean result = isPalindrome(root);
		System.out.println(result);
	}

	private static Result isPalindromeRecurse(LinkedListNode head, int length) {
		if (head == null || length == 0) {
			return new Result(null, true);
		} else if (length == 1) {
			return new Result(head.next, true);
		} else if (length == 2) {
			return new Result(head.next.next, head.data == head.next.data);
		}
		Result res = isPalindromeRecurse(head.next, length - 2);
		if (!res.result || res.node == null) {
			return res;
		} else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}

	static boolean isPalindrome(LinkedListNode head) {
		Result p = isPalindromeRecurse(head, listSize(head));
		return p.result;
	}

	private static int listSize(LinkedListNode head) {
		LinkedListNode temp = head;
		int cnt = 0;
		while (temp != null) {
			temp = temp.next;
			cnt += 1;
		}
		return cnt;
	}

}
