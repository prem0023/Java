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
	
	//Recursion
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


/*
// Iteration
// Method - 1
	public static void inorder(Node root) {

		Stack<Node> stack = new Stack<Node>();
		//Node temp = root;
		Node curr = root;
		
		while (!stack.isEmpty() || curr != null) {
			
			
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
				
			}
			else {
				curr = stack.pop();
				System.out.print(curr.data + " ");
				
				curr = curr.right;
				
			}
		}
	}


//Iteration
//Method - 2
public static void inorder(Node root) {

		Stack<Node> stack = new Stack<Node>();
		Node temp = root;
		stack.push(temp);

		while (!stack.isEmpty()) {
			Node t = stack.peek();
			if (t.left != null)
				stack.push(t.left);
			else {
				t = stack.pop();
				System.out.print(t.data + " ");
				if (t.right != null) {
					stack.push(t.right);
					continue;
				}
				if (stack.isEmpty())
					return;
				t = stack.pop();
				System.out.print(t.data + " ");
				while (t.right == null) {
					if (stack.isEmpty())
						return;
					t = stack.pop();
					System.out.print(t.data + " ");
				}

				stack.push(t.right);
			}
		}
	}
	
*/
