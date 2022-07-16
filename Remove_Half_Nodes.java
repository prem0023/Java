//Remove Half Nodes


import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}

	Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class Solution {

	public static Node RemoveHalfNodes(Node root)
    {
        // Code Here
		if(root == null)
            return root;
           
        else if(root.right == null && root.left == null){
            return root;
        }
        
        else if(root.right != null && root.left != null){ 
            
            root.left = RemoveHalfNodes(root.left);
            root.right = RemoveHalfNodes(root.right);
        }
        else if(root.right == null){
            root = root.left;
            root = RemoveHalfNodes(root);
        }
        else{
            root = root.right;
            root = RemoveHalfNodes(root);
        }
        
        return root;
        
    }
	
	public static void preorderIterative(Node root)
    {
       
        if (root == null) {
            return;
        }
  
        System.out.print(root.data + " ");
        
        preorderIterative(root.left);
        
        preorderIterative(root.right);
    
      
    }

	public static void main(String[] args) {

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

		root = RemoveHalfNodes(root);
		preorderIterative(root);
	}
}
