package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {


		List<List<String>>result=new ArrayList<>();
		partitionHelper(s,0,new ArrayList<String>(),result);
		return result;

	}

	private void partitionHelper(String s, int index, ArrayList<String> temp, List<List<String>> result) {

		if(index==s.length())
		{
			result.add(new ArrayList<String>(temp));
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