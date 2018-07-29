package containsTree;

public class TreeNode {

	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int data;

	public TreeNode(int data) {
		super();
		this.data = data;
	}

	public int getSize() {
		if (this.left == null && this.right == null) {
			return 1;
		}
		int l = 0, r = 0;
		if (this.left != null) {
			l = this.left.getSize();
		}

		if (this.right != null) {
			r = this.right.getSize();
		}
		return l + r + 1;
	}
}
