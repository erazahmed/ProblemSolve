import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import tree.TreeNode;

public class DeleteNodesAndReturnForest {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		HashMap<Integer, Parent> parentMap = new HashMap<Integer, Parent>();
		HashMap<Integer, TreeNode> selfMap = new HashMap<Integer, TreeNode>();
		HashMap<Integer, TreeNode> resultMap = new HashMap<Integer, TreeNode>();
		List<TreeNode> resultList = new ArrayList<TreeNode>();
		resultMap.put(root.val, root);

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		selfMap.put(root.val, root);
		parentMap.put(root.val, null);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			if (node.left != null) {
				queue.add(node.left);
				selfMap.put(node.left.val, node.left);
				parentMap.put(node.left.val, new Parent(node, true));
			}

			if (node.right != null) {
				queue.add(node.right);
				selfMap.put(node.right.val, node.right);
				parentMap.put(node.right.val, new Parent(node, false));

			}

		}

		System.out.println("selfMap: " + selfMap);
		System.out.println("parentMap: " + parentMap);

		for (int i = 0; i < to_delete.length; i++) {

			if (resultMap.containsKey(to_delete[i])) {
				resultMap.remove(to_delete[i]);
			}

			TreeNode node = selfMap.get(to_delete[i]);
			Parent parent = parentMap.get(to_delete[i]);

			if (node.left != null) {
				resultMap.put(node.left.val, node.left);
			}
			if (node.right != null) {
				resultMap.put(node.right.val, node.right);
			}

			if (parent != null) {

				if (parent.isLeft) {
					parent.node.left = null;
				} else {
					parent.node.right = null;
				}
			}

			System.out.println("node: " + node);
			System.out.println("parent: " + parent.node);

		}

		for (Map.Entry<Integer, TreeNode> entry : resultMap.entrySet()) {

			resultList.add(entry.getValue());

		}

		return resultList;

	}

	class Parent {
		TreeNode node;
		boolean isLeft;

		public Parent(TreeNode node, boolean isLeft) {
			this.node = node;
			this.isLeft = isLeft;
		}

	}

}
