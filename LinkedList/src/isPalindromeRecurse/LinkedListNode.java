package isPalindromeRecurse;

public class LinkedListNode {

	int data;
	LinkedListNode next;

	public LinkedListNode(int data) {
		super();
		this.data = data;
	}

	public LinkedListNode(int data, LinkedListNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	public void printLinkedList() {
		LinkedListNode temp = this;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
