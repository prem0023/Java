//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        
        helper(root1, st1);
        helper(root2, st2);
        
        while(!st1.isEmpty() && !st2.isEmpty()){
            Node temp1 = st1.peek();
            Node temp2 = st2.peek();
            
            if(temp1.data < temp2.data){
                st1.pop();
                ans.add(temp1.data);
                helper(temp1.right, st1);
            }
            else{
                st2.pop();
                ans.add(temp2.data);
                helper(temp2.right, st2);
            }
        }
        if(!st1.isEmpty()) {
        	Node temp = st1.pop();
        	ans.add(temp.data);
        	st1.push(temp.right);
        	inorder(st1, ans);
        }
        if(!st2.isEmpty()) {
        	Node temp = st2.pop();
        	ans.add(temp.data);
        	st2.push(temp.right);
        	inorder(st2, ans);
        }
        
        return ans;
    }
    
    private void inorder(Stack<Node> st, List<Integer> ans){
        if(st.isEmpty())
            return;
        Node temp = st.pop();
        while(temp != null || !st.isEmpty()){
            while(temp != null){
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            ans.add(temp.data);
            temp = temp.right;
        }
    }
    
    private void helper(Node root, Stack<Node> st){
        if(root == null)
            return;
        
        Node temp = root;
        
        while(temp != null){
            st.push(temp);
            temp = temp.left;
        }
    }
}
