//Preorder Tree Traversal

// Find Missing And Repeating

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

	//Iteration
	public static void preorderRecursive(Node root)
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

		preorderRecursive(root);
	}
}

/*
// Iteration 1
	public static void preorderIterative(Node root)
    {
       
        if (root == null) {
            return;
        }
    
        Stack<Node> stack = new Stack<>();
        stack.push(root);
    
        Node curr = root;
    
        while(!stack.isEmpty()) {
        	
        	if(curr != null) {
        		System.out.print(curr.data + " ");
        		
        		if(curr.right != null)
        			stack.push(curr.right);
        		
        		curr = curr.left;
        	}
        	else
        		curr = stack.pop();
        }
    }
	
	
// Iteration 2
	public static void postorder(Node root)
    {
       
        if (root == null) {
            return;
        }
        
        Stack<Node> stack = new Stack<Node>();
        
        Node curr = root;
        
        while(!stack.isEmpty() || curr != null) {
        	
        	if(curr != null) {
        		System.out.print(curr.data + " ");
        		stack.push(curr);
        		curr = curr.left;
        	}
        		
        	else {
        		curr = stack.pop();
        		
        		curr = curr.right;
   
        	}
        	
        
        }
      
    }
*/
