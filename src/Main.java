
import java.util.Arrays;
import java.util.HashSet;

import tree.TreeNode;

public class Main {

	public static void main(String[] args) {

		String[] cpdomains = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
		SubdomainVisits subdomainVisits = new SubdomainVisits();
		subdomainVisits.subdomainVisits(cpdomains);

//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(0);
//		root.right = new TreeNode(2);
//		TrimBst trimBst = new TrimBst();
//		trimBst.trimBST(root, 1, 2);

//		int[] A = { 0,1,2,3, 4, 5 };
//		SortedArrayToBst sortedArrayToBst = new SortedArrayToBst();
//		sortedArrayToBst.sortedArrayToBST(A);

		// TODO Auto-generated method stub

//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(0);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(0);
//		root.left.right = new TreeNode(1);
//		root.right.left = new TreeNode(0);
//		root.right.right = new TreeNode(1);
//
//		SumOfBinaryNodes tree = new SumOfBinaryNodes();
//		tree.sumRootToLeaf(root);

		/* Leet code problem 637 */

//		TreeNode node4 = new TreeNode(7);
//		TreeNode node3 = new TreeNode(15);
//		TreeNode node2 = new TreeNode(20, node3, node4);
//		TreeNode node1 = new TreeNode(9, null, null);
//		TreeNode root = new TreeNode(3, node1, node2);
//
//		AvgLvlBinaryTree tree = new AvgLvlBinaryTree();
//		tree.averageOfLevels(root);

		/* Leet code problem 69 */

//		System.out.println("sqrt: " + mySqrt(2147483647) + "     original value: " + Math.sqrt(2147483647));

		/* Leet code problem 237 */

//		ListNode tail = new ListNode(9);
//		ListNode node4 = new ListNode(1, tail);
//		ListNode node1 = new ListNode(5, node4);
//		ListNode head = new ListNode(4, node1);
//
//		deleteNode(node1);

		/* Leet code problem 136 */

//		int[] A = { 4, 1, 2, 1, 2 };
//		System.out.println("result: " + singleNumber(A));
//		singleNumber(A);

		/* Leet code problem 104 */

//		TreeNode node4 = new TreeNode(7);
//		TreeNode node3 = new TreeNode(15);
//		TreeNode node2 = new TreeNode(20, node3, node4);
//		TreeNode node1 = new TreeNode(9, null, null);
//		TreeNode root = new TreeNode(3, node1, node2);
//
//		System.out.println("maxdepth: " + maxDepth(root));

		/* Leet code problem 344 */

//		char[] s = { 'h', 'e', 'f', 'l', 'o', 'n' };
//		reverseString(s);

		/* Leet code problem 349 */

//		int[] nums1 = { 9, 4, 9, 8, 4 };
//		int[] nums2 = { 4, 9, 5 };
//
//		intersection(nums1, nums2);

		/* Leet code problem 206 */

//		ListNode tail = new ListNode(5);
//		ListNode node4 = new ListNode(4, tail);
//		ListNode node3 = new ListNode(3, node4);
//		ListNode node2 = new ListNode(2, node3);
//		ListNode node1 = new ListNode(1, node2);
//		ListNode head = new ListNode(0, node1);
//
//		reverseList(head);

		/* Leet code problem 985 */

//		int[] A = { 1, 2, 3, 4 };
//		int[][] queries = { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } };
//
//		sumEvenAfterQueries(A, queries);

	}

	/* Leet code problem 69 */

	public static int mySqrt(int x) {

		if (x == 0) {
			return 0;
		}

		if (x == 1) {
			return 1;
		}

		int low = 0;
		int high = x;
		double sqr = 0;
		int root = 0;

//		if (x % 2 == 0) {
//			high = x / 2;
//		} else {
//			high = x / 2 + 1;
//		}

		System.out.println("low1: " + low);
		while (high > low + 1) {

			// System.out.println("low1: " + low + " high1: " + high + " root1: " + root);

			if ((high + low) % 2 == 0) {
				root = (high + low) / 2;
			} else {
				root = (high + low) / 2 + 1;
			}

			// System.out.println("low: " + low + " high: " + high + " root: " + root);

			sqr = Math.pow(root, 2);

			System.out.println("root: " + root + "   sqr: " + sqr);

			if (sqr == x) {
				return root;
			}

			if (sqr > x) {
				high = root;
			}

			if (sqr < x) {
				low = root;
			}
		}

		return low;

	}

