package dfsbuildPath;

import java.util.ArrayList;
import java.util.Stack;

public class App {

	static Stack<Project> findBuilderOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderPorjects(graph.getNodes());
	}

	private static Stack<Project> orderPorjects(ArrayList<Project> projects) {
		Stack<Project> stack = new Stack<Project>();
		for (Project project : projects) {
			if (project.getState() == State.BLANK) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

	private static Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			System.out.println(first + " " + second);
			graph.addEdge(first, second);
		}
		return graph;
	}

	private static boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == State.PARTIAL) {
			return false;
		}
		if (project.getState() == State.BLANK) {
			project.setState(State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			project.setState(State.Complete);
			stack.push(project);
		}
		return true;
	}

	public static void main(String[] args) {
		String[] projects = { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = new String[5][2];
		dependencies[0][0] = "a";
		dependencies[0][1] = "d";

		dependencies[1][0] = "f";
		dependencies[1][1] = "b";

		dependencies[2][0] = "b";
		dependencies[2][1] = "d";

		dependencies[3][0] = "f";
		dependencies[3][1] = "a";

		dependencies[4][0] = "d";
		dependencies[4][1] = "c";

		Stack<Project> results = findBuilderOrder(projects, dependencies);
		while (!results.isEmpty()) {
			Project ret = results.pop();
			System.out.print(ret.getName() + " ");
		}
	}

}
