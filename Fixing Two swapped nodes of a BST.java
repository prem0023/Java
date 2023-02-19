// Problem Link - https://practice.geeksforgeeks.org/problems/6c4053871794c5e7a0817d7eaf88d71c4bb4c2bc/1

class Solution{
    public Node correctBST(Node root){
        Node first = null;
        Node second = null;
        Node prev = null;
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                if(prev != null && prev.data > curr.data){
                    if(first == null){
                        first = prev;
                        second = curr;
                    }else{
                        second = curr;
                    }
                }
                prev = curr;
                curr = curr.right;
            }else{
                Node temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = curr;
                    curr = curr.left;
                }else{
                    temp.right = null;
                    if(prev != null && prev.data > curr.data){
                        if(first == null){
                            first = prev;
                            second = curr;
                        }else{
                            second = curr;
                        }
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        return root;
    }
}
