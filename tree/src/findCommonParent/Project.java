package findCommonParent;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;
	private int dependencies = 0;

	public Project(String name) {
		this.name = name;
	}

	public void addNeighbor(Project node) {
		if (!map.containsKey(node.getName())) {
			children.add(node);
			map.put(node.getName(), node);
			node.incrementDependencies();
		}
	}

	private void incrementDependencies() {
		dependencies++;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Project> getChildren() {
		return children;
	}

	public int getNumberDependencies() {
		return dependencies;
	}

	public void decrementDendencies() {
		dependencies--;
	}

}
