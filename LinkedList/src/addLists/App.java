package addLists;

public class App {
	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode(3);
		l1.next = new LinkedListNode(4);
		l1.next.next = new LinkedListNode(2);

		LinkedListNode l2 = new LinkedListNode(2);
		l2.next = new LinkedListNode(6);
		l2.next.next = new LinkedListNode(3);

		LinkedListNode retNode = addLists(l1, l2, 0);
		printReverseLinkedList(retNode);
	}

	private static void printReverseLinkedList(LinkedListNode root) {
		if (root == null) {
			return;
		}
		printReverseLinkedList(root.next);
		System.out.print(root.data + " ");
	}

	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		LinkedListNode result = new LinkedListNode();

		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}

		if (l2 != null) {
			value += l2.data;
		}

		result.data = value % 10;
		carry = value / 10;
		LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
		result.setNext(more);
		return result;
	}

}
