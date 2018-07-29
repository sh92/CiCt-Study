package allSequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class App {
	static ArrayList<LinkedList<Integer>> allSequenece(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);

		ArrayList<LinkedList<Integer>> leftSeq = allSequenece(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequenece(node.right);

		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;

	}

	private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);

		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(25);
		root.right = new TreeNode(60);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(25);
		root.left.left.right = new TreeNode(10);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(15);

		root.right = new TreeNode(60);
		root.right.right = new TreeNode(70);

		root.right.left = new TreeNode(65);
		root.right.right = new TreeNode(80);

		ArrayList<LinkedList<Integer>> sequnces = allSequenece(root);

		Iterator iterator = sequnces.iterator();
		while (iterator.hasNext()) {
			LinkedList<Integer> list = (LinkedList<Integer>) iterator.next();
			System.out.println(list);

		}

	}
}
