package arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	
	public static void mergeTwoSortedArrays(int x[],int y[]) {
	for(int i=0;i<x.length;i++) {
		
		if(x[i]>y[0]) {
			int temp=x[i];
			x[i]=y[0];
			y[0]=temp;
			
			int hold=y[0];
			int k=1;
			while(k<y.length&&y[k]<hold) {
				y[k-1]=y[k];
				k++;
			}
			y[k-1]=hold;
		}
		
	}
	System.out.println(Arrays.toString(x));
	System.out.println(Arrays.toString(y));
	}

	
	public static void main(String[] args) {
		mergeTwoSortedArrays(new int[] {1,4,7,8,10},new int[] {2,3,9});
		}
	
}