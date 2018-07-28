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

	}
}
