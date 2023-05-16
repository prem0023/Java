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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left=head,rigth=head;
        for(int i=1;i<k;i++)
        left=left.next;
        ListNode curr = left;
        while(curr.next!=null){
            curr = curr.next;
            rigth=rigth.next;
        }
        int t = left.val;
        left.val = rigth.val;
        rigth.val =t;
        return head;
    }
}