package arrays;

public class FirstMissingPositive {
	
	public static int fetchFirstMissingPositive(int arr[]) {
		boolean isOnePresent=false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1)
				isOnePresent=true;
			if(arr[i]<=0 || arr[i]>arr.length)
				arr[i]=1;
		}
		if(!isOnePresent) {
			return 1;
		}
		for(int i=0;i<arr.length;i++) {
			int idx=Math.abs(arr[i])-1;
			if(arr[idx]>0) {
								arr[idx]=Math.abs(arr[idx])*-1;
			}
		}
		for(int i=0;i<arr.length;i++){
            if(arr[i]>0)
            return i+1;
        }
        return arr.length+1;
	}
}