package linkedlist;

public class DeleteAlternateNodes {

	class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data) {
			this.setData(data);
			this.next = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

	public static void deleteAlternateNodes(Node<Integer> head) {


		if(head==null)
			return;

		Node<Integer>curr=head;

		while(curr!=null && curr.next!=null) {
			Node<Integer>deleteNode=curr.next;
			curr.next=deleteNode.next;
			deleteNode.next=null;
			curr=curr.next;
		}


	}

}