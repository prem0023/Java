import java.io.*;
import java.util.*;

public class CycleDetection {

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
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
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

    
    static boolean hasCycle(SinglyLinkedListNode head) {
        
        SinglyLinkedListNode t = head;
        SinglyLinkedListNode t1; 
        ArrayList<Integer> l = new ArrayList<Integer>();
        ArrayList k = new ArrayList();
        
        while(t != null){
        	System.out.println(t);
        	k.add(t);
            if(k.contains(t)){
            	t1 = t.next;
               if(k.contains(t1))
            	   return true;
            }
            t = t.next;
        }
        return false;

    }
    static boolean check(ArrayList l, SinglyLinkedListNode t, int x) {
    	SinglyLinkedListNode m = t;
    	ArrayList<Integer> l1 = new ArrayList<Integer>();
    	l1.add(m.data);
    	m = m.next;
    	
    	while(m.data != x) {
    		l1.add(m.data);
    	}
    	if(l.contains(l1))
    		return true;
    	else
    		return false;
    	   	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        int tests = scanner.nextInt();

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();

                llist.insertNode(llistItem);
            }
          
          	SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
          	//System.out.println(extra.data);
            SinglyLinkedListNode temp = llist.head;

            for (int i = 0; i < llistCount; i++) {
                if (i == index) {
                    extra = temp;
                }

                if (i != llistCount-1) {
                    temp = temp.next;
                }
            }
      
      		temp.next = extra;

            boolean result = hasCycle(llist.head);

            System.out.println(String.valueOf(result ? 1 : 0));
           
        }

        scanner.close();
    }
}
