package stack_queue;

import java.util.Stack;

public class MaximumNestingDepthParenthesis {

	public static int maxDepth(String s) {
		Stack<Character>st=new Stack<>();
		int result=0;

		for(int i=0;i<s.length();i++) {

			char ch=s.charAt(i);

			if(ch=='(') {
				st.push(ch);
				result=Math.max(result, st.size());
			}

			else if (ch == ')') {
				if (!st.isEmpty()) {
					st.pop();
				}
			}


		}


		return result;

	}

	public static int maxDepthOptimized(String s) {
		int openBrackets=0;
		int result=0;

		for(int i=0;i<s.length();i++) {

			char ch=s.charAt(i);

			if(ch=='(') {
				openBrackets++;
				result=Math.max(result, openBrackets);
			}

			else if (ch == ')') {
				if (openBrackets>0) {
					openBrackets--;
				}
			}


		}


		return result;

	}

	public static void main(String args[]) {

		System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));

	}

}