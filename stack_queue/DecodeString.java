package stack_queue;

import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {

		Stack<Integer>number=new Stack<>();

		Stack<String>st=new Stack<>();

		StringBuilder res = new StringBuilder();

		int i=0;

		while(i<s.length()) {

			char ch=s.charAt(i);

			if(Character.isDigit(ch)) {

				int count = 0;

				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					count = 10 * count + (s.charAt(i) - '0');
					i++;
				}
				number.push(count);

			}else if (s.charAt(i) == '[') {
				st.push(res.toString());
				res = new StringBuilder();
				i++;
			}else if(ch==']'){
				StringBuilder temp = new StringBuilder (st.pop());
				int repeatTimes = number.pop();
				for (int j = 1; j<= repeatTimes; j++) {
					temp.append(res);
				}
				res = temp;
				i++;
			}else {

				res.append(ch);
				i++;
			}

		}

		return res.toString();
	}


}