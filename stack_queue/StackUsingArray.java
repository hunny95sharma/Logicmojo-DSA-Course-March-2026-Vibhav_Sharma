package stack_queue;

public class StackUsingArray {

	private int data[];
	private int top;

	StackUsingArray(){
		data=new int[10];
		top=-1;
	}

	StackUsingArray(int capacity){
		data=new int[capacity];
		top=-1;
	}

	public boolean isEmpty() {
		return top==-1;
	}

	public int size() {
		return top+1;
	}

	public void push(int element) throws StackFullException {


		if(size()==data.length)
			doubleCapacity();

		top++;
		data[top]=element;

	}

	private void doubleCapacity() {
		int temp[]=data;
		data=new int[2*temp.length];
		for(int i=0;i<=top;i++)
			data[i]=temp[i];

	}

	public int top() throws StackEmptyException {
		if(size()==0)
			throw new StackEmptyException();
		return data[top];
	}

	public int pop() throws StackEmptyException {

		if(size()==0)
			throw new StackEmptyException();

		int temp=data[top];
		top--;
		return temp;

	}

	public static void main(String args[]) {

		StackUsingArray st=new StackUsingArray();

		for(int i=0;i<70;i++) {
			try {
				st.push(i);
			} catch (StackFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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