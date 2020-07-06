import linkedlist.ListNode;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {

		if (head == null || head.next == null || head.next.next == null) {
			return false;
		}

		head = head.next;
		ListNode secondNode = head.next.next;

		while (head.val != secondNode.val) {
			if (head.next != null) {
				head = head.next;
			} else {
				return false;
			}
			if (secondNode.next != null && secondNode.next.next != null) {
				secondNode = secondNode.next.next;
			} else {
				return false;
			}
		}
		return true;
	}

}
