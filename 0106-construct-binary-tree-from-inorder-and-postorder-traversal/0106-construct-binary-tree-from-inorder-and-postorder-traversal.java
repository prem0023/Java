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
    static int k = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n == 0)
            return null;
        
        if(n == 1)
            return new TreeNode(inorder[0]);
        k = n; // It is used to reset k value each time. while runnlig test cases gfg/leetcode create one object and call it for each test cases.
               // As it is static variable so this variable value will be same for a particular object.
               // If we won't make it 0 then it may through an error (ArrayIndexOutOfBound).
        return buildtree(inorder, 0, n, postorder);
    }
    
    private static TreeNode buildtree(int inorder[], int i, int j, int postorder[]){
        if(i == j)
            return null;
        if(i+1 == j){
            k--;
            return new TreeNode(inorder[i]);
        }
        
        int x = postorder[--k];
        TreeNode l = null;
        TreeNode r = null;
        
        for(int m=i; m<j; m++){
            if(inorder[m] == x){
                r = buildtree(inorder, m+1, j, postorder);
                l = buildtree(inorder, i, m, postorder);
                break;
            }
        }
        TreeNode root = new TreeNode(x);
        
        root.left = l;
        root.right = r;
        
        return root;
    }
}