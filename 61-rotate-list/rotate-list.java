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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode currNode = head;
        ListNode nextNode = head;
        ListNode prevNode = null;
        int size = 1;

        if(head == null || k == 0){
            return head;
        }

        while(nextNode.next != null && size < k){
            size++;
            nextNode = nextNode.next;
        }
        if(nextNode.next == null && size == k){
            return head;
        }else if(nextNode.next != null){
            while(nextNode.next != null)
            {
                prevNode = currNode;
                currNode = currNode.next;
                nextNode = nextNode.next;
            }
            prevNode.next = null;
            nextNode.next = head;
            return currNode;
        }
        k = k % size;
        return rotateRight(head, k);
    }
}