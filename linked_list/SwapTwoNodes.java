package linked_list;

import java.util.Scanner;

public class SwapTwoNodes {
	
	public static class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}
	
	public static Node<Integer>fetchSwapTwoNodes(Node<Integer>head,int i,int j){
		if(head==null || i==j)
			return head;
		if(i>j) {
			int x=i;
			i=j;
			j=x;
		}
		Node<Integer>iThNode=null;
		Node<Integer>prevIthNode=null;
		Node<Integer>jThNode=null;
		Node<Integer>prevJthNode=null;
		Node<Integer>temp=head;
		Node<Integer>prev=null;
		int count=0;
		while(temp!=null) {
			if(count==i) {
				iThNode=temp;
				prevIthNode=prev;
			}
			if(count==j) {
				jThNode=temp;
				prevJthNode=prev;
			}
			prev=temp;
			temp=temp.next;
			count++;
		}
		// If X is not head
	    if (prevIthNode != null) prevIthNode.next = jThNode;
	    else head = jThNode;
	    prevJthNode.next = iThNode;
	    Node<Integer> nextNode = jThNode.next;
	    jThNode.next = iThNode.next;
	    iThNode.next = nextNode;
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
		Node<Integer>temp=fetchSwapTwoNodes(head,3,4);
		while(temp!=null) {
			System.out.print(temp.data+"------>");
			temp=temp.next;
		}
	}

}