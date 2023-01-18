 // Problem Link : https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1

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


/*
// Method 2
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

*/
