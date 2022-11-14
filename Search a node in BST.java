class BST {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        // Your code here
        Node temp = root;
        
        while(temp != null){
            if(temp.data == x)
                return true;
            else if(temp.data > x)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return false;
    }
}
