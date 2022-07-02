// Reverse Linked List in groups of size k

import java.util.*;

class Node {
	int data;
	Node next;

	Node(int key) {
		data = key;
		next = null;
	}
}

class Reverse_LL_Group {
	static Node head;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a1 = sc.nextInt();
		Node head = new Node(a1);
		Node tail = head;
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			tail.next = new Node(a);
			tail = tail.next;
		}
		int k = sc.nextInt();
		Node res = Solution1.reverse(head, k);

		while(res !=  null) {
			System.out.println(res.data);
			res = res.next;
		}
		
		sc.close();
	}

}

class Solution1 {
	public static Node reverse(Node node, int k) {
		if(node == null || node.next == null)
			return node;
		
		Node prev = null;
		Node nextt = null;
		Node curr = node;
		Node t1 = node;
		int c = k;
		
		while(curr != null && c>0) {
			nextt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextt;
			c--;
			
		}
		Node h = reverse(curr, k);
		t1.next = h;
		return prev;
		
	}
}

/*
class Solution1 {
	public static Node reverse(Node node, int k) {
		Node curr = node;
		Node prev = null;
		Node nextt = null;
		Node head = null;
		Node t1 = curr;
		int c = 1;
		Node t2 = null;
		
		while(curr != null) {
			if(c == k+1) {
				head = prev;
			}
			if(c%k == 1) {
				t2 = curr;
				nextt = curr.next;
				prev = curr;
				curr = nextt;
				t2.next = null;
			}
			else if(c%k == 0) {
				if(c==k) {
					nextt = curr.next;
					curr.next = prev;
					prev = curr;
					curr = nextt;
					c++;
					continue;
				}
				nextt = curr.next;
				curr.next = prev;
				prev = curr;
				t1.next = prev;
				curr = nextt;
				t1 = t2;
			}
			else {
				nextt = curr.next;
				curr.next = prev;
				prev = curr;
				curr = nextt;
			}
			c++;
		}
		c--;
		if(c%k != 0) {
			t1.next = prev;
		}
		return head;
	}
}
*/
