package Practise;

public class MinAndMax {
	
	public class Pair{
		public int min;
		public int max;
	}
	
	public Pair min_max(int[] a, int low, int hight){
		Pair pair = new Pair();
		if(low > hight-2){
			if(a[low]<a[hight]){
				pair.min = a[low];
				pair.max = a[hight];
			}
			else{
				pair.min = a[hight];
				pair.max = a[low];
			}		
		}
		else{
			int mid = (low + hight)/2;
			Pair pair1 = min_max(a, low, mid);
			Pair pair2 = min_max(a,	mid+1, hight);
			pair.min = pair1.min < pair2.min ? pair1.min : pair2.min;
			pair.max = pair1.max > pair2.max ? pair1.max : pair2.max;
		}	
		return pair;
	}
	
	public static void main(String args[]){
		int[] a = new int[]{10,5,2,67,89,34,1,56,100,899,43,62,12,21,0};
		int low = 0;
		int hight= a.length-1;
		MinAndMax minAndMax = new MinAndMax();
		Pair pair = minAndMax.min_max(a, low, hight);
		System.out.println("the min is:"+pair.min);
		System.out.println("the max is:"+pair.max);
		
	}
}

