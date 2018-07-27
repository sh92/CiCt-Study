package addLists2;

public class LinkedListNode {

	int data;
	public LinkedListNode next;
	public LinkedListNode prev;

	public LinkedListNode() {

	}

	public LinkedListNode(int data) {
		super();
		this.data = data;
	}

	public LinkedListNode(int data, LinkedListNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	public LinkedListNode(int data, LinkedListNode next, Object object2) {
		this.data = data;
		this.next = next;

	}

	public void setNext(LinkedListNode more) {
		this.next = more;
	}

}
