package findCommonParent;

import java.util.ArrayList;

public class App {
	public static Project[] findBuilderOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}

	private static Project[] orderProjects(ArrayList<Project> prjoects) {

		Project[] order = new Project[prjoects.size()];
		int endOfList = addNonDependent(order, prjoects, 0);
		int toBeProcessed = 0;

		while (toBeProcessed < order.length) {
			Project current = order[toBeProcessed];
			if (current == null)
				return null;
			ArrayList<Project> children = current.getChildren();
			for (Project child : children) {
				child.decrementDendencies();
			}
			endOfList = addNonDependent(order, children, endOfList);
			toBeProcessed++;
		}
		return order;
	}

	private static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getNumberDependencies() == 0) {
				order[offset] = project;
				offset++;
			}
		}
		return offset;
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

		Project[] results = findBuilderOrder(projects, dependencies);

		for (Project result : results) {
			System.out.println(result.getName());
		}

	}
}
