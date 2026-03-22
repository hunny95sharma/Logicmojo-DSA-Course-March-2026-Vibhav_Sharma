package arrays;

import java.util.Arrays;
import java.util.List;

public class AllZerosToEnd {
	
	public static List<Integer> move_func(int n, List<Integer> arr) {
	   int k=0;
	   int i=0;
		while(i<arr.size()) {
			if(arr.get(i)!=0) {
				int temp=arr.get(k);
				arr.set(k, arr.get(i));
				arr.set(i, temp);
				i++;
				k++;
			}else {
				i++;
			}
		}
return arr;
	    }

	public void moveZeroes(int[] nums) {
	    if (nums == null || nums.length == 0) {
	        return;
	    }

	    int i = 0;
	    for (int num : nums) {
	        if (num != 0) {
	            nums[i++] = num;
	        }
	    }
	    
	    while (i < nums.length) {
	        nums[i++] = 0;
	    }
	}

	public static void main(String[] args) {
		System.out.println(move_func(7,Arrays.asList(10,23,0,53,0,21,0)));
		System.out.println(move_func(7,Arrays.asList(10,23,53,21,0,0,0)));
	}

}
