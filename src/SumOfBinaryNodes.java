import java.util.HashMap;
import java.util.Stack;

import tree.TreeNode;

public class SumOfBinaryNodes {

	public int sumRootToLeaf(TreeNode root) {

		int sum = 0;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		HashMap<TreeNode, String> path = new HashMap<TreeNode, String>();

		nodeStack.push(root);
		path.put(root, String.valueOf(root.val));

		while (!nodeStack.isEmpty()) {

			TreeNode node = nodeStack.pop();

			if (node.left == null && node.right == null) {

				sum += Integer.parseInt(path.get(node), 2);
			}

			if (node.left != null) {
				nodeStack.push(node.left);
				path.put(node.left, path.get(node) + node.left.val);
			}

			if (node.right != null) {
				nodeStack.push(node.right);
				path.put(node.right, path.get(node) + node.right.val);
			}

		}

		return sum;

	}

}
