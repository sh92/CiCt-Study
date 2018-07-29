package commonAncestor4_optimized;

public class App {
	static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result r = commonAncestorHelper(root, p, q);
		if (r.isAncestor) {
			return r.node;
		}
		return null;
	}

	private static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return new Result(null, false);
		if (root == p && root == q) {
			return new Result(root, true);
		}

		Result rx = commonAncestorHelper(root.left, p, q);
		if (rx.isAncestor) {
			return rx;
		}

		Result ry = commonAncestorHelper(root.right, p, q);
		if (ry.isAncestor) {
			return ry;
		}

		if (rx.node != null && ry.node != null) {
			return new Result(root, true);
		} else if (root == p || root == q) {
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
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
