// Link : https: practice.geeksforgeeks.org/problems/construct-tree-1/1
// Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/

class Solution
{
    static int k = 0;
    public static Node buildTree(int inorder[], int preorder[], int n){
        if(n == 0)
            return null;
        
        if(n == 1)
            return new Node(inorder[0]);
        k = 0; // It is used to reset k value each time. while runnlig test cases gfg/leetcode create one object and call it for each test cases.
               // As it is static variable so this variable value will be same for a particular object.
               // If we won't make it 0 then it may through an error (ArrayIndexOutOfBound).
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
