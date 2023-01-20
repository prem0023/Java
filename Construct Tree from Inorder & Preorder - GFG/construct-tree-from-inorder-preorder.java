//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    static int k = 0;
    public static Node buildTree(int inorder[], int preorder[], int n){
        if(n == 0)
            return null;
        
        if(n == 1)
            return new Node(inorder[0]);
        k = 0;
        return buildtree(inorder, 0, n, preorder);
    }
    
    private static Node buildtree(int inorder[], int i, int j, int preorder[]){
        if(i == j)
            return null;
        if(i+1 == j){
            k++;
            return new Node(inorder[i]);
        }
        
        int x = preorder[k++];
        Node l = null;
        Node r = null;
        
        for(int m=i; m<j; m++){
            if(inorder[m] == x){
                l = buildtree(inorder, i, m, preorder);
                r = buildtree(inorder, m+1, j, preorder);
                break;
            }
        }
        Node root = new Node(x);
        
        root.left = l;
        root.right = r;
        
        return root;
    }
}