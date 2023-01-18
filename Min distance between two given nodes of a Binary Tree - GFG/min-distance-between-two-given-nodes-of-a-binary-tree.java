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

class Pair
{
    Node node;
    int dist;
    Pair(Node _node, int _dist){
        this.node = _node;
        this.dist = _dist;
    }
}

class GfG {
    int findDist(Node root, int a, int b) {
		HashMap<Node, Node> map = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		
		insertNode(root, map, null);
		
		q.offer(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.data == a)
				return bfs(temp, map, b);
			
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);
		}
		return -1;
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

	private static int bfs(Node root, HashMap<Node, Node> map, int b) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		HashMap<Node, Boolean> hm = new HashMap<>();
		hm.put(root, true);

		while (!q.isEmpty()) {
			Pair p = q.poll();
			Node node = p.node;
			int dist = p.dist;

			if (node.data == b)
				return dist;

			if (node.left != null && !hm.containsKey(node.left)) {
				q.offer(new Pair(node.left, dist + 1));
				hm.put(node.left, true);
			}
			if (node.right != null && !hm.containsKey(node.right)) {
				q.offer(new Pair(node.right, dist + 1));
				hm.put(node.right, true);
			}
			if (map.get(node) != null && !hm.containsKey(map.get(node))) {
				q.offer(new Pair(map.get(node), dist + 1));
				hm.put(map.get(node), true);
			}
		}
		return -1;
	}
};