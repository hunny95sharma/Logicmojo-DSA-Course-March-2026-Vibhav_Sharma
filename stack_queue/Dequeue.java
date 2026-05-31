package stack_queue;

public class Dequeue {

	private static class Node{

		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}

	private Node rear;
	private Node front;
	private int size;
	private int maxCapacity;

	Dequeue(int capacity){
		rear=null;
		front=null;
		size=0;
		maxCapacity=capacity;
	}

	public void insertFront(int element) {

		if(size==maxCapacity) {
			System.out.println("-1");
			return;
		}
		Node newNode=new Node(element);
		newNode.next=front;
		front=newNode;	
		if(rear==null)
			rear=front;
		size++;
	}

	public void insertRear(int element) {

		if(size==maxCapacity) {
			System.out.println("-1");
			return;
		}
		Node newNode=new Node(element);
		if(rear!=null)
			rear.next=newNode;
		rear=newNode;
		if(front==null)
			front=rear;
		size++;
	}

	public void deleteFront() {
		if(size==0) {
			System.out.println("-1");
			return;
		}

		front=front.next;
		size--;
		if(size==0) {
			front=null;
			rear=null;
		}
	}

	public void deleteRear() {
		if(size==0) {
			System.out.println("-1");
			return;
		}

		Node curr=front;
		Node prev=null;
		while(curr!=rear) {
			prev=curr;
			curr=curr.next;
		}
		if(prev!=null) {
			prev.next=null;
		}
		rear=prev;
		size--;
		if(size==0) {
			front=null;
			rear=null;
		}
	}

	public int getFront() {
		if(size==0) {
			return -1;
		}
		return front.data;
	}

	public int getRear() {
		if(size==0) {
			return -1;
		}
		return rear.data;
	}

}