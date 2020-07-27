import linkedlist.ListNode;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode iterationListHead;
		ListNode comparativeListHead;

		if (l1.val < l2.val) {
			iterationListHead = l1;
			comparativeListHead = l2;
		} else {
			iterationListHead = l2;
			comparativeListHead = l1;
		}

		ListNode node = iterationListHead;
		while (comparativeListHead != null) {

			if (node.next == null) {
				node.next = comparativeListHead;
				break;
			}

			if (node.next.val > comparativeListHead.val) {

				ListNode temp = comparativeListHead.next;
				comparativeListHead.next = node.next;
				node.next = comparativeListHead;
				comparativeListHead = temp;

			}

			node = node.next;
		}

		return iterationListHead;

	}

}
