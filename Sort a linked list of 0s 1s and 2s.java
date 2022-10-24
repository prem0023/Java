// Sort a linked list of 0s, 1s and 2s

class Solution {
	// Function to sort a linked list of 0s, 1s and 2s.
	static Node segregate(Node head) {

		int countzero = 0, countone = 0, counttwo = 0;
		Node temp = head;
		while (temp != null) {
			if (temp.data == 0)
				countzero++;
			if (temp.data == 1)
				countone++;
			if (temp.data == 2)
				counttwo++;
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			if (countzero > 0) {
				temp.data = 0;
				countzero -= 1;
				temp = temp.next;
			} else if (countone > 0) {
				temp.data = 1;
				countone -= 1;
				temp = temp.next;
			} else {
				temp.data = 2;
				counttwo -= 1;
				temp = temp.next;
			}
		}
		return head;
	}
}

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
