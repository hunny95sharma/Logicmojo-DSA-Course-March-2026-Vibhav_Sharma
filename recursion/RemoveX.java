package recursion;

public class RemoveX {


	public static String removeX(String input){
		
		if(input==null)
			return input;
		
		return removeXhelper(input,0);

	}

	private static String removeXhelper(String input, int i) {
		
		if(i==input.length())
			return "";
		
		char l=input.charAt(i);
		String r=removeXhelper(input,i+1);
		if(l!='x')
			return l+r;
		else
			return r;
		
		
	}



}