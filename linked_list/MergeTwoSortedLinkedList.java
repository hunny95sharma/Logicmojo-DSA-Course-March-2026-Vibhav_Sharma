package linked_list;

public class MergeTwoSortedLinkedList {
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public static ListNode mergeTwoListsBruteForce(ListNode list1, ListNode list2) {      
		ListNode head=null;
		ListNode nextNode=null;
		if(list1.val<=list2.val) {
			nextNode=list1.next;
			head=list1;
			list1.next=null;
			list1=nextNode;
		}else {
			nextNode=list2.next;
			head=list2;
			list2.next=null;
			list2=nextNode;
		}
		ListNode temp=null;
		while(list1!=null&&list2!=null) {
			temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			if(list1.val<=list2.val) {
				nextNode=list1.next;
				temp.next=list1;
				list1.next=null;
				list1=nextNode;
			}else {
				nextNode=list2.next;
				temp.next=list2;
				list2.next=null;
				list2=nextNode;
			}
		}
		temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
	       if(list1!=null) {
	    	   temp.next=list1;
	       }
	       if(list2!=null) {
              temp.next=list2;
	       }
         return head;
	}
	
	public static ListNode mergeTwoListsOptimized(ListNode list1, ListNode list2) {    
		ListNode head=null;
		ListNode nextNode=null;
		ListNode temp=null;
		if(list1.val<=list2.val) {
			nextNode=list1.next;
			head=list1;
			list1.next=null;
			temp=list1;
			list1=nextNode;
		}else {
			nextNode=list2.next;
			head=list2;
			list2.next=null;
			temp=list2;
			list2=nextNode;
		}
		while(list1!=null&&list2!=null) {
			if(list1.val<=list2.val) {
				nextNode=list1.next;
				temp.next=list1;
				list1.next=null;
				temp=list1;
				list1=nextNode;
			}else {
				nextNode=list2.next;
				temp.next=list2;
				list2.next=null;
				temp=list2;
				list2=nextNode;
			}
		}
	       if(list1!=null) {
	    	   temp.next=list1;
	       }
	       if(list2!=null) {
              temp.next=list2;
	       }
         return head;
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);
		
		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		
		ListNode temp=mergeTwoListsOptimized(list1,list2);
		while(temp!=null) {
			System.out.print(temp.val+"----------->");
			temp=temp.next;
		}
	}

}