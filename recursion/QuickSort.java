package recursion;

public class QuickSort {

	public static void quickSort(int[] arr,int low, int high) {
		
		if(low>=high)
			return ;

		int pivotIndex=fetchPivot(arr,low,high);

		quickSort(arr,low,pivotIndex-1);

		quickSort(arr,pivotIndex+1,high);

	}

	private static int fetchPivot(int[] arr, int low, int high) {

		int pivot=arr[high];

		int pl=low;
		for(int i=low;i<high;i++)
		{
			if(arr[i]<=pivot) {
				int temp=arr[i];
				arr[i]=arr[pl];
				arr[pl]=temp;
				pl++;
			}
		}
		
		int temp=arr[pl];
		arr[pl]=arr[high];
		arr[high]=temp;

		return pl;
		
	}


}