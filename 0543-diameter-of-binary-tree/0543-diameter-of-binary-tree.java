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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        int dia = findHeight(root, d);
        
        return d[0]-1;
    }
    
    private int findHeight(TreeNode root, int[] d){
        if(root == null)
            return 0;
        
        int left_height = findHeight(root.left, d);
        int right_height = findHeight(root.right, d);
        
        d[0] = Math.max(d[0], left_height + right_height + 1);
        
        return Math.max(left_height, right_height) + 1;
    }
}