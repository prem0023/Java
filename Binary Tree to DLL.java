//Problem Link : https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root){
        if(root == null)
            return null;
        
        Node l = bToDLL(root.left);
        Node r = bToDLL(root.right);
        
        root.right = r;
        if(r != null)
            r.left = root;
        if(l == null)
            return root;
        
        Node temp = l;
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = root;
        root.left = temp;
        
        return l;
    }
}

/*
//Method - 2
/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        
        inOrder(root, list);
        
        Node node = new Node(list.get(0));
        Node prev = null;
        Node temp = node;
        int n = list.size();
        
        for(int i=1; i<n; i++){
            temp.left = prev;
            prev = temp;
            Node t = new Node(list.get(i));
            temp.right = t;
            temp = temp.right;
        }
        temp.left = prev;
        
        return node;
    }
    
    private void inOrder(Node root, ArrayList<Integer> list){
        if(root == null)
            return;
        
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
        
    }
}

*/
