package stack_queue;

public class StackUsingLinkedList<T> {

	private static class Node<T>{

		T data;
		Node<T>next;

		Node(T data){
			this.data=data;
			next=null;
		}

	}

	private Node<T>head;
	private int size=0;

	StackUsingLinkedList(){
		head=null;
		size=0;
	}

	public int size() {
		return size;
	}

	public T top() throws StackEmptyException {

		if(size()==0)
			throw new StackEmptyException();
		return head.data;
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public void push(T element) {

		Node<T>newNode=new Node<>(element);

		newNode.next=head;
		head=newNode;

		size++;

	}

	public T pop() throws StackEmptyException
	{

		if(size()==0)
			throw new StackEmptyException();

		Node<T> temp=head;
		head=head.next;
		size--;
		return temp.data;

	}

	public static void main(String args[]) {

		StackUsingLinkedList<Integer> st=new StackUsingLinkedList<>();

		for(int i=0;i<70;i++) {
			st.push(i);
		}


		while(!st.isEmpty()) {

			try {
				System.out.println(st.pop());
			} catch (StackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}