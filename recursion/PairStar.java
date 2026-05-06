package recursion;

public class PairStar {

	public static String addStars(String s) {


		if(s==null)
			return null;

		return addStarsHelper(s,0);
	}

	private static String addStarsHelper(String s, int i) {

		if(i==s.length())
			return "";

		char l=s.charAt(i);
		String r=addStarsHelper(s,i+1);
		
		if(r.length()>0&&l==r.charAt(0)) {
			return l+"*"+r;
		}
		return l+r;
	}
}