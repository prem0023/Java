//Add 1 to a number represented as linked list

class Solution
{
   public static Node addOne(Node head) 
   { 
       //code here.
       Node curr = head;
       Node prev = null;
       
       while(curr.next != null){
           if(curr.next.data == 9 && curr.data != 9)
               prev = curr;
           curr = curr.next;
       }
       if(prev == null && curr.data == 9){
           prev = new Node(1);
           prev.next = head;
           while(head != null){
               head.data = 0;
               head = head.next;
           }
           return prev;
       }
       else if(curr.data == 9){
           prev.data = prev.data + 1;
           prev = prev.next;
           while(prev != null){
               prev.data = 0;
               prev = prev.next;
           }
           return head;
       }
       //System.out.println(curr.data);
       curr.data = curr.data + 1;
       return head;
   }
}