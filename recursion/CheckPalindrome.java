package recursion;

public class CheckPalindrome {


	public static boolean isPalindrome(String str) {
		
		if(str==null)
			return false;
		
		return isPalindromeHelper(str,0,str.length()-1);
		
		
	}

	private static boolean isPalindromeHelper(String str, int i, int j) {
		
		if(i>=j)
			return true;
		
		if(str.charAt(i)!=str.charAt(j))
			return false;
		
		return isPalindromeHelper(str,i+1,j-1);
		
		
	}


}