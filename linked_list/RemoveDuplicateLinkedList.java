package linked_list;

public class RemoveDuplicateLinkedList {
	
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val=val;
		}
	}
	
	public static ListNode fetchRemoveDuplicateLinkedList(ListNode head) {
		
		ListNode prev=head;
	      if(head ==null)
	      return head;
			ListNode current=head.next;
			while(current!=null) {
				if(prev.val==current.val) {
					prev.next=current.next;
					current=current.next;
				}else {
					prev=current;
					current=current.next;
				}
		}	
			return head;
		
	}

}
