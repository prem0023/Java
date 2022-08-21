// Binary Tree Maximum Path Sum

class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        if(root.left == null && root.right == null)
            return root.val;
        
        getSum(root);
        return ans;
    }
    
    int getSum(TreeNode root){
        
        if(root == null)
            return 0;
        
        int left = Math.max(0, getSum(root.left));
        int right = Math.max(0, getSum(root.right));
        
        ans = Math.max(ans, left+right+root.val);
        
        return Math.max(left, right) + root.val;
		
		//root.left = null;
        //root.right = null;
        //root.val = Math.max(left, right) + root.val;
        
        //return root.val;
    }
}