import java.util.HashMap;
import java.util.Map;

import tree.TreeNode;

public class CousinsInBinaryTree {

	Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();

	public boolean isCousins(TreeNode root, int x, int y) {

		int depthX = getDepthAndParent(root, x, 0, null);
		int depthY = getDepthAndParent(root, y, 0, null);
		return map.get(x) != map.get(y) && depthX == depthY;

	}

	private int getDepthAndParent(TreeNode node, int val, int depth, TreeNode parent) {

		int level = 0;
		if (node.val == val) {
			map.put(val, parent);
			return depth;
		}

		if (node.left != null) {
			level = getDepthAndParent(node.left, val, depth + 1, node);
		}

		if (level != 0) {
			return level;
		}

		if (node.right != null) {
			level = getDepthAndParent(node.right, val, depth + 1, node);
		}

		return level;

	}

}
