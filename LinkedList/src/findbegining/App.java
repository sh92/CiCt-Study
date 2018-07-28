package findbegining;

public class App {

	public static void main(String[] args) {

		LinkedListNode root = new LinkedListNode(1);
		root.next = new LinkedListNode(2);
		root.next.next = new LinkedListNode(3);
		root.next.next.next = new LinkedListNode(4);
		root.next.next.next.next = new LinkedListNode(5);
		root.next.next.next.next.next = new LinkedListNode(6);
		root.next.next.next.next.next.next = root.next.next;
		LinkedListNode listnode = FindBegining(root);
		System.out.println(listnode.data);
	}

	private static LinkedListNode FindBegining(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
}
