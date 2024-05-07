/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        // If the head's value is greater than 4, 
        // insert a new node with value 0 at the beginning
        if (head.val > 4) {
            head = new ListNode(0, head);
        }
        
        ListNode temp = head;
        while (temp != null) {
            // Double the value and take modulo 10 to handle carry
            temp.val = (temp.val * 2) % 10;
            
            // If the next node exists and its value is greater than 4, 
            // increment current node's value
            if (temp.next != null && temp.next.val > 4) {
                temp.val++;
            }
            
            temp = temp.next; // Move to the next node
        }
        
        return head;
    }
}