package addLists2;

public class App {
	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode(3);
		l1.next = new LinkedListNode(4);
		l1.next.next = new LinkedListNode(2);

		LinkedListNode l2 = new LinkedListNode(2);
		l2.next = new LinkedListNode(6);
		l2.next.next = new LinkedListNode(3);

		PartialSum partialSum = new PartialSum();
		LinkedListNode retNode = partialSum.addLists(l1, l2);
		printLinkedList(retNode);

	}

	private static void printLinkedList(LinkedListNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		printLinkedList(root.next);
	}

}
