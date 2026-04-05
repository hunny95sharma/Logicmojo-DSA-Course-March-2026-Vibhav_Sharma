package linked_list;

import java.util.Scanner;
import java.util.Stack;

public class PrintReverseLinkedList {
	
	public static class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}
	
	public static void fetchPrintReverseLinkedListRecursive(Node<Integer>head) {
		if(head==null)
			return;
		fetchPrintReverseLinkedListRecursive(head.next);
		System.out.print(head.data);
	}
	
	public static void fetchPrintReverseLinkedListWithStack(Node<Integer>head) {
		if(head==null)
			return;
		Node<Integer>temp=head;
		Stack<Node<Integer>>st=new Stack<>();
		while(temp!=null) {
			st.push(temp);
			temp=temp.next;
		}
		while(!st.empty()) {
			System.out.println(st.pop().data+" ");
		}
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
		fetchPrintReverseLinkedListRecursive(head);
		
	}

}
