package binary_search;

public class SearchElementMisPlacedByPlusOneMinusOne {
	
	public static void fetchElementMisPlacedByPlusOneMinusOne(int arr[],int target) {
		if(arr[0]==target) {
			System.out.println("Element "+target+" found at index "+0);
			return;
		}
		if(arr[arr.length-1]==target) {
			System.out.println("Element "+target+" found at index "+(arr.length-1));
			return;
		}
		
		int start=1;
		int end=arr.length-2;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) {
				System.out.println("Element "+target+" found at index "+mid);
				return;
			}
			else if(arr[mid-1]==target) {
				 System.out.println("Element "+target+" found at index "+(mid-1));
				 return;
			}
			else if(arr[mid+1]==target) {
					 System.out.println("Element "+target+" found at index "+(mid+1));
					 return;
			}
			else if(arr[mid]>target) {
				end=mid-2;
			}else {
				start=mid+2;
			}
		}
		 System.out.println("Element not found");

	}

	public static void main(String[] args) {

		fetchElementMisPlacedByPlusOneMinusOne(new int[] {2, 1, 3, 5, 4, 7, 6, 8, 9},5);
	}

}
