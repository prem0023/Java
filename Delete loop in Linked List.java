// Delete loop in Linked List

class Solution {
    public static void removeLoop(Node head){
        Node slow=head;
        Node fast=head;
        
        while(slow!=null&& fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow==head){
            while(slow.next!=head){
                slow=slow.next;
            }
            slow.next=null;
            
        }
        else if(slow==fast){
            slow=head;
            while(slow.next!=fast.next){
                slow=slow.next;
                fast=fast.next;
            }
            fast.next=null;
        }
    }
}

