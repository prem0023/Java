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
    // Time Complexity :- O(n.log(n));
    public int[] treeQueries(TreeNode root, int[] queries) {
        int m = maximum_value(root);
        int[] depth = new int[m+1];
        int[] level = new int[m+1];
        
        dfs(root,0,depth,level);
        
        // level -> (depth -> frequency)
        TreeMap<Integer,TreeMap<Integer,Integer>> map = new TreeMap<>();
        for(int i=1;i<=m;i++) {
            int l = level[i];
            int v = i;
            TreeMap<Integer,Integer> m1;
            if(map.containsKey(l)) {
                m1 = map.get(l);
                if(m1.containsKey(depth[v])) {
                    m1.put(depth[v],m1.get(depth[v])+1);
                } else {
                    m1.put(depth[v],1);
                }
            } else {
                m1 = new TreeMap<>();
                m1.put(depth[v],1);
            }
            map.put(l,m1);
        }
        
        
        // System.out.println(map);
        for(int i=0;i<queries.length;i++) {
            int q = queries[i];
            int ans = level[q]-1;
            TreeMap<Integer,Integer> m1 = map.get(level[q]);
            
            if(m1.get(depth[q])==1) {
                m1.remove(depth[q]);
            } else {
                m1.put(depth[q],m1.get(depth[q])-1);
            }
            
            if(m1.size()>0) {
                ans+=m1.lastKey();
            }
            
            if(m1.containsKey(depth[q])) {
                m1.put(depth[q],m1.get(depth[q])+1);
            } else {
                m1.put(depth[q],1);
            }
            
            queries[i]=ans;
        }
        return queries;
        
    }
    
    public static int maximum_value(TreeNode root) {
        if(root==null) return 0;
        int a1 = maximum_value(root.left);
        int a2 = maximum_value(root.right);
        
        return Math.max(a1,Math.max(a2,root.val));
    }
    
    
    public static int dfs(TreeNode root,int lvl,int[] depth,int[] level) {
        if(root==null) {
            return 0;
        }
        
        
        level[root.val]=lvl;
        
        int a1 =dfs(root.left,lvl+1,depth,level);
        int a2 =dfs(root.right,lvl+1,depth,level);
        
        return depth[root.val]=Math.max(a1,a2)+1;
    }
}