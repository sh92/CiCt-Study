package commonAncestor;

public class App {

	static TreeNode commonAncestor(TreeNode p, TreeNode q) {
		int delta = depth(p) - depth(q);
		TreeNode first = delta > 0 ? q : p;
		TreeNode second = delta > 0 ? p : q;
		second = goUpBy(second, Math.abs(delta));
		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		return (first == null || second == null) ? null : first;
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(5);
		p.left = new TreeNode(4);
		p.left.parent = p;
		p.left.left = new TreeNode(9);
		p.left.left.parent = p.left;
		p.right = new TreeNode(8);
		p.right.parent = p;
		p.right.right = new TreeNode(10);
		p.right.right.parent = p.right;

		TreeNode result = commonAncestor(p.left.left, p.right.right);
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
