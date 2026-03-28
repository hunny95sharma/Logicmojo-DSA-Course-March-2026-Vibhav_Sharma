package binary_search;

public class PeakElementSortedArray {
	
	
	public static int fetchPeakElementSortedArray(int arr[]) {
		if(arr[0]>arr[1])
			return arr[0];
		if(arr[arr.length-1]>arr[arr.length-2])
			return arr[arr.length-1];
		int start=1;
		int end=arr.length-2;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
				return arr[mid];
			else if(arr[mid]>=arr[mid-1]&&arr[mid]<arr[mid+1]) {
				start=mid+1;
			}else if(arr[mid]<arr[mid-1]&&arr[mid]>=arr[mid+1]){
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return -1;
	}

}