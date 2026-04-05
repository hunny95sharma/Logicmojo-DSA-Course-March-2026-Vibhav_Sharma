package linked_list;

import java.util.HashMap;
import java.util.Map;

public class StartingPointCycle {
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public static ListNode fetchStartingPointCycleHashing(ListNode head) {
		
		ListNode temp=head;
		Map<ListNode,Integer>map=new HashMap<>();
		while(temp!=null) {
			if(map.containsKey(temp))
				return temp;
			map.put(temp, 1);
			temp=temp.next;
		}
		return null;
	}
	
	
	public static ListNode fetchStartingPointCycleOptimized(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(fast !=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
			if(slow==fast) {
				slow=head;
				while(slow!=fast) {
					slow=slow.next;
					fast=fast.next;
				}
				return slow;
			}
		}
		return null;
	}
	
	
}