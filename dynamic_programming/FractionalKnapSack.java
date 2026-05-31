package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FractionalKnapSack {


	public static class Item{

		private int value;
		private int weight;

		Item(int value,int weight){
			this.value=value;
			this.weight=weight;
		}

		public int getValue() {
			return value;
		}

		public int getWeight() {
			return weight;
		}


	}


	public static double maximumUnits(int[]values,int weight[], int capacity) {


		int n=values.length;

		ArrayList<Item>temp=new ArrayList<>();

		for(int i=0;i<n;i++)
			temp.add(new Item(values[i],weight[i]));

		Collections.sort(temp, (Item a, Item b) -> {

			double ratio1 = (double) a.getValue() / a.getWeight();
			double ratio2 = (double) b.getValue() / b.getWeight();

			return Double.compare(ratio2, ratio1);

		});

		double result=0.0;

		for(Item item:temp) {

			if(item.getWeight()<=capacity) {
				result=result+item.getValue();
				capacity=capacity-item.getWeight();

			}else {

				result=result+(capacity*((double)item.getValue()/item.getWeight()));
				break;

			}
		}

		return result;

	}

	public int maximumUnits(int[][] boxTypes, int truckSize) {




		Arrays.sort(boxTypes, ( a,  b) -> {

			return Integer.compare(b[1],a[1]);

		});

		int result=0;

		for(int[] box:boxTypes) {

			if(box[0]<=truckSize) {
				result=result+box[0]*box[1];
				truckSize=truckSize-box[0];

			}else {

				result=result+(truckSize*box[1]);
				break;

			}
		}

		return result;

	}

}