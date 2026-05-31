package stack_queue;

import java.util.Stack;

public class StockSpan {

	Stack<int[]>st=new Stack<>();

	public StockSpan() {

	}

	public int next(int price) {
		int span=1;

		while(!st.isEmpty()&& st.peek()[0]<=price) {
			span=span+st.pop()[1];
		}
		st.push(new int[] {price,span});

		return span;
	}


}