	/* Leet code problem 237 */

	public static void deleteNode(ListNode node) {

		ListNode tail = new ListNode(9);
		ListNode node4 = new ListNode(1, tail);
		ListNode node1 = new ListNode(5, node4);
		ListNode head = new ListNode(4, node1);

		ListNode prev = head;

		int count = 0;
		boolean isFound = false;
		while (head.next != null && !isFound) {
			System.out.println("head val:" + head.val);
			if (head.val == node.val) {
				prev.next = head.next;
				isFound = true;
			}

			prev = head;
			head = head.next;
			count++;
		}
		System.out.println("count:" + count);

	}

	/* Leet code problem 136 */

	public static int singleNumber(int[] nums) {

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i += 2) {

			if (i == nums.length - 1) {
				return nums[i];
			}
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}

		}

		return nums[nums.length - 1];
	}

	/* Leet code problem 104 */

	// Definition for a binary tree node.
//	public static class TreeNode {
//		int val;
//		TreeNode left;
//		TreeNode right;
//
//		TreeNode() {
//		}
//
//		TreeNode(int val) {
//			this.val = val;
//		}
//
//		TreeNode(int val, TreeNode left, TreeNode right) {
//			this.val = val;
//			this.left = left;
//			this.right = right;
//		}
//	}

	public static int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		} else {
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}

	}

	/* Leet code problem 344 */

	public static void reverseString(char[] s) {

		int start = 0;
		int end = s.length - 1;

		while (start != end && start < end) {

			System.out.println("start: " + start + "   end: " + end);
			char a = s[start];
			s[start] = s[end];
			s[end] = a;
			start++;
			end--;

		}

		printCharArray(s);

	}

	public static void printCharArray(char[] a) {
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}

	/* Leet code problem 349 */

	public static int[] intersection(int[] nums1, int[] nums2) {

		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> resultSet = new HashSet<>();

		// Traverse the input array
		for (int i = 0; i < nums1.length; i++) {
			// If not present, then put it in hashtable and print it
			if (!set1.contains(nums1[i])) {
				set1.add(nums1[i]);
			}
		}

		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i]) && !resultSet.contains(nums2[i])) {
				resultSet.add(nums2[i]);
			}
		}

		int[] result = new int[resultSet.size()];
		int index = 0;

		for (int val : resultSet) {

			result[index] = val;
			index++;
		}

		return result;

	}

	/* Leet code problem 206 */

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void reverseList(ListNode head) {

		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}

		ListNode prev = null;

		while (head != null) {
			ListNode nextNode = head.next;
			head.next = prev;
			prev = head;
			head = nextNode;
		}

		printListNode(tail);
	}

	public static void printListNode(ListNode head) {

		ListNode currentNode = head;
		System.out.print(head.val);

		while (currentNode.next != null) {
			System.out.println(" -> " + currentNode.next.val);
			currentNode = currentNode.next;
		}

	}

	/* Leet code problem 985 */

	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				sum += A[i];
			}
		}

		int[] C = new int[A.length];

		for (int i = 0; i < A.length; i++) {

			int val = queries[i][0];
			int index = queries[i][1];
			int prevVal = A[index];
			A[index] = A[index] + val;

			if (prevVal % 2 == 0) {
				if (A[index] % 2 == 0) {
					sum = sum - prevVal + A[index];
				} else {
					sum = sum - prevVal;
				}

			} else {
				if (A[index] % 2 == 0) {
					sum = sum + A[index];
				}
			}

			C[i] = sum;

		}

		printArray(C);
		return C;

	}

	public static void printArray(int[] a) {
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}
}
