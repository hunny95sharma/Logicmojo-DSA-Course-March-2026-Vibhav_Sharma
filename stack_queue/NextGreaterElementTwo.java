package stack_queue;

import java.util.Stack;

public class NextGreaterElementTwo {

	public int[] nextGreaterElements(int[] nums) {
		int[]result=new int[nums.length];
		Stack<Integer>st=new Stack<>();

		for(int i=2*nums.length-1;i>=0;i--)
		{

			while(!st.isEmpty() && nums[st.peek()%nums.length]<=nums[i%nums.length])
				st.pop();

			if(st.isEmpty())
				result[i%nums.length]=-1;
			else
				result[i%nums.length]=nums[st.peek()%nums.length];

			st.push(i%nums.length);
		}

		return result;

	}


}