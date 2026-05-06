package recursion;

public class MaxOfArray {

	public static int fetchMaxOfArray(int arr[]) {

		return fetchMaxOfArrayHelper(arr,1,arr[0]);

	}

	private static int fetchMaxOfArrayHelper(int[] arr, int index,int result) {
		
		if(index==arr.length)
			return result;
		
		if(arr[index]>result)
			result=arr[index];
		
		return fetchMaxOfArrayHelper(arr,index+1,result);
		
	}



}