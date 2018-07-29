package containsTree;

public class App {

	static boolean containsTree2(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;
		return subTree(t1, t2);
	}

	private static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null) {
			return false;
		} else if (r1.data == r2.data && matchTree(r1, r2)) {
			return true;
		}

		return subTree(r1.left, r2) || subTree(r1.right, r2);
	}

	private static boolean matchTree(TreeNode r1, TreeNode r2) {

		if (r1 == null && r2 == null) {
			return true;
		} else if (r1 == null || r2 == null) {
			return false;
		} else if (r1.data != r2.data) {
			return false;
		} else {
			return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
		}
	}

	static boolean containsTree(TreeNode t1, TreeNode t2) {
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();

		getOrderString(t1, string1);
		getOrderString(t2, string2);

		return string1.indexOf(string2.toString()) != -1;
	}

	private static void getOrderString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("X");
			return;
		}
		sb.append(node.data + " ");
		getOrderString(node.left, sb);
		getOrderString(node.right, sb);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;
		t2.left = new TreeNode(4);
		t1.right = new TreeNode(3);

		System.out.println(containsTree(t1, t2));
		System.out.println(containsTree2(t1, t2));

	}
}
