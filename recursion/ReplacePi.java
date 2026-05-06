package recursion;

public class ReplacePi {

	public static String replace(String input){
		if(input==null)
			return null;		
		return replaceHelper2(input,0);
	}

	private static String replaceHelper2(String input, int i) {
		
		if(input.length()==i)
			return "";
		
		char l=input.charAt(i);
		String r=replaceHelper2(input,i+1);
		if(l=='p' && r.length()>0&&r.charAt(0)=='i') {
			
			return "3.14"+r.substring(1);
			
		}
		return l+r;
		
		
		
	}

	private static String replaceHelper1(String input,int index) {

		if(index==input.length())
			return "";

		char f=input.charAt(index);
		String m="";
		if(index+1<input.length()) {
			char s=input.charAt(index+1);
			if(f=='p' && s=='i') {
				m="3.14";
				index=index+2;
			}else {
				m=m+f;
				index=index+1;
			}
		}else {
			m=m+f;
			index=index+1;
		}
		String r=replaceHelper1(input,index);
		return m+r;


	}


	public static void main(String args[]) {

		System.out.println(replace("pippiippip"));

	}
}