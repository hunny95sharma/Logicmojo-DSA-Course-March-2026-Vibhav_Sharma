package linked_list;

public class RemoveLinkedListElement {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode fetchRemoveLinkedListElement(ListNode head,int val) {
		if(head==null)
			return head;
		if(head.next==null) {
			if(head.val==val)
				return null;
			else
				return head;
		}
		ListNode dummy=new ListNode(-1);
		dummy.next=head;
		ListNode prevNode=dummy;
		ListNode curr=head;
		while(curr!=null) {
			if(curr.val==val) {
				ListNode nextNode=curr.next;
				prevNode.next=nextNode;
				curr.next=null;
				curr=nextNode;
			}else {
				prevNode=curr;
				curr=curr.next;
			}
		}
		return dummy.next;
	}
}