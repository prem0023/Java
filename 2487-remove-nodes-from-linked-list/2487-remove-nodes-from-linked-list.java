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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head.next;
        stack.push(head.val);
        
        while(curr != null){
            int data = curr.val;
            
            while(!stack.isEmpty() && stack.peek() < data){
                stack.pop();
            }
            
            stack.push(data);
            curr = curr.next;
        }
        
        head = null;
        
        while(!stack.isEmpty()){
            ListNode temp = head;
            head = new ListNode(stack.pop());
            head.next = temp;
        }
        
        return head;
    }
}