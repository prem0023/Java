import java.util.*;

class NodeL {
    NodeL left;
    NodeL right;
    int data;
    
    NodeL(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Tree_LevelOrder {

    public static void levelOrder(NodeL root) {
        NodeL n = root;
        Queue<NodeL> q = new LinkedList<>();
        System.out.print(n.data+" ");
        q.offer(n);
        while(q.peek() != null) {
        	n = q.poll();
        	if(n.left != null) {
        		System.out.print((n.left).data+" ");
        		q.offer(n.left);
        	}
        	if(n.right != null) {
        		System.out.print((n.right).data+" ");
        		q.offer(n.right);
        	}
        	
        }
        
    }

	public static NodeL insert(NodeL root, int data) {
        if(root == null) {
            return new NodeL(data);
        } else {
            NodeL cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        NodeL root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}