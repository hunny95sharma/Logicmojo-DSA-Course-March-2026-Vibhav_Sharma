package arrays;

import java.util.Stack;

public class BasicCalCulator1 {

	public int calculate(String s) {

		int number=0;
		int result=0;
		int sign=1;
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<s.length();i++) {

			char ch=s.charAt(i);

			if(ch=='(') {
				st.push(result);
				st.push(sign);
				result=0;
				number=0;
				sign=1;
			}else if(ch==' ') {
				continue;
			}
			else if(ch=='+') {
				result=result+sign*number;
				number=0;
				sign=1;
			}
			else if(ch=='-') {
				result=result+sign*number;
				number=0;
				sign=-1;
			}
			else if(ch==')') {
				result=result+sign*number;
				number=0;
				int stack_sign=st.pop();
				int stack_result=st.pop();
				result=result*stack_sign;
				result=result+stack_result;
			}else {
				int digit=ch-'0';
				number=digit+10*number;
			}
		}
		result=result+sign*number;
		return result;
	}

}