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
    private int count = 0;
    private final int MAX_DISTANCE = 10;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }

    private int[] dfs(TreeNode node, int distance) {
        if (node == null) return new int[MAX_DISTANCE + 1];
        
        if (node.left == null && node.right == null) {
            int[] res = new int[MAX_DISTANCE + 1];
            res[1] = 1;
            return res;
        }

        int[] left = dfs(node.left, distance);
        int[] right = dfs(node.right, distance);

        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                count += left[i] * right[j];
            }
        }

        int[] res = new int[MAX_DISTANCE + 1];
        for (int i = 1; i < MAX_DISTANCE; i++) {
            res[i + 1] = left[i] + right[i];
        }

        return res;
    }
}