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
    public int kthSmallest(TreeNode root, int k) {
        Set<Integer> set = new TreeSet<>();
        traverseBST(root, set);
        int count = 1;
        for (int n : set) {
            if (count++ == k) return n;
        }
        return k;
    }

    private void traverseBST(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        set.add(node.val);
        traverseBST(node.left, set);
        traverseBST(node.right, set);
    }
}