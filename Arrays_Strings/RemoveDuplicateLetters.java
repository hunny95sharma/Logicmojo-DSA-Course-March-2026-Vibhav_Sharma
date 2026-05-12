package arrays;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters {



	public String removeDuplicateLettersWithStack(String s) {
		int n=s.length();
		Stack<Character>st=new Stack<>();
		boolean[]taken=new boolean[26];
		int[]lastIndex=new int[26];
		Arrays.fill(lastIndex, -1);
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			lastIndex[ch-'a']=i;
		}
		for(int i=0;i<n;i++) {
			char ch=s.charAt(i);
			int idx=ch-'a';
			if(taken[idx])
				continue;

			while(!st.empty()&&st.peek()>ch&&lastIndex[st.peek()-'a']>i) {
				taken[st.peek()-'a']=false;
				st.pop();
			}

			st.push(ch);
			taken[idx]=true;
		}
		StringBuilder result=new StringBuilder();

		while(!st.empty())
		{
			char ch=st.pop();
			result.append(ch);
		}
		return result.reverse().toString();
	}

	public String removeDuplicateLettersWithOutStack(String s) {
		int n=s.length();
		StringBuilder result=new StringBuilder();
		boolean[]taken=new boolean[26];
		int[]lastIndex=new int[26];
		Arrays.fill(lastIndex, -1);
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			lastIndex[ch-'a']=i;
		}
		for(int i=0;i<n;i++) {
			char ch=s.charAt(i);
			int idx=ch-'a';
			if(taken[idx])
				continue;

			while(result.length()>0&&result.charAt(result.length()-1)>ch&&lastIndex[result.charAt(result.length()-1)-'a']>i) {
				taken[result.charAt(result.length()-1)-'a']=false;
				result.deleteCharAt(result.length()-1);
			}

			result.append(ch);
			taken[idx]=true;
		}
		return result.toString();
	}
}