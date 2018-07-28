package createMinBST;

import isBalancedTree.TreeNode;

public class App {

	static TreeNode createMinimalBST(int arr[], int start, int end) {
		if (end < start)
			return null;
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		return n;
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public static boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;
		int hegihtDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(hegihtDiff) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		TreeNode n = createMinimalBST(arr, 0, arr.length - 1);
		System.out.println(isBalanced(n));

	}

}
