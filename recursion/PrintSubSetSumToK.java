package recursion;

import java.util.ArrayList;

public class PrintSubSetSumToK {

	public static void printSubsetsSumTok1(int[] input, int target) {

		if (input == null) return;

		backtrack(input, 0, target, new ArrayList<>());
	}

	private static void backtrack(int[] input,
			int start,
			int target,
			ArrayList<Integer> temp) {

		if (target == 0) {
			for (int num : temp) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < input.length; i++) {

			// optional pruning
			if (input[i] > target) continue;

			// choose
			temp.add(input[i]);

			// explore
			backtrack(input, i + 1, target - input[i], temp);

			// unchoose
			temp.remove(temp.size() - 1);
		}
	}


	public static void printSubsetsSumTok(int input[], int target) {

		if(input==null)
			return;


		printSubsetsSumTok(input,0,new ArrayList<Integer>(),target);

	}

	private static void printSubsetsSumTok(int[] input,int index, ArrayList<Integer> temp, int target) {

		if(target==0) {

			for(int data:temp)

				System.out.print(data+" ");
			System.out.println();
			return;
		}


		if(index==input.length)
			return;

		temp.add(input[index]);

		printSubsetsSumTok(input,index+1,temp,target-input[index]);
		temp.remove(temp.size()-1);
		printSubsetsSumTok(input,index+1,temp,target);
	}



}