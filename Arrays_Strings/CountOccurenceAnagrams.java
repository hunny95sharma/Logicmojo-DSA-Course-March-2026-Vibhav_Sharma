package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOccurenceAnagrams {
	
	public static int fetchCountOccurenceAnagramsBruteForce(String input,String output) {
		if(input==null||output==null||output.length()<input.length())
			return 0;
		char ch;
		Map<Character,Integer>target=new HashMap<>();
		for(int i=0;i<input.length();i++) {
			ch=input.charAt(i);
			target.put(ch, target.getOrDefault(ch, 0)+1);
		}
		int count=0;
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<output.length();i++) {
			int j=i;
			Map<Character,Integer>source=new HashMap<>();
			for(;j<output.length();j++) {
				ch=output.charAt(j);
				source.put(ch, source.getOrDefault(ch, 0)+1);
				if((j-i+1)==input.length()&&target.equals(source)) {
					result.add(i);
					count++;
				}
				if((j-i+1)>input.length())
					break;
			}
		}
		System.out.print("Result: "+result);
		return count;
	}

	public static int fetchCountOccurenceAnagramsSlidingWindowOptimal(String input,String output) {
		if(input==null||output==null||output.length()<input.length())
			return 0;
		char ch;
		Map<Character,Integer>target=new HashMap<>();
		for(int i=0;i<input.length();i++) {
			ch=input.charAt(i);
			target.put(ch, target.getOrDefault(ch, 0)+1);
		}
		int count=0;
		List<Integer> result=new ArrayList<>();
		int start=0;
		int end=0;
		Map<Character,Integer>source=new HashMap<>();
		while(end<output.length()) {
			ch=output.charAt(end);
			source.put(ch, source.getOrDefault(ch, 0)+1);
			if((end-start+1)>input.length()) {
				ch=output.charAt(start);
				source.put(ch, source.get(ch)-1);
				if(source.get(ch)==0)
					source.remove(ch);
				start++;
			}
			if((end-start+1)==input.length() && source.equals(target)) {
				result.add(start);
				count++;
			}
			end++;
		}
		System.out.print("Result: "+result);
		return count;
	}
	
	public static int fetchCountOccurenceAnagramsSlidingWindowBest(String input,String output) {
		if(input==null||output==null||output.length()<input.length())
			return 0;
		char ch;
		Map<Character,Integer>target=new HashMap<>();
		for(int i=0;i<input.length();i++) {
			ch=input.charAt(i);
			target.put(ch, target.getOrDefault(ch, 0)+1);
		}
		int count=0;
		List<Integer> result=new ArrayList<>();
		int start=0;
		int end=0;
		Map<Character,Integer>source=new HashMap<>();
		int required=target.size();
		int matches=0;
		while(end<output.length()) {
			ch=output.charAt(end);
			source.put(ch, source.getOrDefault(ch, 0)+1);
			if(target.containsKey(ch)&&target.get(ch).equals(source.get(ch)))
				matches++;
			if((end-start+1)>input.length()) {
				ch=output.charAt(start);
				if(target.containsKey(ch) && target.get(ch).equals(source.get(ch)))
					matches--;
				source.put(ch, source.get(ch)-1);
				if(source.get(ch)==0)
					source.remove(ch);
				start++;
			}
			if((end-start+1)==input.length() && required==matches) {
				result.add(start);
				count++;
			}
			end++;
		}
		System.out.print("Result: "+result);
		return count;
	}
	

	public static void main(String[] args) {
		System.out.println(fetchCountOccurenceAnagramsBruteForce("for","forxxorfxdofr"));
		System.out.println(fetchCountOccurenceAnagramsSlidingWindowBest("for","forxxorfxdofr"));
		System.out.println(fetchCountOccurenceAnagramsBruteForce("aaba","aabaabaa"));
		System.out.println(fetchCountOccurenceAnagramsSlidingWindowBest("aaba","aabaabaa"));
	}

}