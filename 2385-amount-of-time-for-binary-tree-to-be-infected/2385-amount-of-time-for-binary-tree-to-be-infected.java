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

class Pair{
    TreeNode node ;
    int lev ;
    
    public Pair(TreeNode node ,int lev){
        this.node = node ;
        this.lev = lev;
    }
}

class Solution {

    public int amountOfTime(TreeNode root, int start) {
        TreeNode[] target = new TreeNode[1];
        HashMap<TreeNode ,TreeNode> map = new HashMap<>(); 
        DFS(root,map,target,start);  

        HashSet<TreeNode> set = new HashSet<>(); // To avoid duplicacy while traversing
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(target[0],0));
        set.add(target[0]);
        int time = 0 ;
        while(!q.isEmpty()){  // BFS traversal
            Pair pair =q.remove();
            TreeNode node = pair.node ;
            time  = pair.lev;

            if(node.left!=null  && !set.contains(node.left)){
                q.add(new Pair(node.left,time+1));
                set.add(node.left);
            }
            if(node.right!=null && !set.contains(node.right)){
                q.add(new Pair(node.right,time+1));
                set.add(node.right);
            }
            if(map.containsKey(node) && !set.contains(map.get(node))){
                q.add(new Pair(map.get(node),time+1));
                set.add(map.get(node));
            }
        }
        return time ;
    }
    // Dfs traversal to form child parent relationship  and node reference of start
    public void DFS(TreeNode root , HashMap<TreeNode ,TreeNode> map,TreeNode[] target,int start){
        if(root==null){
            return ;
        }
        if(root.val == start){
            target[0] = root;
        }
        if(root.left!=null){
            if(root.left.val==start){
                target[0] = root.left;
            }
            map.put(root.left, root);
            DFS(root.left,map,target,start);
        }
        if(root.right!=null){
            if(root.right.val == start){
                target[0] = root.right;
            }
            map.put(root.right,root);
            DFS(root.right,map,target,start);
        }
    }
}