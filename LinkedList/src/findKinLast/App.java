package findKinLast;

public class App {

	public static void main(String[] args) {
		LinkedListNode root = new LinkedListNode(3);
		root.next = new LinkedListNode(4);
		root.next.next = new LinkedListNode(2);
		root.next.next.next = new LinkedListNode(3);
		root.next.next.next.next = new LinkedListNode(5);
		root.next.next.next.next.next = new LinkedListNode(6);
		root.printLinkedList();

		int k = 3;
		int n = nthToLast(root, k);
		IntWrapper intwrapper = new IntWrapper();
		// LinkedListNode temp = nthToLast2(root, k, intwrapper);
		System.out.println(nthToLast3(root, k).data);

	}

	private static LinkedListNode nthToLast3(LinkedListNode root, int k) {
		if (k <= 0)
			return null;
		LinkedListNode p1 = root;
		LinkedListNode p2 = root;
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return null;
			p2 = p2.next;
		}
		if (p2 == null)
			return null;

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	// TODO It is wrong,
	private static LinkedListNode nthToLast2(LinkedListNode root, int k, IntWrapper i) {
		if (root == null)
			return null;

		nthToLast2(root.next, k, i);
		i.value = i.value + 1;
		if (i.value == k)
			return root;
		return null;
	}

	private static int nthToLast(LinkedListNode head, int k) {
		if (head == null)
			return 0;
		int i = nthToLast(head.next, k) + 1;
		if (i == k)
			System.out.println(head.data);
		return i;
	}
}
