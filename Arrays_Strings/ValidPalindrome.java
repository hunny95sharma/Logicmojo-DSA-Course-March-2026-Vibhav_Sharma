package arrays;

public class ValidPalindrome {

	public static boolean fetchValidPalindromeBruteForce(String str) {
		
		String res="";
		if(isPalindrome(str))
			return true;
		
		for(int i=0;i<str.length();i++) {
			res="";
			for(int j=0;j<str.length();j++) {
				if(i!=j)
					res=res+str.charAt(j);
			}
			if(isPalindrome(res))
				return true;
		}
		return false;
	}
	
	public static boolean fetchValidPalindromeNoExtraMemoryStillBruteForce(String str) {
		if(isPalindrome(str))
			return true;

		for(int i=0;i<str.length();i++) {
			int left=0;
			int right=str.length()-1;
			while(left<right) {
				if(left==i)
					left++;
				if(right==i)
					right--;
				if(str.charAt(left)!=str.charAt(right))
					break;
				left++;
				right--;
			}
			if(left>=right)
				return true;
		}
		return false;
	}
	
	public static boolean fetchValidPalindromeOptimized(String s) {
		 int left = 0, right = s.length() - 1;
	        while (left < right) {
	            if (s.charAt(left) == s.charAt(right)) {
	                left++;
	                right--;
	            } else {
	                return isPalindrome(s, left + 1, right) ||
	                       isPalindrome(s, left, right - 1);
	            }
	        }
	        return true;
	}
	
	public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
	
	public static boolean isPalindrome(String str) {
		int left=0;
		int right=str.length()-1;
		while(left<right) {
			if(str.charAt(left)!=str.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(fetchValidPalindromeNoExtraMemoryStillBruteForce("abca"));
		
	}

}
