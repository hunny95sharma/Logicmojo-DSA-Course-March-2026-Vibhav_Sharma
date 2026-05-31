package stack_queue;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementOne {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Stack<Integer>st=new Stack<>();

		HashMap<Integer,Integer>map=new HashMap<>();
		for(int i=nums2.length-1;i>=0;i--) {

			while(!st.isEmpty() && nums2[st.peek()]<=nums2[i])
				st.pop();
			if(!st.empty()) {
				map.put(nums2[i], nums2[st.peek()]);
			}
			st.push(i);
		}

		int []result=new int[nums1.length];

		for(int i=0;i<nums1.length;i++) {
			if(map.containsKey(nums1[i]))
				result[i]=map.get(nums1[i]);
			else
				result[i]=-1;
		}
		return result;

	}


}