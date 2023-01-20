//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    static int k = 0;
    Node buildTree(int inorder[], int postorder[], int n) {
        if(n == 0)
            return null;
        
        if(n == 1)
            return new Node(inorder[0]);
        k = n; // It is used to reset k value each time. while runnlig test cases gfg/leetcode create one object and call it for each test cases.
               // As it is static variable so this variable value will be same for a particular object.
               // If we won't make it 0 then it may through an error (ArrayIndexOutOfBound).
        return buildtree(inorder, 0, n, postorder);
    }
    
    private static Node buildtree(int inorder[], int i, int j, int preorder[]){
        if(i == j)
            return null;
        if(i+1 == j){
            k--;
            return new Node(inorder[i]);
        }
        
        int x = preorder[--k];
        Node l = null;
        Node r = null;
        
        for(int m=i; m<j; m++){
            if(inorder[m] == x){
                r = buildtree(inorder, m+1, j, preorder);
                l = buildtree(inorder, i, m, preorder);
                break;
            }
        }
        Node root = new Node(x);
        
        root.left = l;
        root.right = r;
        
        return root;
    }
}