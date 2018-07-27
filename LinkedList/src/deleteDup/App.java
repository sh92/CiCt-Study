package deleteDup;

import java.util.Hashtable;

public class App {
	public static void main(String[] args) {
		LinkedListNode root = new LinkedListNode(3);
		root.next = new LinkedListNode(4);
		root.next.next = new LinkedListNode(2);
		root.next.next.next = new LinkedListNode(3);
		root.next.next.next.next = new LinkedListNode(5);
		root.next.next.next.next.next = new LinkedListNode(6);

		printLinkedList(root);

		// deleteDups(root);
		deleteDups2(root);

		printLinkedList(root);
	}

	private static void deleteDups2(LinkedListNode head) {
		if (head == null) {
			return;
		}

		LinkedListNode current = head;
		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	private static void deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode previous = null;
		while (n != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				previous = n;
				table.put(n.data, true);
			}
			n = n.next;
		}
	}

	private static void printLinkedList(LinkedListNode root) {
		if (root == null) {
			System.out.println("There is nothing");
			return;

		}
		LinkedListNode temp = root;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();

	}
}
