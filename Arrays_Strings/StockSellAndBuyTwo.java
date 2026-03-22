package arrays;

public class StockSellAndBuyTwo {
	
	public static void printStockSellAndBuyTwo(int arr[]) {
		
		int buyPrice=arr[0];
		int buyPriceIndex=0;
		int profit=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {
				buyPrice=arr[i];
				buyPriceIndex=i;
			}
			if(arr[i]>=arr[i-1]&& (i+1==arr.length||arr[i]>arr[i+1])) {
			profit=profit+arr[i]-buyPrice;
			System.out.println("Buy on day "+(buyPriceIndex)+" and sell on day "+(i));
			}
		}
		System.out.println("Total profit earned is "+profit);
	}

	public static void main(String[] args) {
		printStockSellAndBuyTwo(new int[] {8,6,4,3,3,2,3,5,8,3,8,2,6});
	}

}
