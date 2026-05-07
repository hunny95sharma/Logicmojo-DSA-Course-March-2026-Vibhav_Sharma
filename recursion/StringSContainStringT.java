package recursion;

public class StringSContainStringT {

	public static boolean checkSequence(String s, String t) {

		return checkSequenceHelper(s,0,t,0);

	}

	private static boolean checkSequenceHelper(String s, int sIndex, String t, int tIndex) {
		
		if(tIndex==t.length())
			return true;
		
		if(sIndex==s.length())
			return false;
		
		if(s.charAt(sIndex)==t.charAt(tIndex))
			return checkSequenceHelper(s,sIndex+1,t,tIndex+1);
		else
			return checkSequenceHelper(s,sIndex+1,t,tIndex);
		
	}


}