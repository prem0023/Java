/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root) {
       ArrayList<Integer> list = new ArrayList<>();
       inorder(root, list, true);
       list.sort(null);
    //   Collections.sort(list);
       inorder(root, list, false);
       return root;
    }
    int pos=0;

    private void inorder(Node root, ArrayList<Integer> list, boolean add) {
        if(root != null) {
            inorder(root.left, list, add);
            if(add) {
                list.add(root.data);
            } else {
                root.data = list.get(pos++);
            }
            inorder(root.right, list, add);
        }
    }
}
 
