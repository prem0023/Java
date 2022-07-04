// Remove duplicate from unsorted Linked List

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
         if(head == null || head.next == null)
            return head;
        
         LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
         Node curr = head;
         
         while(curr != null){
             hs.add(curr.data);
             curr = curr.next;
         }
         
         Iterator it = hs.iterator();
         curr = head;
         int a = (int)it.next();
         curr.data = a;
         while(it.hasNext()){
             a = (int)it.next();
             curr = curr.next;
             curr.data = a;
         }
         curr.next = null;
         return head;
         
    }
}

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
         ArrayList<Integer> al = new ArrayList<Integer>();
         Node curr = head;
         Node prev = null;
         
         while(curr != null){
             if(al.contains(curr.data)){
                 prev.next =curr.next;
                 curr = curr.next;
                 continue;
             }
            al.add(curr.data);
            prev = curr;
            curr = curr.next;
         }
         return head;
    }
}



class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public static Node removeDuplicates(Node head) 
    {
         // Your code here
         if(head == null || head.next == null)
            return head;
            
         ArrayList<Integer> al = new ArrayList<Integer>();
         Node curr = head;
         Node prev = null;
         
         while(curr.next != null){
             if(al.contains(curr.data)){
                 int a = curr.data;
                 curr = curr.next;
                 while(curr.data == a){
                     curr = curr.next;
                     if(curr == null) {
                        prev.next = curr;
                        return head;
                     }
                 }
                 prev.next =curr;
                 continue;
             }
            al.add(curr.data);
            prev = curr;
            curr = curr.next;
         }
         if(al.contains(curr.data))
        	 prev.next = null;
  
         return head;
    }
}
