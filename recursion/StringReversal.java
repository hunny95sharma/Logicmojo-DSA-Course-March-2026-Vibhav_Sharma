package recursion;

public class StringReversal {


	public static String fetchReversedString(String s) {

		if(s==null)
			return null;

		return fetchReversedStringHelper(s,0);

	}

	private static String fetchReversedStringHelper(String s, int i) {
		
		if(i==s.length())
			return "";
		
		char l=s.charAt(i);
		
		String r=fetchReversedStringHelper(s,i+1);
		return r+l;
		
		
	}



}