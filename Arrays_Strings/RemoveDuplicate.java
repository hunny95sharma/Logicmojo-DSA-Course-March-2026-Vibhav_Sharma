package arrays;

import java.util.Arrays;

public class RemoveDuplicate {
	public static int removeDuplicate(int arr[]) {
		Arrays.sort(arr);
		int k=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]!=arr[i]) {
				k++;
				arr[k]=arr[i];
			}
		}
		return k+1;
	}
	
	
	

	public static void main(String[] args) {
		
		System.out.println(removeDuplicate(new int[] {1, 1, 2, 2, 2, 3, 4, 4}));

			}
	
}
