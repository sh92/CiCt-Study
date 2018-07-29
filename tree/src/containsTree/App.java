package containsTree;

public class App {
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

	}
}
