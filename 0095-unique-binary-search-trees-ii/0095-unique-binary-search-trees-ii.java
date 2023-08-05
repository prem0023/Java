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
public class Solution {
    Map<Pair<Integer, Integer>, List<TreeNode>> m = new HashMap<>();

    public List<TreeNode> solve(int start, int end) {
        List<TreeNode> v = new ArrayList<>();
        if (start > end) {
            v.add(null);
            return v;
        }
        if (start == end) {
            v.add(new TreeNode(start));
            return v;
        }
        if (m.containsKey(new Pair<>(start, end)))
            return m.get(new Pair<>(start, end));
        for (int i = start; i <= end; i++) {
            List<TreeNode> l = solve(start, i - 1);
            List<TreeNode> r = solve(i + 1, end);
            for (TreeNode x : l) {
                for (TreeNode x1 : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = x;
                    root.right = x1;
                    v.add(root);
                }
            }
        }
        m.put(new Pair<>(start, end), v);
        return v;
    }

    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
}
