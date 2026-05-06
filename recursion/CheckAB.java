package recursion;

public class CheckAB {

	public static boolean checkAB(String input) {

		if(input==null)
			return false;

		if(input.charAt(0)!='a')
			return false;
		
		return checkABHelper(input,0);

	}

	private static boolean checkABHelper(String input, int index) {
		
		if(index==input.length())
			return true;
		
		char l=input.charAt(index);
		if(l=='a'&&index+1<input.length() && input.charAt(index+1)=='b' && index+2<input.length()&& input.charAt(index+2)=='b')
		{
			return checkABHelper(input,index+1);

		}
		else if(l=='a'&&index+1<input.length() && input.charAt(index+1)=='a')
		{
			return checkABHelper(input,index+1);

		}
		else if(l=='a'&&index+1==input.length())
		{
			return checkABHelper(input,index+1);

		}
		else if(l=='b'&&index+1<input.length() && input.charAt(index+1)=='b' && index+2<input.length()&& input.charAt(index+2)=='a')
		{
			return checkABHelper(input,index+2);
			
		}
		else if(l=='b'&&index+1<input.length() && input.charAt(index+1)=='b' && index+2==input.length())
		{
			return checkABHelper(input,index+2);
			
		}else {
			return false;
		}
		
		
	}


}