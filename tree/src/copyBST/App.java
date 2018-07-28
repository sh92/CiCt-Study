package copyBST;

public class App {

	public static int index = 0;

	public static void copyBST(TreeNode root, int[] array) {
		if (root == null)
			return;
		copyBST(root.left, array);
		array[index] = root.data;
		index++;
		copyBST(root.right, array);
	}

	public static boolean checkBST3(TreeNode root) {
		return checkBST3(root, null, null);
	}

	private static boolean checkBST3(TreeNode n, Integer min, Integer max) {
		if (n == null)
			return true;

		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		if (!checkBST3(n.left, min, n.data) || !checkBST3(n.right, n.data, max)) {
			return false;
		}
		return true;
	}

	public static Integer last_printed = null;

	public static boolean checkBST2(TreeNode root) {
		if (root == null)
			return true;
		if (!checkBST2(root.left))
			return false;
		if (last_printed != null && root.data <= last_printed) {
			return false;
		}
		last_printed = root.data;

		if (!checkBST2(root.right))
			return false;
		return true;
	}

	public static boolean checkBST(TreeNode root) {
		index = 0;
		int[] array = new int[root.getSize()];
		copyBST(root, array);
		for (int i = 1; i < array.length; i++) {
			if (array[i] <= array[i - 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		System.out.println(checkBST(root));

		TreeNode root2 = new TreeNode(6);
		root2.right = new TreeNode(2);
		System.out.println(checkBST(root2));

		TreeNode root3 = new TreeNode(6);
		root3.left = new TreeNode(2);
		System.out.println(checkBST2(root3));

		TreeNode root4 = new TreeNode(6);
		root4.right = new TreeNode(2);
		System.out.println(checkBST2(root4));

		TreeNode root5 = new TreeNode(6);
		root5.left = new TreeNode(2);
		System.out.println(checkBST3(root5));

		TreeNode root6 = new TreeNode(6);
		root6.right = new TreeNode(2);
		System.out.println(checkBST3(root6));

	}
}
