package link_list;

public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result=new ListNode(-1);
		ListNode tail=result;
		int carry=0;
		while(l1!=null && l2!=null) {

			int data=l1.val+l2.val+carry;
			carry=data/10;
			data=data%10;
			ListNode newNode=new ListNode(data);

			tail.next=newNode;
			tail=newNode;
			l1=l1.next;
			l2=l2.next;
		}
		while(l1!=null) {

			int data=l1.val+carry;
			carry=data/10;
			data=data%10;
			ListNode newNode=new ListNode(data);

			tail.next=newNode;
			tail=newNode;
			l1=l1.next;
		}
		while(l2!=null) {

			int data=l2.val+carry;
			carry=data/10;
			data=data%10;
			ListNode newNode=new ListNode(data);

			tail.next=newNode;
			tail=newNode;
			l2=l2.next;
		}
		if(carry==1) {
			ListNode newNode=new ListNode(carry);

			tail.next=newNode;
			tail=newNode;
		}

		return result.next;
	}

}