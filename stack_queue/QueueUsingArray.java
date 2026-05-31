package stack_queue;

public class QueueUsingArray {

	int []data;
	int rear;
	int front;
	int size;

	QueueUsingArray(){
		data=new int[10];
		rear=-1;
		front=-1;
		size=0;
	}
	QueueUsingArray(int capacity){
		data=new int[capacity];
		rear=-1;
		front=-1;
		size=0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public int front() throws QueueEmptyException {
		if(size()==0)
			throw new QueueEmptyException();
		return data[front];
	}

	public void enqueue(int element){

		if(size()==data.length)
			doubleCapacity();

		if(size()==0) {
			front=0;

		}

		rear++;
		size++;
		if(rear==data.length)
			rear=0;
		data[rear]=element;

	}

	private void doubleCapacity() {

		int temp[]=data;
		data=new int[2*temp.length];
		int k=0;
		for(int i=front;i<temp.length;i++)
			data[k++]=temp[i];
		for(int i=0;i<=front-1;i++)
			data[k++]=temp[i];

		front=0;
		rear=temp.length-1;

	}
	public int dequeue() throws QueueEmptyException {

		if(size()==0)
			throw new QueueEmptyException();

		int temp=data[front];
		front++;
		size--;
		if(front==data.length)
			front=0;

		if(size==0)
		{
			front=-1;
			rear=-1;
		}

		return temp;

	}


	public static void main(String args[]) {
		QueueUsingArray queue=new QueueUsingArray();

		for(int i=1;i<=40;i++)

			queue.enqueue(i);

		while(!queue.isEmpty())
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


}