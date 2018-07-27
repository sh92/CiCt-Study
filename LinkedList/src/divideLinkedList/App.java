package divideLinkedList;

public class App {

	public static LinkedListNode partition2(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;
		LinkedListNode xNode = null;
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data == x) {
				xNode = node;
			} else if (node.data < x) {
				node.next = beforeStart;
				beforeStart = node;
			} else {
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		if (beforeStart == null) {
			return afterStart;
		}
		LinkedListNode head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = xNode;
		xNode.next = afterStart;
		return head;
	}

	public static LinkedListNode partition(LinkedListNode node, int x) {

		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;

		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		if (beforeStart == null)
			return afterStart;
		beforeEnd.next = afterStart;

		return beforeStart;
	}

	public static void main(String[] args) {

		LinkedListNode root = new LinkedListNode(3);
		root.next = new LinkedListNode(4);
		root.next.next = new LinkedListNode(2);
		root.next.next.next = new LinkedListNode(7);
		root.next.next.next.next = new LinkedListNode(5);
		root.next.next.next.next.next = new LinkedListNode(6);
		root.printLinkedList();

		LinkedListNode temp = root;
		int x = 4;
		// LinkedListNode node = partition(temp, x);
		LinkedListNode node = partition2(temp, x);
		System.out.println(node.data);
		node.printLinkedList();

	}
}
