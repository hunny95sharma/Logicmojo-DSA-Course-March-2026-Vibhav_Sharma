package arrays;

import java.util.Arrays;

public class ContainerMaximumWter {
	
	
	public static int[] fetchContainerWithMaximumWaterBruteForce(int arr[]) {
		int maxArea=0;
		int maxHeight=-1;
		int maxLength=-1;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int length=j-i;
				int height=arr[i]<arr[j]?arr[i]:arr[j];
			   int area=length*height;
			   if(area>maxArea) {
				   maxArea=area;
				   maxHeight=height;
				   maxLength=length;
			   }
			   
			}						
		}
		return new int[] {maxHeight,maxLength,maxArea};
	}
	
	public static int[] fetchContainerWithMaximumWaterOptimized(int arr[]) {
		int start=0;
		int end=arr.length-1;
		int maxArea=0;
		int maxHeight=-1;
		int maxLength=-1;
		while(start<end) {
			int length=end-start;
			int height=arr[start]<arr[end]?arr[start]:arr[end];
		   int area=length*height;
		   if(area>maxArea) {
			   maxArea=area;
			   maxHeight=height;
			   maxLength=length;
		   }
		   if(arr[start]<arr[end]) {
			   start++;
		   }
		   else if(arr[start]>arr[end])
		   {
			   end--;
		   }else {
			   start++;
			   end--;
		   }
			
		}
		return new int[] {maxHeight,maxLength,maxArea};
		
	}

	public static void main(String[] args) {
		
    System.out.println(Arrays.toString(fetchContainerWithMaximumWaterOptimized(new int[] {1,8,6,2,5,4,8,3,7})));
		
		
	}

}
