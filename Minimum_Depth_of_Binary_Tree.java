// Minimum Depth of a Binary Tree

class Solution
{
	int minDepth(Node root)
	{
	    //code here
	    if(root == null)
            return 0;
        
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        
        if(lh == 0 || rh == 0)
            return lh+rh+1;
        
        return lh < rh ? (lh+1) : (rh+1);
	}

}