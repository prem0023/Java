// Code Link : https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1

// Method - 1

class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root1);
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            Node node = insert(root2, temp.data);
            
            if(temp.left != null)
                q.offer(temp.left);
            if(temp.right != null)
                q.offer(temp.right);
        }
        inorder(root2, ans);
        
        return ans;
    }
    
    private Node insert(Node root, int key) {
        if(root == null)
            return new Node(key);
        
        Node temp = null;
        if(key < root.data){
            temp =  insert(root.left, key);
            root.left = temp;
        }
        else{
            temp =  insert(root.right, key);
            root.right = temp;
        }
        
        return root;
    }
    
    private void inorder(Node root, List<Integer> ans){
        if(root == null)
            return;
        
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
}


// Method - 2
/*
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        inorder(root1, ans1);
        inorder(root2, ans2);
        
        mergeList(ans1, ans2, ans);
        
        return ans;
    }
    
    private void mergeList(List<Integer> ans1, List<Integer> ans2, List<Integer> ans){
        int n = ans1.size();
        int m = ans2.size();
        
        int i = 0, j = 0;
        
        while(i<n && j<m){
            if(ans1.get(i) > ans2.get(j))
                ans.add(ans2.get(j++));
            else
                ans.add(ans1.get(i++));
        }
        
        while(i<n)
            ans.add(ans1.get(i++));
        while(j<m)
            ans.add(ans2.get(j++));
    }
    
    private void inorder(Node root, List<Integer> ans){
        if(root == null)
            return;
        
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
}
*/


//Method - 3
/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
/*
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node r1 = root1; Node r2 = root2;
        helper(r1,s1);
        helper(r2,s2);
        Node curr = null;
        while(!s1.isEmpty() && !s2.isEmpty()){
             if(s1.peek().data<s2.peek().data){
                curr = s1.pop();
                ans.add(curr.data);
                if(curr.right!=null){
                    helper(curr.right,s1);
                }
            }else if(s1.peek().data>s2.peek().data){
               curr = s2.pop();
                ans.add(curr.data);
                if(curr.right!=null){
                    helper(curr.right,s2);
                }
            }else{
                curr=s1.pop();
                ans.add(curr.data);
                if(curr.right!=null){
                    helper(curr.right,s1);
                }
                curr=s2.pop();
                ans.add(curr.data);
                if(curr.right!=null){
                    helper(curr.right,s2);
                }
            }
        }
        
        curr = null;
        while(!s1.isEmpty()){
            curr=s1.pop();
            ans.add(curr.data);
            if(curr.right!=null) helper(curr.right,s1);
            
        }
        while(!s2.isEmpty()){
            curr=s2.pop();
            ans.add(curr.data);
            if(curr.right!=null) helper(curr.right,s2);
            
        }
        return ans;
    }
    
    public void helper(Node root,Stack<Node> st){
        Node curr = root;
        while(curr!=null){
            st.push(curr);
            curr=curr.left;
        }
    }
}
*/
