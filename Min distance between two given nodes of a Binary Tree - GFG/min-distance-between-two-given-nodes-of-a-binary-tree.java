//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}


// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = lca(root, a, b);
        
        return findDistance(lca, a, 0) + findDistance(lca, b, 0);
    }
    
    private Node lca(Node root, int n1,int n2)
	{
		// Your code here
		if(root == null)
            return null;
        
        if(root.data == n1 || root.data == n2)
            return root;
        
        Node b1 = null, b2 = null;
        
        if(root.left != null)
            b1 = lca(root.left, n1, n2);
        if(root.right != null)
            b2 = lca(root.right, n1, n2);
        
        if(b1 != null && b2 != null)
            return root;
        if(b1 != null)
            return b1;
        if(b2 != null)
            return b2;
        
        return null;
	}
	
	private int findDistance(Node root, int x, int dist){
        if(root == null)
            return 0;
        
        if(root.data == x)
            return dist;
        
        int d1 = 0, d2 = 0;
        
        if(root.left != null)
            d1 = findDistance(root.left, x, dist+1);
        if(root.right != null)
            d2 = findDistance(root.right, x, dist+1);
        
        if(d1 != 0)
            return d1;
        
        return d2;
	}
}