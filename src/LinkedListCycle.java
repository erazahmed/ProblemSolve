import linkedlist.ListNode;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {

		if (head == null) {
			return false;
		}

		ListNode secondNode = head;

		while (secondNode.next != null && secondNode.next.next != null) {

			head = head.next;
			secondNode = secondNode.next.next;
			if (head == secondNode) {
				return true;
			}
		}

		return false;
	}

}
