package linked_list;

public class ReverseLinkedList {
	
	public class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data=data;
		}
	}
	
	public static class DoubleNode{
		ListNode head;
		ListNode tail;
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
	
	public static ListNode reverseLinkedListRecursive1(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode reverse=reverseLinkedListRecursive1(head.next);
		ListNode temp=reverse;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
		head.next=null;
		return reverse;
	}
	
	public static DoubleNode reverseLinkedListRecursive2(ListNode head) {
		if(head==null || head.next==null)
		{
			DoubleNode res=new DoubleNode();
			res.head=head;
			res.tail=head;
			return res;
		}
		DoubleNode reverse=reverseLinkedListRecursive2(head.next);
		reverse.tail.next=head;
		head.next=null;
		DoubleNode ans=new DoubleNode();
		ans.head=reverse.head;
		ans.tail=head;
		return ans;
	}
	
	public static ListNode reverseLinkedListRecursive3(ListNode head) {
		if(head==null || head.next==null)
		{
			return head;
		}
		ListNode tail=head.next;
		ListNode reverse=reverseLinkedListRecursive3(head.next);
		tail.next=head;
		head.next=null;
		return reverse;
	}
}