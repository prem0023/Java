// Diameter of Binary Tree

class Solution {
    
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        if (root.left == null && root.right == null)
            return 0; //for gfg return 1;
        
        getHeight(root);
        
        return ans;
    }
    
    int getHeight(TreeNode root){
        
        if (root == null)
            return 0;
        
        if(root.left == null && root.right == null){
            ans = Math.max(ans, 1);
            return 1;
        }
        
        //get height of left node and right node
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        
        ans = Math.max(l+r, ans);  // for gfg Math.max(l+r+1, ans);
        
        return Math.max(l, r) + 1; 
    }
   
}


/*
//Method - 2
class Solution {
    
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        int d = lh+rh;
        
        
        return left > right ? (left > d ? left : d) : (right > d ? right : d);
    
    }
    
    int getHeight(TreeNode root){
        
        if(root == null)
            return 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(root).append(" ");
        String key = sb.toString();
        
        if(hm.containsKey(key))
            return hm.get(key);
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        int x = lh > rh ? (lh+1) : (rh+1);
        
        hm.put(key, x);
        return x;
        
    }
}

//Method - 3
class Solution {
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    public int diameterOfBinaryTree(TreeNode root) {
        
        return getDiameterOrHeight(root, "diameter");
        
    }
    int getDiameterOrHeight(TreeNode root, String s){
        
        if(root == null)
            return 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(root).append(" ").append(s);
        String key = sb.toString();
        
        if(hm.containsKey(key))
            return hm.get(key);
        
        int left = getDiameterOrHeight(root.left, "diameter");
        int right = getDiameterOrHeight(root.right, "diameter");
        
        int lh = getDiameterOrHeight(root.left, "height");
        int rh = getDiameterOrHeight(root.right, "height");
        
        int x = 0;
        
        if(s == "height")
            x = lh > rh ? (lh+1) : (rh+1);
        
        else
            x = left > right ? (left > lh+rh ? left : lh+rh) : (right > lh+rh ? right : lh+rh);
    
        hm.put(key,x);
        return x;
    }
}
*/