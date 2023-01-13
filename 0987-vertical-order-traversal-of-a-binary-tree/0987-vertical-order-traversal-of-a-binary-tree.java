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
class Tuple{
    int x;
    int y;
    TreeNode node;
    Tuple(TreeNode n, int x, int y){
        this.node=n;
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Tuple> q= new LinkedList<>();
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty()){
            Tuple t=q.remove();
            TreeNode n= t.node;
            int x= t.x;
            int y=t.y;
            
            if(!map.containsKey(x)) map.put(x,new TreeMap<>());
            if(!map.get(x).containsKey(y)) map.get(x).put(y,new PriorityQueue<>());
           
            map.get(x).get(y).add(n.val);

            if(n.left!=null) q.add(new Tuple(n.left,x-1,y+1));
            if(n.right!=null) q.add(new Tuple(n.right,x+1,y+1));
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> ym:map.values()){
            list.add( new ArrayList<>());
            for(PriorityQueue<Integer> xy:ym.values()){
                while(!xy.isEmpty()){
                    list.get(list.size()-1).add(xy.remove());
                }
            }
        }
        return list;
    }
}