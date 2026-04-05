package linked_list;

public class MidPointLinkedList {
	
	class Node<T>{
		T data;
		Node<T>next;
		Node(T data){
			this.data=data;
		}
	}
	
	public static int fetchMidPointLinkedList(Node<Integer>head) {
		Node<Integer>fast=head;
		Node<Integer>slow=head;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	} 
}
