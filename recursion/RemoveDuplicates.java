package recursion;

public class RemoveDuplicates {
	
	 private static String removeConsecutiveDuplicates(String s) {
		 
		 if(s==null)
			 return null;
		 return removeConsecutiveDuplicatesHelper(s,0);
		
	}

	 private static String removeConsecutiveDuplicatesHelper(String s, int i) {
		
		 if(i==s.length())
			 return "";
		 char l=s.charAt(i);
		 String r=removeConsecutiveDuplicatesHelper(s,i+1);
		 if(r.length() == 0||l!=r.charAt(0))
			 return l+r;
		 return r;
		 
	 }
}