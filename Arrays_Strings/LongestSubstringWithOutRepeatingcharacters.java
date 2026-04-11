package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithOutRepeatingcharacters {
	
	public static int fetchLongestSubstringWithOutRepeatingcharactersBruteForce1(String str) {
		  if (str == null || str.equals(""))
			    return 0;
							int maxLength=0;
							int startIndex=-1;
							int endIndex=-1;
							for(int i=0;i<str.length();i++)
							{
								int length=0;
			                    Set<Character>set=new HashSet<>();
								int j=i;
								for(;j<str.length();j++) {
									char ch=str.charAt(j);			           
									if(!set.contains(ch)) {
										length++;
										 set.add(ch);
									}else {
										break;
									}
									if(length>maxLength) {
										maxLength=length;
										startIndex=i;
										endIndex=j;
									}	
								}
							}
							System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
							return maxLength;
	}
	
	public static int fetchLongestSubstringWithOutRepeatingcharactersBruteForce2(String str) {
		  if (str == null || str.equals(""))
			    return 0;
							int maxLength=0;
							int startIndex=-1;
							int endIndex=-1;
							for(int i=0;i<str.length();i++)
							{
								int length=0;
			                    int hash[]=new int[256];
								int j=i;
								for(;j<str.length();j++) {
									char ch=str.charAt(j);			           
									if(hash[ch]!=1) {
										length++;
										hash[ch]=1;
									}else {
										break;
									}
									if(length>maxLength) {
										maxLength=length;
										startIndex=i;
										endIndex=j;
									}	
								}
							}
							System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
							return maxLength;
	}
	
	public static int fetchLongestSubstringWithOutRepeatingcharactersSlidingWindow1(String str) {
		 if (str == null || str.equals(""))
			    return 0;
							int maxLength=0;
							int startIndex=-1;
							int endIndex=-1;
							int start=0;
							int end=0;
							Set<Character>set=new HashSet<>();
							while(end<str.length()) {
								char ch=str.charAt(end);
								while(set.contains(ch)) {
									set.remove(str.charAt(start));
									start++;
								}
								set.add(ch);
								if((end-start+1)>maxLength) {
									maxLength=end-start+1;
									startIndex=start;
									endIndex=end;
								}
								end++;
							}
							System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
							return maxLength;
	}
	
	public static int fetchLongestSubstringWithOutRepeatingcharactersSlidingWindow2(String str) {
		 if (str == null || str.equals(""))
			    return 0;
							int maxLength=0;
							int startIndex=-1;
							int endIndex=-1;
							int start=0;
							int end=0;
							Map<Character,Integer>map=new HashMap<>();
							while(end<str.length()) {
								char ch=str.charAt(end);
								if(map.containsKey(ch) && map.get(ch)>=start) {
									start=map.get(ch)+1;
								}
								map.put(ch,end);
								if((end-start+1)>maxLength) {
									maxLength=end-start+1;
									startIndex=start;
									endIndex=end;
								}
								end++;
							}
							System.out.println("startIndex===>"+startIndex+",endIndex===>"+endIndex);
							return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(fetchLongestSubstringWithOutRepeatingcharactersSlidingWindow2("abcabcbb"));
	}

}
