package stack_queue;

import java.util.Stack;

public class DailyTemperature {

	public int[] dailyTemperatures(int[] temperatures) {

		int size=temperatures.length;

		int[]result=new int[temperatures.length];
		Stack<Integer>st=new Stack<>();
		for(int i=size-1;i>=0;i--) {
			while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]) {
				st.pop();
			}
			if(!st.isEmpty()) {
				result[i]=st.peek()-i;
			}else {
				result[i]=0;
			}
			st.push(i);

		}
		return result;

	}


}