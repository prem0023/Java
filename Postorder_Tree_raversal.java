// Postorder Tree Traversal


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

	// Iteration
	public static void preorderIterative(Node root)
    {
       
        if (root == null) {
            return;
        }
        
        preorderIterative(root.left);
        
        preorderIterative(root.right);
        
        System.out.print(root.data + " ");
      
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

		preorderIterative(root);
	}
}

/*
// Iteration
	public static void postorder(Node root)
    {
       
        if (root == null) {
            return;
        }
        
        Stack<Node> stack = new Stack<Node>();
        Stack<Integer> res = new Stack<Integer>();
        
        
        stack.push(root);
        
        while(!stack.isEmpty()) {
        	
        	Node temp = stack.pop();
        	res.push(temp.data);
        	
        	if(temp.left != null)
        		stack.push(temp.left);
        	
        	if(temp.right != null)
        		stack.push(temp.right);
        	
        }
        
        while(!res.isEmpty()) {
        	System.out.print(res.pop() + " ");
        }
      
    }
	
*/
