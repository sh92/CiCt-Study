package sumInTree;

public class App {

	static int countPathWithSum(TreeNode root, int targetSum) {
		if (root == null)
			return 0;
		int pathsFromRoot = countPathWithSumFromNode(root, targetSum, 0);
		int pathsOnLeft = countPathWithSum(root.left, targetSum);
		int pathsOnRight = countPathWithSum(root.right, targetSum);

		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}

	private static int countPathWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
		if (node == null) {
			return 0;
		}
		currentSum += node.data;
		int totalPaths = 0;
		if (currentSum == targetSum) {
			totalPaths++;
		}

		totalPaths += countPathWithSumFromNode(node.left, targetSum, currentSum);
		totalPaths += countPathWithSumFromNode(node.right, targetSum, currentSum);

		return totalPaths;
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
