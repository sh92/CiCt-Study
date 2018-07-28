package hasRoute;

public class Node {
	int data;

	public State state;
	Node[] adjacent;

	public Node[] getAdjacent() {
		return adjacent;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setAdjacent(Node[] adjacent) {
		this.adjacent = adjacent;
	}

	public Node(int data) {
		super();
		this.data = data;
		this.state = State.Unvisited;
		this.adjacent = null;
	}

	public Node(int data, Node[] adjacent) {
		super();
		this.state = State.Unvisited;
		this.adjacent = adjacent;
	}

	public Node(int data, State state, Node[] adjacent) {
		super();
		this.state = state;
		this.adjacent = adjacent;
	}

}
