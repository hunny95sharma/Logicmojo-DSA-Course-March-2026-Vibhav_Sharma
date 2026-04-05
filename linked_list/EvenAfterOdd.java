package linked_list;

import java.util.Scanner;

public class EvenAfterOdd {
	
	public static class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}
	
	
	
	public static Node<Integer>fetchEvenAfterOddBasisValue(Node<Integer>head) {
		if(head==null || head.next==null)
			return head;
		Node<Integer>oddHead=null;
		Node<Integer>evenHead=null;
		Node<Integer>oddTail=null;
		Node<Integer>evenTail=null;
		while(head!=null) {
			int data=head.data;
			if(data%2==0) {
				if(evenHead==null) {
					evenHead=head;
					evenTail=head;
				}else {
					evenTail.next=head;
					evenTail=head;
				}
			}else {
				if(oddHead==null) {
					oddHead=head;
					oddTail=head;
				}else {
					oddTail.next=head;
					oddTail=head;
				}
			}
			head=head.next;
		}
		if(oddTail!=null)
			oddTail.next=evenHead;
		if(evenTail!=null)
			evenTail.next=null;
		if(oddHead!=null)
		return oddHead;
		else
		return  evenHead;
				
	}

	public static Node<Integer> takeInputRecursively() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the node value");
		int x=sc.nextInt();
		if(x==-1) {
			sc.close();
			return null;
		}
		Node<Integer>head=new Node<>(x);
		head.next=takeInputRecursively();
		sc.close();
		return head;
	}

	public static void main(String[] args) {

	   Node<Integer>head=takeInputRecursively();
		Node<Integer>temp=fetchEvenAfterOddBasisValue(head);
		while(temp!=null) {
			System.out.print(temp.data+"------>");
			temp=temp.next;
		}
	}

}
