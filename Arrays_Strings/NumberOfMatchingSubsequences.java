package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfMatchingSubsequences {


	public int numMatchingSubseq(String s, String[] words) {


		int count=0;
		int n=s.length();
		HashMap<Character,ArrayList<Integer>>map=new HashMap<>();
		for(int i=0;i<n;i++) {
			char ch=s.charAt(i);
			map.putIfAbsent(ch, new ArrayList<Integer>());
			map.get(ch).add(i);
		}
		for(int i=0;i<words.length;i++) {

			if(isSubsequenceOpetimized(words[i],map))
				count++;

		}

		return count;
	}

	public boolean isSubsequenceOpetimized(String s, HashMap<Character,ArrayList<Integer>>map) {

		int m=s.length();

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


}