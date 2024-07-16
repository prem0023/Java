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
    HashMap<Integer, TreeNode> parent = new HashMap<>();
    HashMap<Integer, Integer> height = new HashMap<>();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder firstPath = new StringBuilder();
        StringBuilder secondPath = new StringBuilder();
        
        TreeNode lca = findLCA(root, startValue, destValue);
        construct(lca, firstPath, startValue);
        construct(lca, secondPath, destValue);
        
        firstPath.reverse();
        secondPath.reverse();
        
        return "U".repeat(firstPath.length()) + secondPath.toString();
    }
    private void dfs(TreeNode p, TreeNode root, int h) {
        if (root == null) return;
        dfs(root, root.left, h + 1);
        dfs(root, root.right, h + 1);
        parent.put(root.val, p);
        height.put(root.val, h);
    }
    
    private TreeNode findLCA(TreeNode root, int u, int v) {
        dfs(null, root, 0);
        TreeNode lca = null;
        
        while (u != v) {
            if (parent.get(u) == parent.get(v)) {
                lca = parent.get(u);
                break;
            }
            if (height.get(u) > height.get(v)) {
                if (parent.get(u).val == v) lca = parent.get(u);
                u = parent.get(u).val;
            } else {
                if (parent.get(v).val == u) lca = parent.get(v);
                v = parent.get(v).val;
            }
        }
        
        return lca;
    }
    
    private boolean construct(TreeNode root, StringBuilder s, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        
        boolean left = construct(root.left, s, val);
        boolean right = construct(root.right, s, val);
        
        if (left) s.append("L");
        else if (right) s.append("R");
        
        return left || right;
    }
}