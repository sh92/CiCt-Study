package createLevelLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import isBalancedTree.TreeNode;

public class App {

	public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null)
			return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}

		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);

	}

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
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
