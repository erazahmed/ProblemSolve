import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class AvgLvlBinaryTree {

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> result = new ArrayList<Double>();

		Queue<TreeNode> oldQueue = new LinkedList<TreeNode>();

		oldQueue.add(root);

		while (oldQueue.size() > 0) {

			double total = 0;
			int count = 0;
			Queue<TreeNode> newQueue = new LinkedList<TreeNode>();

			while (oldQueue.size() > 0) {

				TreeNode node = oldQueue.poll();
				// System.out.println("node value: " + node.val);
				if (node != null) {
					count++;
					total += node.val;
					if (node.left != null) {
						newQueue.add(node.left);
					}

					if (node.right != null) {
						newQueue.add(node.right);
					}
				}
			}

			double val = (double) total / count;
			result.add(val);
			// System.out.println("total: " + total + " count: " + count + " val: " + val);
			oldQueue = newQueue;
			newQueue = null;

		}
		return result;

	}
}
