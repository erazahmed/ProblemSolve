import tree.TreeNode;

public class SortedArrayToBst {

	public TreeNode sortedArrayToBST(int[] nums) {

		int nodeLen = nums.length;
		if (nodeLen == 0) {
			return null;
		}

		int index = nodeLen / 2;
		TreeNode root = new TreeNode(nums[index]);
		int[] X = new int[index];
		int[] Y = new int[nodeLen - index - 1];
		System.arraycopy(nums, 0, X, 0, X.length);
		System.arraycopy(nums, index + 1, Y, 0, Y.length);

//		printArray(X);
//		printArray(Y);

		if (index > 0) {
			addNode(root, X);
		}
		if (nodeLen - index - 1 > 0) {
			addNode(root, Y);
		}

		printTree(root);
		return root;

	}

	private void addNode(TreeNode node, int[] nums) {

		printArray(nums);

		int nodeLen = nums.length;
		int index = nodeLen / 2;

		int[] leftArray = new int[index];
		int[] rightArray = new int[nodeLen - index - 1];

		if (index > 0) {
			System.arraycopy(nums, 0, leftArray, 0, index);
		}

		if (nodeLen - index - 1 > 0) {
			System.arraycopy(nums, index + 1, rightArray, 0, nodeLen - index - 1);
		}

		if (nums[index] < node.val) {
			TreeNode leftNode = new TreeNode(nums[index]);
			node.left = leftNode;
			if (index > 0) {
				addNode(leftNode, leftArray);
			}
			if (nodeLen - index - 1 > 0) {
				addNode(leftNode, rightArray);
			}

		} else {

			TreeNode rightNode = new TreeNode(nums[index]);
			node.right = rightNode;
			if (index > 0) {
				addNode(rightNode, leftArray);
			}
			if (nodeLen - index - 1 > 0) {
				addNode(rightNode, rightArray);
			}
		}
	}

	private void printTree(TreeNode root) {

		System.out.println(root.val);

		if (root.left != null) {
			printTree(root.left);
		} else {
			System.out.println(root.left);
		}

		if (root.right != null) {
			printTree(root.right);
		} else {
			System.out.println(root.right);
		}

	}

	public void printArray(int[] a) {
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}
}
