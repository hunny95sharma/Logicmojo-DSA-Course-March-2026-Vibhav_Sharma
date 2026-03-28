package arrays;


public class TrappingRainWater {
	
	public static int fetchMaxTrappingRainWaterExtraSpace(int arr[]) {
		
		int maxFromRightAtI[]=new int[arr.length];
		int maxFromLeftAtI[]=new int[arr.length];
		int temp=0;
		int maxTrappingWater=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]>temp)
				temp=arr[i-1];
			maxFromLeftAtI[i]=temp;
		}
		temp=0;
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i+1]>temp)
				temp=arr[i+1];
			maxFromRightAtI[i]=temp;
		}
		for(int i=0;i<arr.length;i++) {
			temp=maxFromRightAtI[i]<maxFromLeftAtI[i]?maxFromRightAtI[i]:maxFromLeftAtI[i];
			if((temp-arr[i])>=0)
			maxTrappingWater=maxTrappingWater+temp-arr[i];
		}
		return maxTrappingWater;
	}
	
public static int fetchMaxTrappingRainWaterBruteForce(int arr[]) {	
	  int maxFromRightAtI=0;
	  int maxFromLeftAtI=0;
	  int maxTrappingWater=0;
	  for(int i=0;i<arr.length;i++) {
		  maxFromRightAtI=0;
		  maxFromLeftAtI=0;
		for(int j=i-1,k=i+1;j>=0||k<arr.length;j--,k++) {
			if(j>=0&&arr[j]>maxFromLeftAtI)
				maxFromLeftAtI=arr[j];
			
			if(k<arr.length&&arr[k]>maxFromRightAtI)
				maxFromRightAtI=arr[k];
		}
		int trappedWaterTillI=Math.min(maxFromLeftAtI,maxFromRightAtI)-arr[i];  
		if(trappedWaterTillI>=0)
		maxTrappingWater=maxTrappingWater+trappedWaterTillI;
	  }
		return maxTrappingWater;
	}

public static int fetchMaxTrappingRainWaterWithoutExtraSpace(int arr[]) {	
	 int start=0;
	 int end=arr.length-1;
	 int maxFromRightAtI=0;
	 int maxFromLeftAtI=0;
	 int maxTrappingWater=0;
	 while(start<end) {
		 if(arr[start]>maxFromLeftAtI)
			 maxFromLeftAtI=arr[start];
		 if(arr[end]>maxFromRightAtI)
			 maxFromRightAtI=arr[end];
		 if(maxFromLeftAtI<=maxFromRightAtI) {
			 maxTrappingWater=maxTrappingWater+maxFromLeftAtI-arr[start];
			 start++;
		 }else {
			 maxTrappingWater=maxTrappingWater+maxFromRightAtI-arr[end];
			 end--;
		 }
		 
		 }
	 return maxTrappingWater;
	}
	
	public static void main(String args[]) {
		
		System.out.println(fetchMaxTrappingRainWaterBruteForce(new int[] {4,2,0,3,2,5}));
		System.out.println(fetchMaxTrappingRainWaterExtraSpace(new int[] {4,2,0,3,2,5}));
		
	}

}
