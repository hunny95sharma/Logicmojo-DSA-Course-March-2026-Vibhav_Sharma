package stack_queue;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {

		Stack<Character>st=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='('||c=='{'||c=='[')
				st.push(c);
			else
			{
				if(st.empty())
					return false;
				char ch=st.pop();
				if(ch=='(' && c==')')
					continue;
				else if(ch=='['&& c==']')
					continue;
				else if(ch=='{'&& c=='}')
					continue;
				else
					return false;
			}

		}
		return st.empty();

	}

}