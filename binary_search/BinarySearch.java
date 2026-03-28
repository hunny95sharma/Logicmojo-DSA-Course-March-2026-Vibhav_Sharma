package binary_search;

public class BinarySearch {
	
	public static int binarySearchIterative(int arr[],int target) {
	
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target)
				return mid;
			else if(arr[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return -1;
	}
	
   public static int binarySearchRecursive(int arr[],int start,int end,int target) {
		if(start>end)
			return -1;
		int mid=start+(end-start)/2;
		if(arr[mid]==target)
			return mid;
		else if(arr[mid]>target) {
			return binarySearchRecursive(arr,start,mid-1,target);
		}else {
			return binarySearchRecursive(arr,mid+1,end,target);
		}
		
	}

	public static void main(String[] args) {
		

	}

}
