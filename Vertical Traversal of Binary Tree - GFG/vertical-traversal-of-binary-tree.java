//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Pair
{
    Node node;
    int level;
    Pair(Node _node, int _level){
        this.node = _node;
        this.level = _level;
    }
}

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList <Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int minLevel = 1001;
        int maxLevel = -1;
        
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Node temp = q.peek().node;
            int level = q.poll().level;
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);
            
            if(map.containsKey(level))
                map.get(level).add(temp.data);
            else{
                List<Integer> l = new ArrayList<>();
                l.add(temp.data);
                map.put(level, l);
                }
            
            if(temp.left != null)
                q.offer(new Pair(temp.left, level-1));
            if(temp.right != null)
                q.offer(new Pair(temp.right, level+1));
        }
        
        for(int i=minLevel; i<=maxLevel; i++){
            List<Integer> temp = map.get(i);
            for(int x : temp)
                ans.add(x);
        }
        return ans;
    }
}