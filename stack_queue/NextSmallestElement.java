package stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElement {

	public static int[]fetchNextSmallestElementLeft(int arr[]){


		Stack<Integer>st=new Stack<>();

		int []result=new int[arr.length];
		for(int i=0;i<arr.length;i++) {

			while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
				st.pop();

			if(st.isEmpty())

				result[i]=-1;
			else 
				result[i]=arr[st.peek()];

			st.push(i);
		}

		return result;

	}

	public static int[]fetchNextSmallestElementRight(int arr[]){


		Stack<Integer>st=new Stack<>();

		int []result=new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {

			while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
				st.pop();

			if(st.isEmpty())

				result[i]=-1;
			else 
				result[i]=arr[st.peek()];

			st.push(i);
		}

		return result;

	}


	public static void main(String args[]) {

		System.out.println(Arrays.toString(fetchNextSmallestElementLeft(new int[] {2, 1, 3, 2, 4, 5})));
		System.out.println(Arrays.toString(fetchNextSmallestElementRight(new int[] {2, 1, 3, 2, 4, 5})));

	}


}