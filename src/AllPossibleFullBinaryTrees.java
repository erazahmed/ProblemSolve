import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class AllPossibleFullBinaryTrees {

	public List<TreeNode> allPossibleFBT(int N) {

		List<TreeNode> resultList = new ArrayList<TreeNode>();

		if (N == 1) {
			TreeNode node = new TreeNode(0);
			resultList.add(node);
		}

		N = N - 1;

		for (int i = 1; i < N; i += 2) {

			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(N - i);

			for (TreeNode leftNode : left) {
				for (TreeNode rightNode : right) {

					TreeNode root = new TreeNode(0);
					root.left = leftNode;
					root.right = rightNode;
					resultList.add(root);

				}
			}

		}

		return resultList;

	}

}
