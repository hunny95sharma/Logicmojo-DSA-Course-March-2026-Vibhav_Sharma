package recursion;

import java.util.ArrayList;
import java.util.List;

public class ReturnSubSequences {

	public static String[] fetchAllSubsequences1(String s) {
		if(s==null)
			return null;


		return fetchAllSubsequencesHelper1(s,0);

	}
	public static String[] fetchAllSubsequencesHelper1(String s,int index) {

		if(s.length()==index)
			return new String[]{""};

		char l=s.charAt(index);

		String[]small=fetchAllSubsequencesHelper1(s,index+1);
		String[]ans=new String[2*small.length];
		int k=0;
		for(int i=0;i<small.length;i++) {
			ans[k]=small[i];
			k++;
		}
		for(int i=0;i<small.length;i++) {
			ans[k]=l+small[i];
			k++;
		}
		return ans;
	}


	public static List<String> fetchAllSubsequences2(String s) {
		if(s==null)
			return null;


		List<String>result=new ArrayList<>();

		fetchAllSubsequencesHelper2(s,0,"",result);
		return result;
	}
	public static void fetchAllSubsequencesHelper2(String s,int index,String temp,List<String> result) {

		if(index==s.length()) {

			result.add(temp);
			return;

		}

		fetchAllSubsequencesHelper2(s,index+1,temp+s.charAt(index),result);

		fetchAllSubsequencesHelper2(s,index+1,temp,result);

	}
	
	public static List<String> fetchAllSubsequences3(String s) {
	    if (s == null)
	        return null;

	    List<String> result = new ArrayList<>();
	    backtrack(s, 0, new StringBuilder(), result);
	    return result;
	}

	public static void backtrack(String s, int start, StringBuilder temp, List<String> result) {
	    // current subsequence add karo
	    result.add(temp.toString());

	    for (int i = start; i < s.length(); i++) {
	        // choose
	        temp.append(s.charAt(i));

	        // explore
	        backtrack(s, i + 1, temp, result);

	        // unchoose (backtracking)
	        temp.deleteCharAt(temp.length() - 1);
	    }
	}
}