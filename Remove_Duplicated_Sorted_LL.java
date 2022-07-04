// Remove duplicate from sorted Linked List

class Remove_Duplicated_LL
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
        if(head == null || head.next == null)
            return head;
        
        Node curr = head;
        
        while(curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return head;
    }
}
