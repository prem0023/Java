// Reverse Linked List

class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        Node root = head;
        Node prev = null;
        
        while(root != null){
            Node temp = root.next;
            root.next = prev;
            prev = root;
            root = temp;
        }
        
        return prev;
    }
}

/* linked list node class:

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/
