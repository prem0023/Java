import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NodeT {
    NodeT left;
    NodeT right;
    int data;
    
    NodeT(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Tree_TopView {

    public static void topView(NodeT root) {
        NodeT n = root;
        ArrayList<Integer> l = new ArrayList<Integer>();
        
        l.add(n.data);
        Queue<NodeT> q = new LinkedList<>();
        //System.out.print(n.data+" ");
        q.offer(n);
        while(q.peek() != null) {
        	n = q.poll();
        	if(n.left != null) {
        		l.add((n.left).data);
        		q.offer(n.left);
        	}		
        }
        
        Collections.reverse(l);
        
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()) {
        	System.out.print(it.next()+" ");
        }
        l.clear();
        
        n = root;
        q.offer(n);
        while(q.peek() != null) {
        	n = q.poll();
        	if(n.right != null) {
        		l.add((n.right).data);
        		q.offer(n.right);
        	}		
        }
        //Collections.reverse(l);
        Iterator<Integer> itr = l.iterator();
        while(itr.hasNext()) {
        	System.out.print(itr.next()+" ");
        }
        
        
    }

	public static NodeT insert(NodeT root, int data) {
        if(root == null) {
            return new NodeT(data);
        } else {
            NodeT cur;
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
        NodeT root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}