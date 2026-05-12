package arrays;

public class ReverseWordsInString {


	public String reverseWords(String s) {

		String result=new String();
		int i=0;
		int n=s.length();

		while(i<n) {

			while(i<n && s.charAt(i)==' ')
				i++;
			if(i>=n)
				break;

			int j=i+1;
			while(j<n&&s.charAt(j)!=' ') 
				j++;

			String temp=s.substring(i, j);
			if(result.length()==0)
				result=temp;
			else
				result=temp+" "+result;

			i=j;  


		}
		return result;
	}

}