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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Boolean result = false;
    public boolean isSubPath(ListNode head, TreeNode root) {
        traverse(head, root);
        return result;
    }
    
    private void traverse(ListNode head, TreeNode root) {
        if(head != null && root != null) {
            if(head.val == root.val) {
                validate(head, root);
            } 
            if(result)
                return;
            else {
                traverse(head, root.left);
                traverse(head, root.right);

            }
        } 
    }
    
    private void validate(ListNode head, TreeNode root) {
        if(head == null) {
            result = true;
            return;
        } else {
            if(head == null || root == null)
                return;
            if(head.val == root.val) {
                validate(head.next, root.left);
                validate(head.next, root.right);
            } else {
                return;
            }
        }
    }
    
}