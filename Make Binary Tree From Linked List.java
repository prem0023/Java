// Problem Link : https://practice.geeksforgeeks.org/problems/make-binary-tree/1

/*class Tree{
int data;
    Tree left;
    Tree right;
    Tree(int d){
        data=d;
        left=null;
        right=null;
    }
}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/


class GfG 
{
    //Function to make binary tree from linked list.
    public static Tree convert(Node head, Tree node) {
        // add code here.}
        Node temp = head.next;
        node = new Tree(head.data);
        Tree tree = node;
        
        Queue<Tree> q = new LinkedList<>();
        q.offer(tree);
        
        while(temp != null){
            tree = q.poll();
            tree.left = new Tree(temp.data);
            q.offer(tree.left);
            temp = temp.next;
            
            if(temp != null){
                tree.right = new Tree(temp.data);
                q.offer(tree.right);
            }
            else
                break;
            
            temp = temp.next;
        }
        return node;
    }
}  
