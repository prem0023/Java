// Maximum Path Sum between 2 Leaf Nodes

// Method - 1
class Solution
{
    int ans = Integer.MIN_VALUE;
    int maxPathSum(Node root)
    { 
        // code here 
        if(root.left == null && root.right == null)
            return root.data;
            
        int temp = getSum(root);
        
        if (root.left == null || root.right == null)
            return Math.max(temp, ans);

        return ans;
    }
    
    int getSum(Node root){
        
        if(root == null)
            return 0;
            
        int left = getSum(root.left);
        int right = getSum(root.right);
        
        int temp = 0;
        
        if(root.left == null || root.right == null)
            temp = left + right + root.data;
        
        else
            temp = Math.max(left, right) + root.data;
        
        if(root.left != null && root.right != null)
            ans = Math.max(ans, left + right + root.data);

            
        return temp;
    }
}


/*
// Method - 2
class Solution
{
    int ans = Integer.MIN_VALUE;
    int res = 0;
    int c = 0;
    int maxPathSum(Node root)
    { 
        // code here 
        if(root.left == null && root.right == null)
            return root.data;
            
        getSum(root);
        
        if (c == 1)
            return Math.max(res, ans);

        return ans;
    }
    
    int getSum(Node root){
        
        if(root == null)
            return 0;
            
        int left = getSum(root.left);
        int right = getSum(root.right);
        
        int temp = 0;
        
        if(root.left == null || root.right == null)
            temp = left + right + root.data;
        
        else
            temp = Math.max(left, right) + root.data;
        
        if(root.left != null && root.right != null){
            int res = left + right + root.data;
            ans = Math.max(ans, res);
            c = 0;
        }
        else if(root.left != null || root.right != null){
            res = left + right + root.data;
            c = 1;
        }
            
        return temp;
    }
}
*/