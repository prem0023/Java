// Intersection Point in Y Shapped Linked Lists

class Intersect {
	// Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2) {
		int size1 = 0;

		int size2 = 0;

		Node tt1 = head1;

		Node tt2 = head2;

		while (tt1 != null)

		{

			size1++;

			tt1 = tt1.next;

		}

		while (tt2 != null)

		{

			size2++;

			tt2 = tt2.next;

		}

		int maxsize = size1 >= size2 ? size1 : size2;

		int minsize = size1 <= size2 ? size1 : size2;

		Node maxNode = size1 > size2 ? head1 : head2;

		Node minNode = size2 < size1 ? head2 : head1;

		int extrasize = maxsize - minsize;

		while (extrasize > 0 && maxNode != null)

		{

			maxNode = maxNode.next;

			extrasize--;

		}

		while (maxNode != minNode)

		{

			maxNode = maxNode.next;

			minNode = minNode.next;

		}

		return maxNode.data;
	}
}

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/