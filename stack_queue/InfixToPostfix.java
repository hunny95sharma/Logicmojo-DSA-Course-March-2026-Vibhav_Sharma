package stack_queue;

import java.util.Stack;

public class InfixToPostfix{

	public static String infixToPostfix(String infix)
	{

		StringBuilder result=new StringBuilder();

		Stack<Character>st=new Stack<>();

		for(char ch:infix.toCharArray()) {

			if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {

				while(!st.isEmpty()&&st.peek()!='('&&precidence(st.peek())>=precidence(ch))
				{
					result.append(st.pop());
				}
				st.push(ch);


			}else if(ch=='('){
				st.push(ch);
			}else if(ch==')'){
				while(!st.isEmpty() && st.peek()!='(')
					result.append(st.pop());
				if(!st.isEmpty())
					st.pop();
			}else if(isOperand(ch)) {

				result.append(ch);
			}


		}

		while(!st.isEmpty())
			result.append(st.pop());
		return result.toString();


	}

	private static int precidence(char c) {
		if(c=='*'||c=='/')
			return 2;
		if(c=='+'||c=='-')
			return 1;

		return -1;

	}
	public static boolean isOperand(char c)
	{
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
				(c >= '0' && c <= '9');
	}



}