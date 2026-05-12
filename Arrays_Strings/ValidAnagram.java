package arrays;

import java.util.Arrays;

public class ValidAnagram {


	public boolean isAnagramOptimized(String s, String t) {

		int count[]=new int[26];

		for(char ch:s.toCharArray())
			count[ch-'a']++;

		for(int i=0;i<t.length();i++)
		{
			char ch=t.charAt(i);
			count[ch-'a']--;
		}

		boolean isNotZero=Arrays.stream(count).allMatch(x->x==0);
		return isNotZero;

	}

	public boolean isAnagramSorting(String s, String t) {

		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		return Arrays.equals(arr1, arr2);

	}
}