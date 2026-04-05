package linked_list;

import java.util.Scanner;

public class DeleteEveryNNodes {
	
	public static class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}
	
	public static Node<Integer>fetchDeleteEveryNNodes(Node<Integer>head,int m,int n){
		if(m==0 || head==null)
			return null;
		if(n==0)
			return head;
			Node<Integer>curr=head;
		while(curr!=null) {
			for(int i=1;i<m&&curr!=null;i++)
				curr=curr.next;
			if(curr==null)
				break;
			Node<Integer>temp=curr.next;
			Node<Integer>prev=null;
			for(int i=0;i<n&&temp!=null;i++) {
				prev=temp;
				temp=temp.next;
			}
			if(prev!=null)
			prev.next=null;
			curr.next=temp;
			curr=temp;
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
		Node<Integer>temp=fetchDeleteEveryNNodes(head,2,3);
		while(temp!=null) {
			System.out.print(temp.data+"------>");
			temp=temp.next;
		}
	}

}
