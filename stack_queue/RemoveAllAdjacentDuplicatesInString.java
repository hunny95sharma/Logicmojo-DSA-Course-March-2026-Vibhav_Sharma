package stack_queue;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

	public static String removeDuplicates(String s) {
		Stack<Character>st=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(!st.isEmpty() && st.peek()==ch) {
				st.pop();
			}else
				st.push(ch);
		}

		char[]result=new char[st.size()];

		int i=st.size()-1;
		while(!st.isEmpty()) {

			result[i--]=st.pop();

		}
		return new String(result);

	}

	public static void main(String args[]) {

		System.out.println(removeDuplicates("abbaca"));

	}

}