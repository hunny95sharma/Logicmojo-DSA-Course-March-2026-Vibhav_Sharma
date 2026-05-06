package recursion;

public class ReplaceCharacterRecursively {

	public static String replaceCharacter(String input, char c1, char c2) {

		if(input==null)
			return null;

		if(input.length()==0)
			return "";
		
		char l=input.charAt(0);
		
		String r=replaceCharacter(input.substring(1),c1,c2);
		
		if(l==c1)
			l=c2;
		
		return l+r;
		
		

	}
}