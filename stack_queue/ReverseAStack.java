package stack_queue;

import java.util.Stack;

public class ReverseAStack {


	public static void reverseStack1(Stack<Integer> input, Stack<Integer> extra) {

		if(input.isEmpty())
			return;

		int temp=input.pop();
		reverseStack1(input,extra);

		while(!input.isEmpty())
			extra.push(input.pop());
		input.push(temp);
		while(!extra.isEmpty())
			input.push(extra.pop());

	}

	public static void reverseStack2(Stack<Integer> input, Stack<Integer> extra) {

		if(input.isEmpty())
			return;

		extra.push(input.pop());
		reverseStack2(input,extra);
		insertAtTheBottom(input,extra.pop());


	}



	public static void insertAtTheBottom(Stack<Integer>st,int element) {

		if(st.empty()) {
			st.push(element);
			return;
		}
		int top=st.pop();
		insertAtTheBottom(st,element);
		st.push(top);
	}

}