class Solution{
    public void inOrder(Node root,ArrayList<Node> list){
        if(root==null)
            return;
        
        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);
    }
    public void populateNext(Node root){
        
        ArrayList<Node> list = new ArrayList<>();
        inOrder(root,list);
        for(int i=0;i<list.size()-1;i++){
            Node curr = list.get(i);
            Node next = list.get(i+1);
            curr.next = next;
        }
    }
}

//Link : https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
