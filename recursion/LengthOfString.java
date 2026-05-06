package recursion;

public class LengthOfString {

	public static int fetchLengthOfString(String s) {

		if(s==null)
			return 0;

		return fetchLengthOfStringHelper(s,s.length()-1);


	}

	private static int fetchLengthOfStringHelper(String s,int index) {
		
		if(index<0)
			return 0;
		
		return 1+fetchLengthOfStringHelper(s,index-1);
			
		
		
		
		
		
	}


}