package recursion;

import java.util.ArrayList;

public class PalindromePartitioningTwo {

	public int minCut(String s) {
		int result[]=new int[1];
		result[0]=Integer.MAX_VALUE;
		partitionHelper(s,0,new ArrayList<String>(),result);
		return result[0];

	}

	private void partitionHelper(String s, int index, ArrayList<String> temp, int []result) {

		if(index==s.length()) {

			if(temp.size()-1<result[0]) {
				result[0]=temp.size()-1;
			}
			return;
		}
		for(int i=index;i<s.length();i++) {

			if(isPalindrome(s,index,i)) {
				temp.add(s.substring(index,i+1));
				partitionHelper(s,i+1,temp,result);
				temp.remove(temp.size()-1);
			}

		}

	}

	private boolean isPalindrome(String s, int left, int right) {

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

}