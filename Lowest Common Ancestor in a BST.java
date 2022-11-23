class BST
{   
    //Function to find the lowest common ancestor in a BST. 
	Node LCA(Node root, int n1, int n2)
	{
        // code here.
        if(root == null)
            return null;
        
        if((root.data > n1 && root.data < n2) || (root.data < n1 && root.data > n2))
            return root;
        
        if(root.data == n1 || root.data == n2)
            return root;
        
        Node temp = null;
        
        if(root.data > n1 && root.data > n2)
            temp = LCA(root.left, n1, n2);
        else
            temp = LCA(root.right, n1, n2);
        
        return temp;
    }
}
