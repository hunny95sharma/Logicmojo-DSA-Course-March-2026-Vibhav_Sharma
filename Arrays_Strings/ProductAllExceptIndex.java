package arrays;

import java.util.Arrays;

public class ProductAllExceptIndex {
	
	
	public static int[]fetchProductAllExceptIndexByDivision(int arr[]){
		
		int product=1;
		for(int i=0;i<arr.length;i++) {
			product=product*arr[i];
		}
		int k=0;
		for(int i=0;i<arr.length;i++) {
			arr[k]=product/arr[i];
			k++;
		}
		return arr;
	}
	
public static int[]fetchProductAllExceptIndexWithOutDivision(int arr[]){
		int prefix[]=new int[arr.length];
		int suffix[]=new int[arr.length];
		int k=0;
		prefix[k]=1;
		for(int i=1;i<arr.length;i++) {
			k++;
			prefix[k]=arr[i-1]*prefix[k-1];
		}
		k=arr.length-1;
		suffix[k]=1;
		for(int i=arr.length-2;i>=0;i--) {
			k--;
			suffix[k]=arr[i+1]*suffix[k+1];
		}
		for(int i=0;i<arr.length;i++) {
			arr[i]=prefix[i]*suffix[i];
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		
	    System.out.println(Arrays.toString(fetchProductAllExceptIndexWithOutDivision(new int[] {1,2,3,4})));
			
			
		}

}