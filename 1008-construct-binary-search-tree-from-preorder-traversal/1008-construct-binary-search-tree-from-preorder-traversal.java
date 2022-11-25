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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i=1; i<preorder.length; i++)
            insertNode(root, preorder[i]);
        
        return root;
    }
    
    public void insertNode(TreeNode root, int x){
        if(root == null){
            root = new TreeNode(x);
            return;
        }
        if(root.val > x){
            if(root.left == null){
                root.left = new TreeNode(x);
                return;
            }
            insertNode(root.left, x);
        }
        else{
            if(root.right == null){
                root.right = new TreeNode(x);
                return;
            }
            insertNode(root.right, x);
        }
    }
}