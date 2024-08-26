/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        if(root == null)
            return new ArrayList();
        
        List<Integer> postOrder = new ArrayList();
        
        getPostOrder(root, postOrder);
        
        return postOrder;
    }
    
    private void getPostOrder(Node root,  List<Integer> postOrder){
        if(root == null)
            return;
        
        for(Node node : root.children){
            getPostOrder(node, postOrder);
        }
        
        postOrder.add(root.val);
    }
}