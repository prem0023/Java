//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

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
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
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
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }
class Pair
{
    Node node;
    int dist;
    Pair(Node _node, int _dist){
        this.node = _node;
        this.dist = _dist;
    }
}

class Solution {
	public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
		HashMap<Node, Node> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<>();

		insertNode(root, map, null);

		q.offer(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.data == target) {
				bfs(temp, map, ans, k);
				q.clear();
			}
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);
		}
		Collections.sort(ans);
		return ans;
	}

	private static void insertNode(Node root, HashMap<Node, Node> map, Node prev) {
		if (root == null)
			return;

		map.put(root, prev);

		if (root.left != null)
			insertNode(root.left, map, root);
		if (root.right != null)
			insertNode(root.right, map, root);
	}

	private static void bfs(Node root, HashMap<Node, Node> map, ArrayList<Integer> ans, int k) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		HashMap<Node, Boolean> hm = new HashMap<>();
		hm.put(root, true);

		while (!q.isEmpty()) {
			Pair p = q.poll();
			Node node = p.node;
			int dist = p.dist;

			if (dist == k)
				ans.add(node.data);

			if (node.left != null && !hm.containsKey(node.left) && dist < k) {
				q.offer(new Pair(node.left, dist + 1));
				hm.put(node.left, true);
			}
			if (node.right != null && !hm.containsKey(node.right) && dist < k) {
				q.offer(new Pair(node.right, dist + 1));
				hm.put(node.right, true);
			}
			if (map.get(node) != null && !hm.containsKey(map.get(node)) && dist < k) {
				q.offer(new Pair(map.get(node), dist + 1));
				hm.put(map.get(node), true);
			}
		}
	}
};