package recursion;

public class BinarySearch {

	public static int binarySearch(int input[], int element) {

		return binarySearchHelper(input,0,input.length-1,element);

	}

	private static int binarySearchHelper(int[] input, int low, int high, int element) {
		
		if(low>high)
			return -1;
		
		int mid=low+(high-low)/2;
		int ans=-1;
		if(input[mid]==element)
			ans=mid;
				
		else if(element<input[mid])
		 ans=binarySearchHelper(input,low,mid-1,element);
	
		else
			ans=binarySearchHelper(input,mid+1,high,element);
		return ans;
		
	}

}