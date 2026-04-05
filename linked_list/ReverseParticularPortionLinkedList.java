package linked_list;

public class ReverseParticularPortionLinkedList {


	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static ListNode fetchReverseParticularPortionLinkedList(ListNode head,int left,int right) {

		if(head==null || head.next==null || left==right)
			return head;
		int count=1;
		ListNode prevLeft=null;
		ListNode leftNode=null;
		ListNode rightNode=null;
		ListNode temp=head;
		while(temp!=null) {
			if(count==left) {
				leftNode=temp;
			}
			if(count==right) {
				rightNode=temp;
				break;
			}
			if(count<left) {
				prevLeft=temp;
			}
			temp=temp.next;
			count++;

		}
		ListNode nextNode=rightNode.next;
		rightNode.next=null;
		if(prevLeft!=null)
			prevLeft.next=reverseLinkedList(leftNode);
		else
			head=reverseLinkedList(leftNode);
		leftNode.next=nextNode;
		return head;
	}

	public static ListNode fetchReverseParticularPortionLinkedListOnePass(ListNode head,int left,int right) {

		if (head == null || head.next == null || left == right)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode prevNode = dummy;
		ListNode connection = dummy;
		ListNode curr = head;
		ListNode tail=null;
		int pos=1;
		while(curr!=null){
			if(pos<left){
				prevNode=curr;
				curr=curr.next;
			}else if(pos==left){
				connection=prevNode;
				tail=curr;
				ListNode next=curr.next;
				curr.next=prevNode;
				prevNode=curr;
				curr=next;
			}
			else if(pos>left&&pos<=right){
				ListNode next=curr.next;
				curr.next=prevNode;
				prevNode=curr;
				curr=next;
			}else{
				break;
			}
			pos++;
		}
		tail.next=curr;	
		connection.next=prevNode;
		return dummy.next;

	}

	public static ListNode reverseLinkedList(ListNode head) {
		ListNode curr=head;
		ListNode prev=null;
		while(curr!=null) {
			ListNode next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}

}
