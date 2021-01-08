import java.io.*;
import java.util.*;


public class InsertAtTailLL {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }

      
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static int c = 0;
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    	if(c == 0) {
    		SinglyLinkedListNode n = new SinglyLinkedListNode(data);
    		head = n;
    		c++;
    	}
    	else {
    		SinglyLinkedListNode t = head;
            SinglyLinkedListNode n = new SinglyLinkedListNode(data);
            while(t.next != null){
                t = t.next;
            }
            t.next = n;
    	}
        
        return head;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
        	
          SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

          llist.head = llist_head;
        }



        System.out.println(llist.head);

        scanner.close();
    }
}
