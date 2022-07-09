// Delete Last Node of Linked List using Recursion

class Solution {
	static void deleteLastNode(Node head) {
		
		if(head.next.next == null) {
			head.next = null;
			return;
		}
		
		deleteLastNode(head.next);
	}
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	Node head = new Node(0);
    	Node temp = head;
    	int n = sc.nextInt();
    	for(int i=0;i<n;i++) {
    		temp.next = new Node(sc.nextInt());
    		temp = temp.next;
    	}
    	
    	deleteLastNode(head);
		temp = head;
    	
    	while(temp != null) {
    		System.out.print(temp.data + " ");
    		temp = temp.next;
    	}
	}
}

/*
// Method 2

static Node deleteLastNode(Node head) {
		
		if(head.next.next == null) {
			head.next = null;
			return head;
		}
		
		Node temp = deleteLastNode(head.next);
		return head;
		
	}
	
*/
		