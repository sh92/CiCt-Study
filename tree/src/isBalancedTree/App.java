package isBalancedTree;

public class App {
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

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(8);
		root.left.right.right = new TreeNode(0);

		System.out.println(isBalanced(root));
	}
}
