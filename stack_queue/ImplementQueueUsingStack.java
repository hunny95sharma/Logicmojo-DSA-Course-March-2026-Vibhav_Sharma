package stack_queue;

import java.util.Stack;

public class ImplementQueueUsingStack {

	private Stack<Integer>input;
	private Stack<Integer>output;
	private int peekEl;

	public ImplementQueueUsingStack() {

		input=new Stack<>();
		output=new Stack<>();
		peekEl=-1;
	}

	public void push(int x) {

		if(input.isEmpty())
			peekEl=x;
		input.push(x);
	}

	public int pop() {

		if(output.isEmpty()) {
			while(!input.isEmpty())
				output.push(input.pop());
		}

		int val=output.pop();
		return val;
	}

	public int peek() {

		if(output.isEmpty())
			return peekEl;
		else
			return output.peek();

	}

	public boolean empty() {

		return input.isEmpty()&&output.isEmpty();
	}


}