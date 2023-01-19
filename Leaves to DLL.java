//Problem link : https://practice.geeksforgeeks.org/problems/leaves-to-dll/1

class Tree{
    // return the head of the DLL and remove those node from the tree as well.
    public Node convertToDLL(Node root)
    {
        // Code here
        if(root == null)
            return null;
        
        if(root.left == null && root.right == null)
            return root;
        
        Node l = convertToDLL(root.left);
        Node r = convertToDLL(root.right);
        
        Node temp = l;
        if(l != null){
            while(temp.right != null)
                temp = temp.right;
        }
        
        if(l != null)
            temp.right = r;
        if(r != null)
            r.left = temp;
        
        if(root.left == l)
            root.left = null;
        if(root.right == r)
            root.right = null;
        
        if(l == null)
        	return r;
        return l;
    }
    
}

/*
Node is as follows:
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
