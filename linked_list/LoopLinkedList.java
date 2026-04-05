package linked_list;

import java.util.HashMap;
import java.util.Map;


public class LoopLinkedList {
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public static boolean isLoopPresent(ListNode head) {
		if(head==null)
			return false;
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;
		}
		return false;
	}
	
public static boolean isLoopPresentHashing(ListNode head) {
		
		ListNode temp=head;
		Map<ListNode,Integer>map=new HashMap<>();
		while(temp!=null) {
			if(map.containsKey(temp))
				return true;
			map.put(temp, 1);
			temp=temp.next;
		}
		return false;
	}
}