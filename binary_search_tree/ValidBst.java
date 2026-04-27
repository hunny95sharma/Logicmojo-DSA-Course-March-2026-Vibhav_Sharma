package binary_search_tree;

import java.util.Stack;
public class ValidBst {
	public static boolean isValidPreorder(int[] arr, int n) {
		 Stack<Integer> stack = new Stack<>();
	        int root = Integer.MIN_VALUE;
	        for (int i = 0; i < n; i++) {
	            while (!stack.isEmpty() && arr[i]>stack.peek()) {
	                root = stack.pop();
	            }
	            
	            if(arr[i]<=root)
	            	return false;
	            stack.push(arr[i]);
	        }
	        return true;
	}
}