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
  
  public boolean isCompleteTree(TreeNode root) {
    if (root == null)
      return true;

    Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

    while (q.peek() != null) {
      TreeNode node = q.poll();
      q.offer(node.left);
      q.offer(node.right);
    }

    while (!q.isEmpty() && q.peek() == null)
      q.poll();

    return q.isEmpty();
  }
}

/*
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        boolean isNull = false;
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left == null && temp.right == null){
                while(!q.isEmpty()){
                    temp = q.poll();
                    if(temp.left != null || temp.right != null)
                        return false;
                }
                return true;
            }
            if(temp.left == null || temp.right == null)
                return false;
            
            q.offer(temp.left);
            q.offer(temp.right);
        }
    }
}
*/