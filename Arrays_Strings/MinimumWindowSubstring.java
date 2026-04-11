package arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static String fetchMinimumWindowSubstringBruteForce(String s,String t) {
		if(s==null || t==null || (s.length()<t.length()))
			return "";
		int minimumLength=Integer.MAX_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		Map<Character,Integer> target=new HashMap<>();
		for(int i=0;i<t.length();i++) {
			target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0)+1);
		}
		for(int i=0;i<s.length();i++) {
			Map<Character,Integer> source=new HashMap<>();
			for(int j=i;j<s.length();j++) {
				source.put(s.charAt(j), source.getOrDefault(s.charAt(j), 0)+1);
				if((j-i+1)>=t.length()) {
					if((j-i+1)<minimumLength&&containsAll(source,target)) {
						minimumLength=j-i+1;
						startIndex=i;
						endIndex=j;
					}
				}
			}
		}
		System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
		if(minimumLength==Integer.MAX_VALUE)
			return "";
		return s.substring(startIndex,endIndex+1);
	}
	
	public static String fetchMinimumWindowSubstringSlidingWindowOptimal(String s,String t) {
		if(s==null || t==null || (s.length()<t.length()))
			return "";
		int minimumLength=Integer.MAX_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		Map<Character,Integer> target=new HashMap<>();
		for(int i=0;i<t.length();i++) {
			target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0)+1);
		}
		int start=0;
		int end=0;
		Map<Character,Integer> source=new HashMap<>();
		while(end<s.length()) {
			char ch=s.charAt(end);
			source.put(ch, source.getOrDefault(ch, 0)+1);
			while((end-start+1)>=t.length() && containsAll(source,target)) {
				ch=s.charAt(start);
				if((end-start+1)<minimumLength ) {
					minimumLength=end-start+1;
					startIndex=start;
					endIndex=end;
				}
				source.put(ch, source.get(ch)-1);
				if(source.get(ch)==0)
					source.remove(ch);
				start++;
			}
			end++;
		}
		System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
		if(minimumLength==Integer.MAX_VALUE)
			return "";
		return s.substring(startIndex,endIndex+1);
	}
	
	private static boolean containsAll(Map<Character, Integer> source, Map<Character, Integer> target) {
	    for (Character key : target.keySet()) {
	        if (source.getOrDefault(key, 0) < target.get(key)) {
	            return false;
	        }
	    }
	    return true;
	}

	public static String fetchMinimumWindowSubstringSlidingWindowBest(String s,String t) {
		if(s==null || t==null || (s.length()<t.length()))
			return "";
		Map<Character,Integer> target=new HashMap<>();
		for(int i=0;i<t.length();i++) {
			target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0)+1);
		}
		int required=target.size();
		int start=0;
		int end=0;
		Map<Character,Integer> source=new HashMap<>();
		int formed=0;
		int minimumLength=Integer.MAX_VALUE;
		int startIndex=-1;
		int endIndex=-1;
		while(end<s.length()) {
			char ch=s.charAt(end);
			source.put(ch, source.getOrDefault(ch, 0)+1);
			if(target.containsKey(ch)&&target.get(ch).equals(source.get(ch))) {
				formed++;
			}
			while((end-start+1)>=t.length() && formed==required) {
				ch=s.charAt(start);
				if((end-start+1)<minimumLength) {
					minimumLength=end-start+1;
					startIndex=start;
					endIndex=end;
				}
				source.put(ch, source.get(ch)-1);
				if(target.containsKey(ch)&& source.get(ch)<target.get(ch))
					formed--;
				if(source.get(ch)==0)
					source.remove(ch);
				start++;
			}
			end++;
		}
		System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);	
		if(startIndex!=-1 && endIndex!=-1)
		return s.substring(startIndex, endIndex+1);
		else
			return  "";
	}
}