// Detect Loop in linked list

class Detect_Loop_LL {
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}

/*
public static boolean detectLoop(Node head){
        ArrayList al = new ArrayList();
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
	
	
public static boolean detectLoop(Node head){
        ArrayList al = new ArrayList();
        Node curr = head;
        
        while(curr.next != null){
            if(al.contains(curr))
                return true;
            al.add(curr);
            curr = curr.next;
        }
        return false;
    }
	
*/