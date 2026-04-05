package linked_list;

import java.util.Scanner;

public class EliminateDuplicates {
	
	public static class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}
	
	public static Node<Integer> fetchEliminateDuplicates(Node<Integer> head){
		if(head==null || head.next==null)
			return head;
		Node<Integer>temp=head;
		Node<Integer>list=head;
		while(temp!=null) {
			if(temp.data!=list.data) {
				list.next=temp;
				list=list.next;
			}
			temp=temp.next;
		}
		list.next=null;
		return head;
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
		Node<Integer>temp=fetchEliminateDuplicates(head);
		while(temp!=null) {
			System.out.print(temp.data+"------>");
			temp=temp.next;
		}
	}

}
