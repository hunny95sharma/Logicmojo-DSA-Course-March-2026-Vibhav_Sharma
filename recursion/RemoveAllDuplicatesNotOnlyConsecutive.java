package recursion;

public class RemoveAllDuplicatesNotOnlyConsecutive {

	
	public static String fetchRemoveAllDuplicatesNotOnlyConsecutive(String s) {
		
		if(s==null)
			return null;
		return fetchRemoveAllDuplicatesNotOnlyConsecutive(s,0,new int[26]);
		
	}

	private static String fetchRemoveAllDuplicatesNotOnlyConsecutive(String s, int index, int[] frequencyMap) {
		
		if(index==s.length())
			return "";
		
		String r=fetchRemoveAllDuplicatesNotOnlyConsecutive(s,index+1,frequencyMap);
		
		char l=s.charAt(index);
		frequencyMap[l-'a']=frequencyMap[l-'a']+1;
		
		if(frequencyMap[l-'a']>1)
			return r;
		return l+r;
		
	}
	
}