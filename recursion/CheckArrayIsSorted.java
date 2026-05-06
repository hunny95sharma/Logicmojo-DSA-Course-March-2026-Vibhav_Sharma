package recursion;

public class CheckArrayIsSorted {


	public static boolean checkSorted(int arr[]) {

		return checkSortedHelper(arr,0);
	}

	private static boolean checkSortedHelper(int[] arr, int i) {

		if(i==arr.length)
			return true;

		if(i+1<arr.length&&arr[i]>arr[i+1])
			return false;		
		return checkSortedHelper(arr,i+1);


	}
}