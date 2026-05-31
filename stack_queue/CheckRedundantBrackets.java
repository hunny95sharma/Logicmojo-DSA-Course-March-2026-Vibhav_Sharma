package stack_queue;

import java.util.Stack;

public class CheckRedundantBrackets {

	//Push characters onto stack
	//When ) appears:
	//Pop until (
	//Check whether an operator exists inside
	//If no operator → redundant brackets

	public static boolean checkRedundantBrackets(String expression) {
		Stack<Character>st=new Stack<>();
		for(int i=0;i<expression.length();i++) {
			char ch=expression.charAt(i);

			if(ch==')') {
				boolean isOperator=false;
				while(!st.isEmpty()&&st.peek()!='(') {
					char poppedElement=st.pop();
					if(poppedElement=='+'||poppedElement=='-'||poppedElement=='*'||poppedElement=='/')
						isOperator=true;
				}
				if(!isOperator)
					return true;
				if (!st.isEmpty()) {
					st.pop();
				}
			}else {

				if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='(')
					st.push(ch);

			}


		}
		return false;
	}


}