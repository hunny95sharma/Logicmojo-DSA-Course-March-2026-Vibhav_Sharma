package linked_list;

public class AddOneNumberRepresentedLinkedList {
	
	public static class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static Node fetchAddOneNumberRepresentedLinkedListIterative(Node head) {
		if(head==null)
		return null;
		head=reverseLinkedList(head);
		    Node temp=head;
		    int carry=1;
		    while(temp!=null) {
		    	temp.val=carry+temp.val;
		    	if(temp.val<10) {
		    		carry=0;
		    		break;
		    	}else {
		    		temp.val=0;
		    		carry=1;
		    	}
		    	temp=temp.next;
		    }
		    if(carry==1) {
		    	Node newNode=new Node(carry);
		    	head=reverseLinkedList(head);
		    	newNode.next=head;
		    	return newNode;
		    }
		    head=reverseLinkedList(head);
		    	return head;
	}
	
	public static int fetchAddOneNumberRepresentedLinkedListRecursive(Node head) {
		if(head==null)
			return 1;
		int carry=fetchAddOneNumberRepresentedLinkedListRecursive(head.next);
			head.val=head.val+carry;
			if(head.val>=10) {
				head.val=0;
				return 1;
			}
			return 0;
	}
	
	
	public static Node reverseLinkedList(Node head) {

         Node prev=null;
         Node curr=head;
         while(curr!=null) {
        	 Node next=curr.next;
        	 curr.next=prev;
        	 prev=curr;
        	 curr=next;
         }
             return prev;
	}
	
	public static void main(String[] args) {
		Node newNode=new Node(1);
		newNode.next=new Node(9);
		newNode.next.next=new Node(9);
		newNode.next.next.next=new Node(9);
		
		int carry=fetchAddOneNumberRepresentedLinkedListRecursive(newNode);
		if(carry==1)
		{
			Node temp=new Node(carry);
			temp.next=newNode;
			newNode=temp;
		}
		while(newNode!=null) {
			System.out.print(newNode.val+"-->");
			newNode=newNode.next;
		}
		
		
		

	}

}