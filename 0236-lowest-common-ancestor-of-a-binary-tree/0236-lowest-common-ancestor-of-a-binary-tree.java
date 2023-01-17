/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null)
            return null;
        
        if(root == n1 || root == n2)
            return root;
        
        TreeNode b1 = null, b2 = null;
        
        if(root.left != null)
            b1 = lowestCommonAncestor(root.left, n1, n2);
        if(root.right != null)
            b2 = lowestCommonAncestor(root.right, n1, n2);
        
        if(b1 != null && b2 != null)
            return root;
        if(b1 != null)
            return b1;
        if(b2 != null)
            return b2;
        
        return null;
    }
}