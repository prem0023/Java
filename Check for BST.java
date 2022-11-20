public class Solution
{
    boolean solve(Node root,int min,int max){
        if(root==null)
            return true;
        
        if(root.data>=max || root.data<=min)
            return false;
        
        boolean left = solve(root.left,min,root.data);
        boolean right = solve(root.right,root.data,max);
        
        return (left && right);
    }
    boolean isBST(Node root)
    {
        // code here.
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return solve(root,min,max);
    }
}
/*
public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        // code here.
        if(root == null)
            return true;
        
        if(root.left != null && root.left.data >= root.data)
            return false;
        
        if(root.right != null && root.right.data <= root.data)
            return false;
        
        boolean l = isLeftBST(root.left, root.data);
        boolean r = isRightBST(root.right, root.data);
        
        if(l == true && r == true)
            return true;
        
        return false;
    }
    
    boolean isLeftBST(Node root, int x)
    {
        // code here.
        if(root == null)
            return true;
        
        if(root.data >= x)
            return false;
        
        if(root.left != null && root.left.data >= root.data)
            return false;
        
        if(root.right != null && root.right.data <= root.data)
            return false;
        
        boolean l = isLeftBST(root.left, x);
        boolean r = isLeftBST(root.right, x);
        
        if(l == true && r == true)
            return true;
        
        return false;
    }
    
    boolean isRightBST(Node root, int x)
    {
        // code here.
        if(root == null)
            return true;
        
        if(root.data <= x)
            return false;
        
        if(root.left != null && root.left.data >= root.data)
            return false;
        
        if(root.right != null && root.right.data <= root.data)
            return false;
        
        boolean l = isRightBST(root.left, x);
        boolean r = isRightBST(root.right, x);
        
        if(l == true && r == true)
            return true;
        
        return false;
    }
    
}

*/

// Link : https://practice.geeksforgeeks.org/problems/check-for-bst/1
