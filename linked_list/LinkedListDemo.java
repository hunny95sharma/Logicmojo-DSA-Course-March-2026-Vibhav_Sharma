package linked_list;

import java.util.Scanner;

public class LinkedListDemo {

	public static class Node<T>{
		T data;
		Node<T>next;
		Node(T data){
			this.data=data;
			next=null;
		}
	}
	public static void print(Node<Integer>head) {
		while(head!=null) {
			System.out.print(head.data+"----->");
			head=head.next;
		}
		System.out.print("Null");
	}

	public static Node<Integer> takeInput() {
		Node<Integer>head=null;
		Node<Integer>tail=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the node value");
		int x=sc.nextInt();
		while(x!=-1) {
			Node<Integer> newNode=new Node<>(x);
			if(head==null) {
				head=newNode;
				tail=newNode;
			}else {
				tail.next=newNode;
				tail=newNode;
			}
			System.out.println("Enter the node value");
			x=sc.nextInt();
		}
		sc.close();
		return head;
	}

	public static Node<Integer> insertAtPos(Node<Integer>head,int pos,int data) {
		Node<Integer>newNode=new Node<>(data);
		if(pos==0) {
			newNode.next=head;
			head=newNode;
			return head;
		}
		Node<Integer>temp=head;
		int count=0;
		while(temp!=null&&count<pos-1) {
			temp=temp.next;
			count++;
		}
		if(temp==null)
			return null;
		newNode.next=temp.next;
		temp.next=newNode;
		return head;
	}

	public static Node<Integer> deleteAtPos(Node<Integer>head,int pos){
		if(head==null)
			return head;
		if(pos==0) {
			head=head.next;
			return head;
		}
		Node<Integer>temp=head;
		int count=0;
		while(temp!=null&&count<pos-1) {
			temp=temp.next;
		count++;	
		}
		if(temp==null)
			return head;
		Node<Integer> nextNode=null;
		if(temp.next!=null)
		nextNode=temp.next.next;
		temp.next=nextNode;
		return head;			
	}
	
	public static Node<Integer> insertAtPosRecursively(Node<Integer>head,int pos,int data) {
		if(head==null)
			return head;
		Node<Integer>newNode=new Node<>(data);
		if(pos==0) {
			newNode.next=head;
			return newNode;
		}
		head.next=insertAtPosRecursively(head.next,pos-1,data);
		return head;
	}
	
	public static void printRecursively(Node<Integer>head) {
		if(head==null) {
			System.out.print("Null");
			return;
		}
		    System.out.print(head.data+"----->");
		    printRecursively(head.next);
	}
	
	public static Node<Integer> deleteAtPosRecursively(Node<Integer>head,int pos){
		if(head==null)
			return head;
		if(pos==0) {
			return head.next;
		}
		head.next=deleteAtPosRecursively(head.next,pos-1);
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
		printRecursively(head);
	}

}