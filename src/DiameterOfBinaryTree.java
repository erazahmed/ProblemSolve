import tree.TreeNode;

public class DiameterOfBinaryTree {

	public class Diameter {
		public int diameter;
	}

	public int diameterOfBinaryTree(TreeNode root) {

		if (root == null) {
			return 0;
		}

		Diameter diameter = new Diameter();
		diameter.diameter = 0;

		depth(root, diameter);
		return diameter.diameter;

	}

	private int depth(TreeNode node, Diameter diameter) {

		if (node == null) {
			return 0;
		}

		int left = depth(node.left, diameter);
		int right = depth(node.right, diameter);

		diameter.diameter = Math.max(diameter.diameter, left + right);
		return 1 + Math.max(left, right);

	}

}
