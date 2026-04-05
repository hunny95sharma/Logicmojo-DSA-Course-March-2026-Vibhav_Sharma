package linked_list;

import java.util.Scanner;

public class MergeSort {
	
	public static class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}
	
	public static Node<Integer> fetchMergeSort(Node<Integer> head){
		if(head==null || head.next==null)
			return head;

		Node<Integer> fast=head;
		Node<Integer>slow=head;
		Node<Integer>prev=null;
		while(fast!=null&&fast.next!=null) {
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		prev.next=null;
		head=fetchMergeSort(head);
		slow=fetchMergeSort(slow);
		head=merge(head,slow);
		return head;
	}

	private static Node<Integer> merge(Node<Integer> head, Node<Integer> next) {
		Node<Integer>temp1=head;
		Node<Integer>temp2=next;
		Node<Integer>headNode=null;
		Node<Integer>tailNode=null;
		while(temp1!=null&&temp2!=null) {
			if(temp1.data>temp2.data) {
				if(headNode==null) {
					headNode=temp2;
					tailNode=temp2;
				}else {
					tailNode.next=temp2;
					tailNode=temp2;
				}
				temp2=temp2.next;
			}else {
				if(headNode==null) {
					headNode=temp1;
					tailNode=temp1;
				}else {
					tailNode.next=temp1;
					tailNode=temp1;
				}
				temp1=temp1.next;
			}
		}
		if(temp1!=null) {
			tailNode.next=temp1;
		}
		if(temp2!=null) {
			tailNode.next=temp2;
		}
		return headNode;
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
		Node<Integer>temp=fetchMergeSort(head);
		while(temp!=null) {
			System.out.print(temp.data+"------>");
			temp=temp.next;
		}
	}

}
