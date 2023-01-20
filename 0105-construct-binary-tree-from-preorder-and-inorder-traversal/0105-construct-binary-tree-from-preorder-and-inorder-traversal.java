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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if(n == 0)
            return null;
        
        if(n == 1)
            return new TreeNode(inorder[0]);
        k = 0; // It is used to reset k value each time. while runnlig test cases gfg/leetcode create one object and call it for each test cases.
               // As it is static variable so this variable value will be same for a particular object.
               // If we won't make it 0 then it may through an error (ArrayIndexOutOfBound).
        return buildtree(inorder, 0, n, preorder);
    }
    
    private static TreeNode buildtree(int inorder[], int i, int j, int preorder[]){
        if(i == j)
            return null;
        if(i+1 == j){
            k++;
            return new TreeNode(inorder[i]);
        }
        
        int x = preorder[k++];
        TreeNode l = null;
        TreeNode r = null;
        
        int m = i, n = j-1;
        while(m>=i && m <j && n>= i && n<j){
            if(inorder[m] == x){
                l = buildtree(inorder, i, m, preorder);
                r = buildtree(inorder, m+1, j, preorder);
                break;
            }
            else if(inorder[n] == x){
                l = buildtree(inorder, i, n, preorder);
                r = buildtree(inorder, n+1, j, preorder);
                break;
            }
            m++;
            n--;
        }
        // for(int m=i; m<j; m++){
        //     if(inorder[m] == x){
        //         l = buildtree(inorder, i, m, preorder);
        //         r = buildtree(inorder, m+1, j, preorder);
        //         break;
        //     }
        // }
        TreeNode root = new TreeNode(x);
        
        root.left = l;
        root.right = r;
        
        return root;
    }
}