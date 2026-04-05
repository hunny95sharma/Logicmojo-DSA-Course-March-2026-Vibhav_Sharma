package linked_list;

public class RemoveNthNodeFromEnd {
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public static ListNode findRemoveNthNodeFromEndWorst(ListNode head,int n) {
		
		int length=0;
		ListNode temp=head;
		while(temp!=null) {
			length++;
			temp=temp.next;
		}
		int rem=length-n;
		if(rem==0) {
			head=head.next;
			return head;
		}
		temp=head;
		while(rem>1&&temp!=null) {
			temp=temp.next;
			rem--;
		}
		temp.next=temp.next.next;
		return head;
	}
	
public static ListNode findRemoveNthNodeFromEndOptimized(ListNode head,int n) {
	     ListNode fast=head;
	     for(int i=0;i<n;i++) {
	    	 fast=fast.next;
	     }
	     if(fast==null)
	    	 return head.next;
	     ListNode slow=head;
	     while(fast.next!=null) {
	    	 slow=slow.next;
	    	 fast=fast.next;
	     }
	   slow.next=slow.next.next;
	   return head;
		
	}
	
public static void main(String[] args) {
		
		ListNode newNode=new ListNode(1);
		newNode.next=new ListNode(2);
		
		ListNode temp=findRemoveNthNodeFromEndWorst(newNode,1);
		while(temp!=null) {
			System.out.print("------->"+temp.val);
			temp=temp.next;
		}	
	}

}
