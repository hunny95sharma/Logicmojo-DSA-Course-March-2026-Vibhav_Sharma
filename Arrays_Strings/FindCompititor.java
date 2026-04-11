package arrays;

import java.util.Arrays;

public class FindCompititor {
	
	public static int fetchFindCompititor(int arr[]) {
		if(arr.length<=0)
			return 0;
		Arrays.sort(arr);
		int totalGroups=0;
		long  prevGroupSum=0;
		long currGroupSum=0;
		int targetSize=1;
		int currGroupCount=0;
		for(int i=0;i<arr.length;i++) {
			currGroupSum=currGroupSum+arr[i];
			currGroupCount++;
			if(currGroupCount >= targetSize&&currGroupSum>prevGroupSum ) {
				totalGroups++;
				prevGroupSum=currGroupSum;
				currGroupSum=0;
				currGroupCount=0;
				targetSize++;
			}
		}
		return totalGroups;
	}

	public static void main(String[] args) {
		
		System.out.println(fetchFindCompititor(new int[] {6,6}));
	}

}
