package linked_list;

public class DeleteLastOccurrenceItemLinkedList {

	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public static ListNode fetchDeleteLastOccurenceItemLinkedList(ListNode head,int item) {
		ListNode itemNode=null;
		ListNode prevItemNode=null;
		ListNode prev=null;
		ListNode temp=head;
		while(temp!=null) {
			if(temp.val==item) {
				itemNode=temp;
				prevItemNode=prev;
			}
			prev=temp;
			temp=temp.next;
		}
		if(itemNode==head)
			return head.next;
		ListNode nextNode=itemNode.next;
		prevItemNode.next=nextNode;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(4);
		ListNode temp=fetchDeleteLastOccurenceItemLinkedList(head,4);
		while(temp!=null) {
			System.out.print(temp.val+"----------->");
			temp=temp.next;
		}
	}

}
