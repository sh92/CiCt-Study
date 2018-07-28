package hasRoute;

import java.util.LinkedList;

public class App {
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();

		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}

		start.state = State.Visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (u != null) {
				if (u.getAdjacent() == null) {
					continue;
				}
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
			}
			u.state = State.Visited;
		}
		return false;
	}

	public static void main(String[] args) {

		Node start = new Node(-1);
		Node[] adj = new Node[4];
		adj[0] = new Node(0);
		adj[1] = new Node(1);
		adj[2] = new Node(2);
		adj[3] = new Node(3);
		start.setAdjacent(adj);

		start.adjacent[3].adjacent = new Node[2];
		start.adjacent[3].adjacent[0] = new Node(31);
		start.adjacent[3].adjacent[1] = new Node(32);

		start.adjacent[3].adjacent[1].adjacent = new Node[1];

		start.adjacent[3].adjacent[1].adjacent[0] = new Node(310);

		Node end = start.adjacent[3].adjacent[1].adjacent[0];

		Graph graph = new Graph(adj);

		System.out.println(search(graph, start.adjacent[2], end));
		System.out.println(search(graph, start.adjacent[3], end));
	}
}
