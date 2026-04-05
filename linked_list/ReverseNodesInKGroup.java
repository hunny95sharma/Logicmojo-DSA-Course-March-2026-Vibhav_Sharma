package linked_list;

public class ReverseNodesInKGroup {
	
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public static ListNode reverseLinkedList(ListNode temp) {
		ListNode prev=null;
		ListNode curr=temp;
		while(curr!=null) {
			ListNode next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	
	public static ListNode fetchReverseNodesInKGroup(ListNode head,int k) {
		ListNode temp=head;
		ListNode prev=null;
		while(temp!=null) {
			ListNode KthNode=getKthNode(temp,k);
			if(KthNode==null) {
				if(prev!=null)
					prev.next=temp;
				break;
			}
			ListNode nextNode=KthNode.next;
			KthNode.next=null;
			reverseLinkedList(temp);
			if(temp==head) {
				head=KthNode;
			}else {
				prev.next=KthNode;
			}
			prev=temp;
			temp=nextNode;
		}
		return head;
	}

	private static ListNode getKthNode(ListNode temp, int k) {
		k--;
		while(temp!=null&&k>0) {
			k--;
			temp=temp.next;
		}
		return temp;
	}
	
	
	public static ListNode fetchReverseNodesInKGroupRecursive(ListNode head,int k) {
		if(head==null)
			return null;
		ListNode curr=head;
		ListNode prev=null;
		ListNode next=null;
		int count=0;
		while(count<k&&curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			count++;
		}
		if(next!=null) {
			head.next=fetchReverseNodesInKGroupRecursive(next,k);
		}
		return prev;
	}

	public static void main(String[] args) {
		
		ListNode newNode=new ListNode(1);
		newNode.next=new ListNode(2);
		newNode.next.next=new ListNode(3);
		newNode.next.next.next=new ListNode(4);
		newNode.next.next.next.next=new ListNode(5);
		newNode.next.next.next.next.next=new ListNode(6);
		newNode.next.next.next.next.next.next=new ListNode(7);
		newNode.next.next.next.next.next.next.next=new ListNode(8);
		ListNode temp=fetchReverseNodesInKGroup(newNode,3);
		while(temp!=null) {
			System.out.print("------->"+temp.val);
			temp=temp.next;
		}	
	}
}
