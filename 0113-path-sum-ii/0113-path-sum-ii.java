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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        
        findPathSum(root, ans, new ArrayList<Integer>(), targetSum, 0);
        
        return ans;
    }
    
    private void findPathSum(TreeNode root, List<List<Integer>> ans, List<Integer> l, int targetSum, int sum){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            if(targetSum == sum + root.val){
                List<Integer> temp = new ArrayList<>(l);
                temp.add(root.val);
                ans.add(temp);
            }
        }
        l.add(root.val);
        
        if(root.left != null)
            findPathSum(root.left, ans, l, targetSum, sum + root.val);

        if(root.right != null)
            findPathSum(root.right, ans, l, targetSum, sum + root.val);
        
        l.remove(l.size()-1);
    }
}