package linked_list;

public class IntersectionLinkedList {

	class ListNode<T>{
		T data;
		ListNode<T>next;
		ListNode(T data){
			this.data=data;
		}
	}

	public static ListNode<Integer> fetchIntersectionLinkedList(ListNode<Integer>headA,ListNode<Integer>headB){

		ListNode<Integer>listA=headA;
		ListNode<Integer>listB=headB;
		int lengthA=0;
		int lengthB=0;
		int reminder=0;
		while(listA!=null) {
			lengthA++;
			listA=listA.next;
		}
		while(listB!=null) {
			lengthB++;
			listB=listB.next;
		}
		listA=headA;
		listB=headB;
		if(lengthA<lengthB) {
			reminder=lengthB-lengthA;
			while(reminder>0) {
				reminder--;
				headB=headB.next;
			}	
		}else {
			reminder=lengthA-lengthB;
			while(reminder>0) {
				reminder--;
				headA=headA.next;
			}
		}

		while(headA!=null&&headB!=null) {
			if(headA==headB)
				return headA;
			headA=headA.next;
			headB=headB.next;
		}
		return null;
	}
}
