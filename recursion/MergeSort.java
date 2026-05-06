package recursion;

public class MergeSort {


	public static void mergeSort(int[] arr, int l, int r){


		if(l>=r)
			return;

		int mid=l+(r-l)/2;

		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);
		merge(arr,l,mid,r);
	}

	private static void merge(int[] arr, int l, int mid, int r) {

		int first[]=new int[mid-l+1];

		int second[]=new int[r-mid];

		int k=l;
		
		for(int i=0;i<first.length;i++) 
			first[i]=arr[k++];

		for(int i=0;i<second.length;i++) 
			second[i]=arr[k++];

		int i=0;
		int j=0;
	    k=l;
		while(i<first.length&&j<second.length) {
			if(first[i]>second[j]) {
				arr[k]=second[j];
				j++;
			}else {
				arr[k]=first[i];
				i++;
			}
			k++;
		}

		while(i<first.length) {

			arr[k]=first[i];
			k++;
			i++;
		}

		while(j<second.length) {

			arr[k]=second[j];
			k++;
			j++;
		}



	}

}