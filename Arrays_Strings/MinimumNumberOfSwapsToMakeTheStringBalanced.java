package arrays;

import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {


	public int minSwapsWithOutStack(String s) {
		int i=0;
		int n=s.length();
		int size=0;
		while(i<n) {


			if(s.charAt(i)=='[') {
				size++;
			}else {

				if(size>0) {

					size--;
				}
			}
			i++;
		}
		return (size+1)/2;

	}


	public int minSwapsWithStack(String s) {


		Stack<Character>st=new Stack<>();

		int i=0;
		int n=s.length();
		while(i<n) {


			if(s.charAt(i)=='[') {
				st.push(s.charAt(i));
			}else {

				if(!st.isEmpty()) {

					st.pop();
				}
			}
			i++;
		}
		return (st.size()+1)/2;

	}


}