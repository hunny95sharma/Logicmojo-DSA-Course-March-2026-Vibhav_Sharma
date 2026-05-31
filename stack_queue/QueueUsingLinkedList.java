package stack_queue;

public class QueueUsingLinkedList<T> {

	private static class Node<T>{

		T data;
		Node<T>next;
		Node(T data){
			this.data=data;
			next=null;
		}
	}

	private Node<T>front;

	private Node<T>rear;
	int size;


	QueueUsingLinkedList(){
		front=null;
		rear=null;
		size=0;
	}

	public int size() {

		return size();


	}

	public boolean isEmpty() {
		return size()==0;
	}

	public T front() throws QueueEmptyException {

		if(size()==0)
			throw new QueueEmptyException();
		return front.data;

	}


	public void enqueue(T element) {

		Node<T>temp=new Node<>(element);

		if(rear==null) {

			rear=temp;
			front=temp;

		}else {
			rear.next=temp;
			rear=temp;
		}
		size ++;

	}

	public T dequeue() throws QueueEmptyException {

		if(size()==0)
			throw new QueueEmptyException();

		T temp=front.data;
		front=front.next;
		size--;
		if(size()==0)
			rear=null;
		return temp;

	}


}