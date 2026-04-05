package linked_list;

import java.util.Scanner;

public class BubbleSort {
	
	public static class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}
	
	public static Node<Integer> sortUsingBubbleSort(Node<Integer> head) {
	    if (head == null || head.next == null) return head;

	    boolean swapped = true;
	    Node<Integer> end = null;

	    while (swapped) {
	        swapped = false;
	        Node<Integer> curr = head;
	        Node<Integer> prev = null;

	        while (curr.next != end) {
	            if (curr.data > curr.next.data) {
	                swapped = true;

	                Node<Integer> next = curr.next;

	                // swap
	                curr.next = next.next;
	                next.next = curr;

	                if (prev == null) {
	                    head = next;
	                } else {
	                    prev.next = next;
	                }

	                prev = next;
	            } else {
	                prev = curr;
	                curr = curr.next;
	            }
	        }

	        end = curr; // last sorted node
	    }

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
		Node<Integer>temp=sortUsingBubbleSort(head);
		while(temp!=null) {
			System.out.print(temp.data+"------>");
			temp=temp.next;
		}
	}
}
