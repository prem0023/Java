// Code Link : https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1

// Method - 1 (bEST)

class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        
        helper(root1, st1);
        helper(root2, st2);
        
        while(!st1.isEmpty() && !st2.isEmpty()){
            Node temp1 = st1.peek();
            Node temp2 = st2.peek();
            
            if(temp1.data < temp2.data){
                st1.pop();
                ans.add(temp1.data);
                helper(temp1.right, st1);
            }
            else{
                st2.pop();
                ans.add(temp2.data);
                helper(temp2.right, st2);
            }
        }
        if(!st1.isEmpty()) {
        	Node temp = st1.pop();
        	ans.add(temp.data);
        	st1.push(temp.right);
        	inorder(st1, ans);
        }
        if(!st2.isEmpty()) {
        	Node temp = st2.pop();
        	ans.add(temp.data);
        	st2.push(temp.right);
        	inorder(st2, ans);
        }
        
        return ans;
    }
    
    private void inorder(Stack<Node> st, List<Integer> ans){
        if(st.isEmpty())
            return;
        Node temp = st.pop();
        while(temp != null || !st.isEmpty()){
            while(temp != null){
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            ans.add(temp.data);
            temp = temp.right;
        }
    }
    
    private void helper(Node root, Stack<Node> st){
        if(root == null)
            return;
        
        Node temp = root;
        
        while(temp != null){
            st.push(temp);
            temp = temp.left;
        }
    }
}



//mETHOD - 2
/*

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
*/

// Method - 3
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


//Method - 4
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
