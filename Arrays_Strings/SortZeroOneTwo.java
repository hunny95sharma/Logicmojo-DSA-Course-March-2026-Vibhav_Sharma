package arrays;

import java.util.Arrays;

public class SortZeroOneTwo {

	public static int[]sortZeroOneTwo(int arr[]){
		int start=0;
		int end =arr.length-1;
		int mid=0;
		while(mid<=end) {
			if(arr[mid]<1) {
				int temp=arr[mid];
				arr[mid]=arr[start];
				arr[start]=temp;
				mid++;
				start++;
			}
			else if(arr[mid]>1) {
				int temp=arr[mid];
				arr[mid]=arr[end];
				arr[end]=temp;
				end--;
			}else {
				mid++;
			}
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
	 System.out.println(Arrays.toString(sortZeroOneTwo(new int[] {1,0,2,2,0,1})));
	}

}
