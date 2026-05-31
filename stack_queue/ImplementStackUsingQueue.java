package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

	private Queue<Integer>q1;
	private Queue<Integer>q2;

	public ImplementStackUsingQueue() {
		q1=new LinkedList<>();
		q2=new LinkedList<>();
	}

	public void push(int x) {
		q2.offer(x);
		while(!q1.isEmpty())
			q2.offer(q1.poll());

		while(!q2.isEmpty())
			q1.offer(q2.poll());

	}

	public int pop() {

		int result=top();
		q1.poll();
		return result;

	}

	public int top() {
		return q1.peek();
	}

	public boolean empty() {
		return q1.isEmpty()&&q2.isEmpty();
	}


	public void push1(int x) {
		q1.offer(x);
		for(int i=0;i<q1.size()-1;i++)
		{
			q1.offer(q1.peek());
			q1.poll();
		}

	}

	public int pop1() {

		int result=top1();
		q1.poll();
		return result;

	}

	public int top1() {
		return q1.peek();
	}

	public boolean empty1() {
		return q1.isEmpty();
	}


}