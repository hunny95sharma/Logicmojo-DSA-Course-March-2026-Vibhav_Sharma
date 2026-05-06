package recursion;

import java.util.Arrays;

public class PrintAllPermutations {

	public static void FindPermutations(String str) {
		char[] chars = str.toCharArray();
        permuteHelper(chars, 0);
	}


	private static void permuteHelper(char[] chars, int idx) {

		if (idx == chars.length) {
			System.out.println(Arrays.toString(chars));
			return;
		}

		for(int i=idx;i<chars.length;i++) {


			swap(chars,idx,i);
			permuteHelper(chars,idx+1);
			swap(chars,idx,i);

		}


	}

	private static void swap(char [] nums, int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


}