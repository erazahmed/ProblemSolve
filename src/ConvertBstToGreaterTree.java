import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class ConvertBstToGreaterTree {

	public TreeNode convertBST(TreeNode root) {

		if (root == null) {
			return null;
		}

		int size = getSize(root);
		int[] treeArr = new int[size];
		int[] resultArr = new int[size];
		int sum = calculateSum(root, treeArr);
		Arrays.sort(treeArr);

		int prev = 0;
		for (int i = 0; i < treeArr.length; i++) {
			resultArr[i] = sum - prev;
			prev += treeArr[i];
		}

		Main.printArray(treeArr);
		Main.printArray(resultArr);

		createGreaterBst(root, resultArr, treeArr);
		return root;
	}

	private void createGreaterBst(TreeNode root, int[] resultArr, int[] treeArr) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (queue.size() > 0) {

			TreeNode node = queue.poll();
			int index = Arrays.binarySearch(treeArr, node.val);
			node.val = resultArr[index];

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}

	}

	private int getSize(TreeNode root) {
		int size = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (queue.size() > 0) {
			TreeNode node = queue.poll();
			size++;
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}

		return size;

	}

	private int calculateSum(TreeNode root, int[] treeArr) {

		int sum = 0;
		int count = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (queue.size() > 0) {

			TreeNode node = queue.poll();
			sum += node.val;
			treeArr[count] = node.val;
			count++;

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}

		}

		return sum;

	}

}
