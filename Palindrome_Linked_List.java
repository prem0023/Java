// Check if Linked List is Palindrome

/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        //Your code here
        Node temp = head;
        int n = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        
        if(n<2)
            return true;
        
        temp = head; 
        Node prev = null;
        for(int i=0; i<n/2; i++){
            Node t1 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t1;
        }
        if(n%2 != 0)
            temp = temp.next;
            
        while(temp!= null){
            if(temp.data != prev.data)
                return false;
                
            temp = temp.next;
            prev = prev.next;
        }
        
        return true;
    }   
}

