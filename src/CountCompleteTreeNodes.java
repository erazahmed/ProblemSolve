import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class CountCompleteTreeNodes {

// iterative solution

//	public int countNodes(TreeNode root) {
//
//		int nodeCount = 0;
//
//		if (root == null) {
//			return 0;
//		}
//
//		Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		queue.add(root);
//		nodeCount++;
//
//		while (!queue.isEmpty()) {
//
//			TreeNode node = queue.poll();
//			
//			if (node.left != null) {
//				queue.add(node.left);
//				nodeCount++;
//			}
//
//			if (node.right != null) {
//				queue.add(node.right);
//				nodeCount++;
//			}
//		}
//
//		return nodeCount;
//
//	}

	// recursive solution

	public int countNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return 1 + countNodes(root.left) + countNodes(root.right);

	}

}
