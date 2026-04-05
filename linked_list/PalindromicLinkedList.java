package linked_list;

import java.util.Stack;

public class PalindromicLinkedList {
	
	public static class ListNode {
		     int val;
		     ListNode next;
		     ListNode() {}
		     ListNode(int val) { this.val = val; }
		     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	
	public static ListNode reverseLinkedList(ListNode head) {
	
		ListNode prev=null;
		ListNode curr=head;
		while(curr!=null) {
			ListNode next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	
	public static boolean isPalindromicLinkedList(ListNode head1,ListNode head2) {
	
		head1=reverseLinkedList(head1);
		while(head1!=null&& head2!=null) {
			if(head1.val!=head2.val)
				return false;
			head1=head1.next;
			head2=head2.next;
		}
		return true;
	}
	
	public static boolean isPalindromicLinkedListUsingStack(ListNode head) {
		
		Stack<ListNode>st=new Stack<>();
		ListNode temp=head;
		while(temp!=null) {
			st.push(temp);
			temp=temp.next;
		}
		temp=head;
		while(temp!=null) {
			ListNode ref=st.pop();
			if(temp.val!=ref.val)
				return false;
			temp=temp.next;
		}
		return true;
	}
	
	public static boolean isPalindromicLinkedListOptimized(ListNode head) {
         ListNode slow=head;
         ListNode fast=head;
         boolean ans=true;
         while(fast.next!=null&&fast.next.next!=null) {
        	 slow=slow.next;
        	 fast=fast.next.next;
         }
         ListNode newHead=reverseLinkedList(slow.next);
         ListNode first=head;
         ListNode second=newHead;
         while(first!=null&&second!=null) {
        	 if(first.val!=second.val) {
        		 ans= false;
        		 break;
        	 }
        	 first=first.next;
        	 second=second.next;
         }
         reverseLinkedList(newHead);
         return ans;
	}

	public static void main(String[] args) {
		ListNode newNode=new ListNode(1);
		newNode.next=new ListNode(2);
		newNode.next.next=new ListNode(2);
		newNode.next.next.next=new ListNode(1);
		System.out.print(isPalindromicLinkedListOptimized(newNode));
	}

}
