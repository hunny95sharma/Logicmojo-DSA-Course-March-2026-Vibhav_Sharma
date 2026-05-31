package stack_queue;

public class BackSpaceStringCompare {

	public boolean backspaceCompare2(String s, String t) {

		int i=s.length()-1;
		int j=t.length()-1;
		int skipS=0;
		int skipT=0;

		while(i>=0||j>=0) {

			while(i>=0) {
				if(s.charAt(i)=='#') {
					skipS++;
					i--;
				}else if(skipS>0) {
					skipS--;
					i--;
				}else {
					break;
				}

			}
			while(j>=0) {
				if(t.charAt(j)=='#') {
					skipT++;
					j--;
				}else if(skipT>0) {
					skipT--;
					j--;
				}else {
					break;
				}

			}
			char first=(i<0)?'$':s.charAt(i);
			char second=(j<0)?'$':t.charAt(j);
			if(first!=second)
				return false;
			i--;
			j--;

		}
		return true;

	}

	public boolean backspaceCompare1(String s, String t) {

		return buildString(s).equals(buildString(t));
	}

	private String buildString(String t) {
		int n=t.length();
		StringBuilder temp=new StringBuilder();
		int i=0;
		while(i<n) {
			if(t.charAt(i)!='#')
				temp.append(t.charAt(i));
			else if(temp.length()>0){
				temp.deleteCharAt(temp.length()-1);
			}
			i++;
		}
		return temp.toString();
	}


}