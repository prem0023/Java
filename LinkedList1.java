import java.util.Scanner;
	
class Node
{
	private int data;
	private Node next;
		
	public Node(){	
	}
		
	public Node(int d, Node n) {
		data = d;
		next = n;
	}
		
	void setData(int d) {
		data = d;
	}
		
	void setNext(Node n) {
		next = n;
	}
		
	int getData() {
		return data;
	}
		
	Node getNext() {
		return next;
	}
				
}
	
	
class LinkedList
{
	private int size;
	private Node start;
		
	public LinkedList(){
		size = 0;
		start = null;
	}
		
	public boolean isEmpty(){
		if(start == null) {
			return true;
		}
		else {
			return false;
		}
	}
		
	public int ListSize() {
		return size;
	}
		
	public void insertAtFirst(int val) {
		Node n = new Node();
		n.setData(val);
		n.setNext(start);
		start = n;
		size++;					
	}
		
	public void insertAtLast(int val) {
		Node n = new Node();
		n.setData(val);
		Node t;
		t = start;
		if(t== null) {
			start = n;
		}
		else {
			while(t.getNext() != null) {
				t = t.getNext();
			}
			t.setNext(n);
		}
		size++;
	}
	
		
	public void insertAtPos(int val, int pos) {
		if(pos<1 || pos>size) {
			System.out.println("Invalid Position");
		}
		else if(pos ==1) {
			insertAtFirst(val);
			size++;
		}
		else if(pos == size) {
			insertAtLast(val);
			size++;
		}
		else {
			Node n = new Node();
			Node t = start;
			for(int i=1;i<pos-1;i++) {
				t = t.getNext();
			}
			n.setNext(t.getNext());
			t.setNext(n);
			n.setData(val);
			size++;
		}
	}
		
	public void deleteAtFirst() {
		if(start == null) {
			System.out.println("List is already Empty");
		}
		else {
			start = start.getNext();
			size--;
		}
	}
		
	public void deleteAtLast() {
		if(start == null) {
			System.out.println("List is already Empty");
		}
		else if(size == 1) {
			start = null;
			size--;
		}
		else {
			Node t = start;
			for(int i=1;i<size-1;i++) {
				t = t.getNext();
			}
			t.setNext(null);
			size--;
		}
	}
		
	public void deleteAtPos(int pos) {
		if(pos<1 || pos>size) {
			System.out.println("Invalid Position");
		}
		else if(pos == 1){
			deleteAtFirst();
			size--;
		}
		else if(pos == size) {
			deleteAtLast();
			size--;
		}
		else {
			Node t = start;
			Node t1;
			for(int i=1;i<pos-1;i++) {
				t = t.getNext();
			}
			t1 = t.getNext();
			t.setNext(t1.getNext());
			size--;
		}
	}
		
	public void viewList() {
		Node t;
		if(isEmpty()) {
			System.out.println("List is Empty!!");
		}
		else {
			t = start;
			for(int i=0;i<size;i++) {
				System.out.println(" "+t.getData());
				t = t.getNext();
			}
		}
	}
		
}
public class LinkedList1 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		boolean flag = true;
		while(flag) {
			System.out.println("ENTER YOUR CHOICE");
			System.out.println("1.Insert Element in the List at First");
			System.out.println("2.Insert Element in the List at Last");
			System.out.println("3.Insert Element in the List at Your given Position");
			System.out.println("4.Delete Element in the List at First");
			System.out.println("5.Delete Element in the List at Last");
			System.out.println("6.Delete Element in the List at Your given Position");
			System.out.println("7.View the List");
			System.out.println("8.Exit");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the Element");
				int n = sc.nextInt();
				list.insertAtFirst(n);
				break;
			case 2:
				System.out.println("Enter the Element");
				int val = sc.nextInt();
				list.insertAtLast(val);
				break;
			case 3:
				System.out.println("Enter the Value:");
				int v = sc.nextInt();
				System.out.println("Enter the Position");
				int p = sc.nextInt();
				list.insertAtPos(v, p);
				break;
			case 4:
				list.deleteAtFirst();
				break;
			case 5:
				list.deleteAtLast();
				break;
			case 6:
				System.out.println("Enter the Position: ");
				int p1 = sc.nextInt();
				list.deleteAtPos(p1);
				break;
			case 7:
				list.viewList();
				break;
			case 8:
				flag = false;
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
		sc.close();
	}
}