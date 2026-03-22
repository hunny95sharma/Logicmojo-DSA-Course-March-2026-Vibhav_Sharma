package arrays;

import java.util.Arrays;

public class NegativeBeforePositive {
	
	public static int[]arrangeNegativeBeforePositive(int arr[]){
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			if(arr[start]<0&&arr[end]<0) {
				start++;
			}
			else if(arr[start]>0&&arr[end]>0) {
				end--;
			}
			else if(arr[start]>0&&arr[end]<0) {
				int temp=arr[start]; 
				arr[start]=arr[end]; 
				arr[end]=temp;
				start++;
				end--;
			}else {
				start++;
				end--;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrangeNegativeBeforePositive(new int[] {-12, 11, -13, -5, 6, -7, 5, -3, -6})));

	}

}
