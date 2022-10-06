// Middle of Linked List

class Solution
{
    int getMiddle(Node head)
    {
         // Your code here.
         Node root = head;
         Node mid = head;
         
         while(root != null && root.next != null){
             root = root.next.next;
             mid = mid.next;
         }
         
         return mid.data;
    }
}