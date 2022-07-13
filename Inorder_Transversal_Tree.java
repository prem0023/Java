// Inorder Transversal Tree

class Node {
	      int data;
	      Node left;
	      Node right;
	      Node() {}
	      Node(int data) { this.data = data; }
	      Node(int data, Node left, Node right) {
	          this.data = data;
	          this.left = left;
	          this.right = right;
	    }
}

class Solution {

    public static void inorder(Node root) {
    	
    	if(root == null)
    		return;
    	
    	inorder(root.left);
    	System.out.print(root.data+ " ");
    	inorder(root.right);
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        inorder(root);
    }
}