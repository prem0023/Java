//Reverse Doubly LinkedList

public static Node reverseDLL(Node  head)
{
    Node curr = head;
    Node nextt = null;
    Node pre = null;
    
    while(curr != null){
        nextt = curr.next;
        curr.next = pre;
        curr.prev = nextt;
        pre = curr;
        curr = nextt;
    }
    
    return pre;
}

public static Node reverseDLL(Node  head)
{
    if(head == null || head.next == null)
        return head;
        
    Node curr = head;
    Node nextt = curr.next;
    curr.next = null;
    curr.prev = nextt;
    curr = nextt;
    
    while(curr.next != null){
        nextt = curr.next;
        curr.next = curr.prev;
        curr.prev = nextt;
        curr = nextt;
    }
    curr.next = curr.prev;
    curr.prev = null;
    return curr;
    
}