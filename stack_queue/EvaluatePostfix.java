package stack_queue;

import java.util.Stack;

public class EvaluatePostfix {


	public static int evalPostfix(String exp)
	{


		Stack<Integer>st=new Stack<>();

		for(char ch:exp.toCharArray()) {

			if(Character.isDigit(ch)) {
				st.push(ch-'0');
			}else {

				int second=st.pop();
				int first=st.pop();

				if(ch=='+')
					st.push(first+second);
				if(ch=='-')
					st.push(first-second);
				if(ch=='*')
					st.push(first*second);
				if(ch=='/')
					st.push(first/second);

			}


		}
		return st.pop();
	}


}