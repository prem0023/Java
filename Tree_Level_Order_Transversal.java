//Tree - Level order Transversal

class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
        ArrayList <Integer> al = new ArrayList <Integer>();
        Queue <Node> temp = new LinkedList <Node>();
        
        temp.add(node);
        
        while(!temp.isEmpty()){
            Node t = temp.poll();
            if(t.left != null)
                temp.add(t.left);
            if(t.right != null)
                temp.add(t.right);
            al.add(t.data);
        }
        
        
        return al;
    }
    
}