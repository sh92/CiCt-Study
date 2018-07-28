package createLevelLinkedList2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import isBalancedTree.TreeNode;

public class App {

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(8);
		root.left.right.right = new TreeNode(0);

		ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(root);
		Iterator<LinkedList<TreeNode>> list = result.iterator();
		int height = 0;
		while (list.hasNext()) {
			System.out.print("Height(" + height + "): ");
			height++;
			LinkedList<TreeNode> x = list.next();
			printLinkedList(x);
		}
	}

	private static void printLinkedList(LinkedList<TreeNode> list) {
		for (TreeNode x : list) {
			System.out.print(x.data + " ");
		}
		System.out.println();
	}
}
