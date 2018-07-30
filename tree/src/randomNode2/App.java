package randomNode2;

public class App {

	public static void main(String[] args) {
		Tree root = new Tree();
		root.insertInOrder(20);
		root.insertInOrder(10);
		root.insertInOrder(5);
		root.insertInOrder(3);
		root.insertInOrder(7);
		root.insertInOrder(15);
		root.insertInOrder(7);
		root.insertInOrder(30);
		root.insertInOrder(35);

		TreeNode tree = root.getRandomNode();
		System.out.println(tree.data());
		System.out.println(tree.size());
		System.out.println(root.size());

	}
}
