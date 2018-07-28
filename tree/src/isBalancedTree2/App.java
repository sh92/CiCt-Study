package isBalancedTree2;

public class App {

	public static int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}

	}

	public static boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
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
