package binary_search;

public class SmallestMissing {
	
	public static int fetchSmallestMissingIterative(int arr[]) {
		int start=0;
		int end=arr.length-1;
		int ans=arr.length;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==mid) {
				start=mid+1;
			}else {
			ans=mid;
			end=mid-1;
			}	
		}
		return ans;
	}
	
	public static int fetchSmallestMissingRecursive(int arr[],int start,int end) {
		if(start>end)
			return start;
		int mid=start+(end-start)/2;
		if(arr[mid]==mid)
			return fetchSmallestMissingRecursive(arr,mid+1,end);
		else 
			return fetchSmallestMissingRecursive(arr,start,mid-1);
	}

	public static void main(String[] args) {
		System.out.println(fetchSmallestMissingIterative(new int[] {1, 2, 3, 4, 5, 6,7}));
		System.out.println(fetchSmallestMissingRecursive(new int[] {1, 2, 3, 4, 5, 6,7},0,6));

	}

}