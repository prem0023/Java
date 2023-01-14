//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

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

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			
			    if(g.isBalanced(root) == true)
    			    System.out.println(1);
    			else 
    			    System.out.println(0);
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function Template for Java


/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */

class Tree
{
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root){
        if(root == null)
            return true;
        
        Map<Node, Integer> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        int h = getHeight(root, map);
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int height_left = 0;
            int height_right = 0;
            
            if(node.left != null){
                q.offer(node.left);
                height_left = map.get(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
                height_right = map.get(node.right);
            }
            
            if(Math.abs(height_left - height_right) > 1)
                return false;
        }
        
        return true;
    }
    private int getHeight(Node root, Map<Node, Integer> map){
        if(root == null)
            return 0;
        
        if(map.containsKey(root))
            return map.get(root);
        
        int height_left = getHeight(root.left, map);
        int height_right = getHeight(root.right, map);
        
        int height = Math.max(height_left, height_right) + 1;
        
        map.put(root, height);
        return height;
    }
}

