package recursion;

public class PrintSubSequences {

	public static void printAllSubSequences(String s) {

		if(s==null)
			return;

		printAllSubSequencesHelper(s,0,"");

	}

	private static void printAllSubSequencesHelper(String s,int index, String res) {

		if(s.length()==index) {
			System.out.println(res+" ");
			return;	
		}

		char l=s.charAt(index);

		printAllSubSequencesHelper(s,index+1,res+l);
		printAllSubSequencesHelper(s,index+1,res);
	}

	public static void printAllSubSequences1(String s) {

		if (s == null) return;

		backtrack(s, 0, new StringBuilder());
	}

	private static void backtrack(String s, int start, StringBuilder temp) {

		// current subsequence print karo
		System.out.println(temp.toString());

		for (int i = start; i < s.length(); i++) {

			// choose
			temp.append(s.charAt(i));

			// explore
			backtrack(s, i + 1, temp);

			// unchoose
			temp.deleteCharAt(temp.length() - 1);
		}
	}

	public static void main(String args[]) {


		printAllSubSequences("geeks");

	}

}