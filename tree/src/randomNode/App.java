package randomNode;

public class App {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.insertInOrder(10);
		root.insertInOrder(5);
		root.insertInOrder(3);
		root.insertInOrder(7);
		root.insertInOrder(15);
		root.insertInOrder(7);
		root.insertInOrder(30);
		root.insertInOrder(35);

		System.out.println(root.getRandomNode().data());
		System.out.println(root.find(3).data());
		System.out.println(root.find(3).size());
		System.out.println(root.size());

	}
}
