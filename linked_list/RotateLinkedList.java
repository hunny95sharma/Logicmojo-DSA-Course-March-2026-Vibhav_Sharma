package linked_list;

public class RotateLinkedList {
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public static ListNode rotateClockWise(ListNode head,int k) {
		ListNode temp=head;
		int length=1;
		while(temp.next!=null) {
			temp=temp.next;
			length++;
		}
		if(k%length==0)
			return head;
		 k=length-(k%length);
		ListNode curr=head;
		while(k>1) {
			k--;
			curr=curr.next;
		}
		ListNode nextNode=curr.next;
		curr.next=null;
		temp.next=head;
		head=nextNode;
		return head;
	}
	
	public static ListNode rotateAntiClockWise(ListNode head,int k) {
		ListNode temp=head;
		int length=1;
		while(temp.next!=null) {
			temp=temp.next;
			length++;
		}
		if(k%length==0)
			return head;
		 k=k%length;
		ListNode prev=head;
		int count=1;
		while(count!=k) {
			prev=prev.next;
			count++;
		}
		ListNode nextNode=prev.next;
		prev.next=null;
		temp.next=head;
		return nextNode;
		
	}

	public static void main(String[] args) {

		ListNode newNode=new ListNode(10);
		newNode.next=new ListNode(20);
		newNode.next.next=new ListNode(30);
		newNode.next.next.next=new ListNode(40);
		newNode.next.next.next.next=new ListNode(50);
		newNode.next.next.next.next.next=new ListNode(60);
		ListNode temp=rotateAntiClockWise(newNode,4);
		while(temp!=null) {
			System.out.print(temp.val+"----------->");
			temp=temp.next;
		}
	}

}
