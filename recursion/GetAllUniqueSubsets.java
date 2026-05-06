package recursion;

import java.util.ArrayList;

public class GetAllUniqueSubsets {


	public static void printSubsets(int input[]) {


		if(input==null)
			return;

		ArrayList<Integer>res=new ArrayList<>();
		
		printSubsetsHelper(input,0,res);
	}

	private static void printSubsetsHelper(int[] input, int i,ArrayList<Integer>res) {

		if(i==input.length) {
			
			for(int j=0;j<res.size();j++) {
				System.out.print(res.get(j)+" ");			
				}
			System.out.println();
			return;
		}
		res.add(input[i]);
		printSubsetsHelper(input,i+1,res);
		res.remove(res.size()-1);
		while(i+1<input.length&&input[i]==input[i+1])
			i++;
		printSubsetsHelper(input,i+1,res);



	}


}