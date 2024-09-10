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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head.next, prev = head;
        
        while(curr != null){
            ListNode temp = new ListNode(findGCD(prev.val, curr.val));
            prev.next = temp;
            temp.next = curr;
            prev = curr;
            curr = curr.next;
        }
        
        return head;
    }
    
    static int findGCD(int a, int b)   
    {   
        while(b != 0)  
        {  
            int temp = b;  
            b = a % b;  
            a = temp;  
        }
        return a;
        
    }  
}