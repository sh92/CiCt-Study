package commonAncestor2;

public class App {

	static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}
		TreeNode sibling = getSibling(p);
		TreeNode parent = p.parent;
		while (!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}

	private static TreeNode getSibling(TreeNode node) {
		if (node == null || node.parent == null) {
			return null;
		}
		TreeNode parent = node.parent;
		return parent.left == node ? parent.right : parent.left;

	}

	private static boolean covers(TreeNode root, TreeNode p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(20);
		p.left = new TreeNode(10);
		p.left.parent = p;
		p.left.left = new TreeNode(5);
		p.left.left.parent = p.left;

		p.left.left.left = new TreeNode(3);
		p.left.left.left.parent = p.left.left;

		p.left.left.right = new TreeNode(7);
		p.left.left.right.parent = p.left.left;

		p.left.right = new TreeNode(15);
		p.left.right.parent = p.left;

		p.left.right.right = new TreeNode(17);
		p.left.right.right.parent = p.left.right;

		p.right = new TreeNode(30);
		p.right.parent = p;

		TreeNode result = commonAncestor(p, p.left.left.right, p.left.right);
		System.out.println(result.data);

	}

	static TreeNode goUpBy(TreeNode node, int delta) {
		while (delta > 0 && node != null) {
			node = node.parent;
			delta--;
		}
		return node;
	}

	private static int depth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}
}
