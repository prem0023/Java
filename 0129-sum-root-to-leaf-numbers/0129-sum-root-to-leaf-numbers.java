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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        return sumNumbersHelper(root, 0);
    }
    
    private int sumNumbersHelper(TreeNode root, int currSum){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return currSum*10 + root.val;
        
        int sum1 = sumNumbersHelper(root.left, currSum*10 + root.val);
        int sum2 = sumNumbersHelper(root.right, currSum*10 + root.val);
        
        return sum1 + sum2;
    }
}