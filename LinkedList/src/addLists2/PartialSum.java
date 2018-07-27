package addLists2;

public class PartialSum {
	public LinkedListNode sum = null;
	public int carry = 0;

	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);

		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}

		PartialSum sum = addListsHelper(l1, l2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	private LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data, null, null);
		if (list != null) {
			list.prev = node;
			node.next = list;
		}
		return node;
	}

	private PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}

		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	private LinkedListNode padList(LinkedListNode l, int padding) {

		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			LinkedListNode n = new LinkedListNode(0, null, null);
			head.prev = n;
			n.next = head;
			head = n;
		}

		return head;
	}

	private int length(LinkedListNode l1) {
		LinkedListNode temp = l1;
		int cnt = 0;
		while (temp != null) {
			temp = temp.next;
			cnt++;
		}
		return cnt;
	}

}
