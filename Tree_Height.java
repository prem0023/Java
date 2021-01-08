import java.util.*;

class NodeTree {
    NodeTree left;
    NodeTree right;
    int data;
    
    NodeTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Tree_Height {

    static int c=0;
	public static int height(NodeTree root) {

        NodeTree n = root;
        if( n!= null){
            int x = height(n.left);
            int y = height(n.right);
            
            if(x>y)
                return x+1;
            else
                return y+1;
            
        }
        return -1;
       
    }

	public static NodeTree insert(NodeTree root, int data) {
        if(root == null) {
            return new NodeTree(data);
        } else {
            NodeTree cur;
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
        NodeTree root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}