package sumInTree2;

import java.util.HashMap;

public class App {

	static int countPathWithSum(TreeNode root, int targetSum) {
		return countPathWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}

	private static int countPathWithSum(TreeNode node, int targetSum, int runningSum,
			HashMap<Integer, Integer> pathCount) {
		if (node == null)
			return 0;
		runningSum += node.data;
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);

		if (runningSum == targetSum) {
			totalPaths++;
		}

		incrementHashTable(pathCount, runningSum, 1);
		totalPaths += countPathWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathWithSum(node.right, targetSum, runningSum, pathCount);
		incrementHashTable(pathCount, runningSum, -1);
		return totalPaths;
	}

	private static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		if (newCount == 0) {
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-1);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.right = new TreeNode(-3);
		root.right.right = new TreeNode(11);

		int cnt = countPathWithSum(root, 8);
		System.out.println(cnt);

	}
}
