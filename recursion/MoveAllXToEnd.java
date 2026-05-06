package recursion;

public class MoveAllXToEnd {

	
	public static String fetchMoveAllXToEnd(String s) {
		
		if(s==null)
return null;
		
		return fetchMoveAllXToEndHelper(s,0);
		
	}

	private static String fetchMoveAllXToEndHelper(String s, int i) {
		
		if(i==s.length())
			return "";
		
		char l=s.charAt(i);
		String r=fetchMoveAllXToEndHelper(s,i+1);
		
		if(l=='x')
			return r+l;
		return l+r;
		
		
		
	}
	
	
}