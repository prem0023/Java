// Move last element to front of a given Linked List

class Node {
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
	
class Solution {

	Node moveToFront(Node head)
	{
		if (head == null || head.next == null)
			return;

		Node secLast = null;
		Node last = head;

		while (last.next != null) {
			secLast = last;
			last = last.next;
		}

		secLast.next = null;

		last.next = head;

		head = last;
		
		return head;
	}
}