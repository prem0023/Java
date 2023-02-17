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
    private int minNum = 100000, prev = -99999;
        void minDIFF(TreeNode root){
            if (root == null) return;
            minDIFF(root.left);
            int s = root.val-prev;
            minNum = minNum<s ? minNum:s;
            prev+=s;
            minDIFF(root.right);
            return;
        }

    public int minDiffInBST(TreeNode root) {
            minDIFF(root);
            return minNum;
        }
}