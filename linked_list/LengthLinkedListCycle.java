package linked_list;

import java.util.HashMap;
import java.util.Map;

public class LengthLinkedListCycle {
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public static int lengthLinkedListCycle(ListNode head) {
		
		ListNode slow=head;
		ListNode fast=head;
		boolean isLoopPresent=false;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				isLoopPresent=true;
				break;
			}
		}
		int count=0;
		if(isLoopPresent) {
			while(slow!=fast) {
				slow=slow.next;
				count++;
			}
		}
		return count;
		
	}
	
public static int lengthLinkedListCycleHashmap(ListNode head) {
		Map<ListNode,Integer>map=new HashMap<>();
		int timer=1;
		ListNode temp=head;
		while(temp!=null) {
			if(map.containsKey(temp)) {
				int value=map.get(temp);
				return timer-value+1;
		}
			map.put(temp, timer);
			timer++;
			temp=temp.next;
	}
	
	return 0;

}
}
