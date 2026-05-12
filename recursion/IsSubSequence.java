package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class IsSubSequence {

	public boolean isSubsequenceOpetimized(String s, String t) {

		int m=s.length();
		int n=t.length();
		HashMap<Character,ArrayList<Integer>>map=new HashMap<>();
		for(int i=0;i<n;i++) {
			char ch=t.charAt(i);
			map.putIfAbsent(ch, new ArrayList<Integer>());
			map.get(ch).add(i);
		}

		int prev=-1;
		for(int i=0;i<m;i++) {
			char ch=s.charAt(i);
			if(!map.containsKey(ch))
				return false;
			ArrayList<Integer>indices=map.get(ch);
			int idx=upperBound(indices,prev);
			if(idx==indices.size())
				return false;
			prev=indices.get(idx);
		}
		return true;
	}


	private int upperBound(ArrayList<Integer> list, int target) {

		int low = 0, high = list.size();

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (list.get(mid) <= target)
				low = mid + 1;
			else
				high = mid;
		}

		return low;
	}


	public boolean isSubsequenceIterative(String s, String t) {

		int m=s.length();
		int n=t.length();
		int i=0;
		int j=0;
		while(i<m &&j<n) {
			if(s.charAt(i)==t.charAt(j)) {
				i++;
				j++;
			}else {
				j++;
			}


		}
		return i==m;

	}

	public boolean isSubsequenceRecursive(String s, String t) {

		return isSubsequenceRecursiveHelper(s,0,t,0);
	}

	private boolean isSubsequenceRecursiveHelper(String s, int i, String t, int j) {

		if(s.length()==i)
			return true;
		if(t.length()==j)
			return false;
		if(s.charAt(i)==t.charAt(j))
			return isSubsequenceRecursiveHelper(s,i+1,t,j+1);
		else {
			return isSubsequenceRecursiveHelper(s,i,t,j+1);
		}


	}


}