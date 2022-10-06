// Nth node from end of linked list

class Solution {
	// Function to find the data of nth node from the end of a linked list.
	int getNthFromLast(Node head, int n) {
	    
		Node ahead = head;
		Node prev = head;
		int count = 1;
		
		while (count < n) {
			if (ahead == null)
				return -1;
			else {
				count++;
				ahead = ahead.next;
			}
		}
		if (ahead == null)
			return -1;
			
		while (ahead.next != null) {
			ahead = ahead.next;
			prev = prev.next;
		}
		return prev.data;
	}
}