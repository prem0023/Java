//Invert Binary Tree

class Solution {
    public TreeNode invertTree(TreeNode root) {
        //ArrayList <Integer> al = new ArrayList <Integer>();
        
        if(root == null)
            return root;
        
        Queue <TreeNode> temp = new LinkedList <TreeNode>();
        
        Queue <TreeNode> tre = new LinkedList <TreeNode>();
        
        temp.add(root);
        TreeNode tree = new TreeNode(root.val);
        tre.add(tree);
        
        
        while(!temp.isEmpty()){
            TreeNode t = temp.poll();
            TreeNode t1 = tre.poll();
            
            if(t.right != null){
                temp.add(t.right);
                //TreeNode te = new TreeNode(t.right.val);
                t1.left = new TreeNode(t.right.val);;
                tre.add(t1.left);
                
            }
            if(t.left != null){
                temp.add(t.left);
                //TreeNode te = new TreeNode(t.left.val);
                t1.right = new TreeNode(t.left.val);;
                tre.add(t1.right);
            }
            
        }
        
        return tree;
    }
}

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