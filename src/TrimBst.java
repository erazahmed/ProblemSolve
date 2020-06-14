import tree.TreeNode;

public class TrimBst {

	public TreeNode trimBST(TreeNode root, int L, int R) {

		root = findRoot(root, L, R);

		trim(root, L, R);

		return root;
	}

	private TreeNode findRoot(TreeNode root, int L, int R) {

		if (root.val > R) {
			root = root.left;
			return findRoot(root, L, R);
		}

		if (root.val < L) {
			root = root.right;
			return findRoot(root, L, R);
		}

		return root;
	}

	private void trim(TreeNode node, int L, int R) {

		System.out.println(node.val);

		if (node.val == L) {
			node.left = null;
		}

		if (node.val == R) {
			node.right = null;
		}

		if (node.left != null) {

			if (node.left.val == L) {
				node.left.left = null;
				return;
			} else if (node.left.val < L) {
				while (node.left.val < L) {
					node.left = node.left.right;
				}

			}
			trim(node.left, L, R);

		}

		if (node.right != null) {

			if (node.right.val == R) {
				node.right.right = null;
				return;
			}
			if (node.right.val > R) {
				while (node.right.val > R) {
					node.right = node.right.left;
				}

			}
			trim(node.right, L, R);

		}
	}

}
