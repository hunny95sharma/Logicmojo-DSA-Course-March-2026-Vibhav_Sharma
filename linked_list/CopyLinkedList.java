package linked_list;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedList {
	
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	
	
	public Node copyRandomListWithOutExtraMemory(Node head) {
		Node temp=head;
		Node newNode=null;
		while(temp!=null) {
			newNode=new Node(temp.val);
			newNode.next=temp.next;
			temp.next=newNode;
			temp=temp.next.next;
		}
		temp=head;
		while(temp!=null) {
			if(temp.random!=null)
			temp.next.random=temp.random.next;
			temp=temp.next.next;
		}
		temp=head;
		Node dummy=new Node(-1);
		newNode=dummy;
		while(temp !=null) {
			newNode.next=temp.next;
			newNode=newNode.next;
			temp.next=temp.next.next;
			temp=temp.next;
		}
		return dummy.next;         
	}

	public Node copyRandomListExtraMemory(Node head) {
           Node temp=head;
           Map<Node,Node>map=new HashMap<>();
           Node ref=null;
           while(temp !=null) {
        	   ref=new Node(temp.val);
        	   map.put(temp,ref);
        	   temp=temp.next;
           }
           
           temp=head;
           Node dummy=new Node(-1);
           dummy.next=map.get(temp);
           while(temp!=null) {
        	   map.get(temp).next=map.get(temp.next);
        	   map.get(temp).random=map.get(temp.random);
        	   temp=temp.next;
           }
           return dummy.next;
	}
}