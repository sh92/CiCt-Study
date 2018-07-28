package inorderSucc;

public class App {
	public static TreeNode inorderSucc(TreeNode n) {
		if (n == null)
			return null;
		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = q.parent;
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}

	private static TreeNode leftMostChild(TreeNode n) {
		if (n == null)
			return null;
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(4);
		root.left.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(6);

		root.right = new TreeNode(9);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(11);
		root.right.right.left = new TreeNode(10);

		TreeNode next = inorderSucc(root);
		System.out.println(next.data == 8);

		TreeNode next2 = inorderSucc(root.left.left);
		System.out.println(next2.data == 2);

	}
}
