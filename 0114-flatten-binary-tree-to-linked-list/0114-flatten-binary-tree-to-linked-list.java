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
    ArrayList<Integer> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        getPre(root);
        TreeNode node = root;
        node.left = null;
        node.right = null;
        for(int i = 1; i < list.size() ; i++){
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
    }
    void getPre(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        getPre(root.left);
        getPre(root.right);
        
    }
    
}