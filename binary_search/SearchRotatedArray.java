package binary_search;

public class SearchRotatedArray {
	
	public static int fetchInRotatedArray(int arr[],int target) {
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target)
				return mid;
			if(arr[start]<=arr[mid]) {
				if(target>=arr[start]&&target<arr[mid]) {
					end=mid-1;
				}else {
					start=mid+1;
				}
				
			}else {
				if(target>arr[mid]&&target<=arr[end]) {
					start=mid+1;

				}else {
                           end=mid-1;
				}
			}
		}
		return -1;
	}
	
	public static int fetchInRotatedArrayDuplicates(int arr[],int target) {
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target)
				return mid;
			if(arr[mid]==arr[start]&&arr[mid]==arr[end])
			{
				start++;
				end--;
				continue;
			}
			if(arr[start]<=arr[mid]) {
				if(target>=arr[start]&&target<arr[mid]) {
					end=mid-1;
				}else {
					start=mid+1;
				}
				
			}else {
				if(target>arr[mid]&&target<=arr[end]) {
					start=mid+1;

				}else {
                           end=mid-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(fetchInRotatedArray(new int[] {4,5,6,7,0,1,2},4));
	}

}