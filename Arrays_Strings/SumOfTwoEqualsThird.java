package arrays;

import java.util.Arrays;

public class SumOfTwoEqualsThird {
	
	public static void findThird(int arr[]) {
		Arrays.sort(arr);
		for(int i=arr.length-1;i>=0;i--) {
			int start=0;
			int end=i-1;
			while(start<end) {
				if(arr[start]+arr[end]==arr[i]) {
					System.out.println(arr[start]+"+"+arr[end]+"="+arr[i]);
					return;
				}
				else if(arr[start]+arr[end]>arr[i]) {
					end--;
				}else {
					start++;
				}
			}
			
		}
	}

	public static void main(String[] args) {
		findThird(new int[] {5, 32, 1, 7, 10, 50, 19, 21, 2});

	}

}
