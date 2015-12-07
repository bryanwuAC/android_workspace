
public class FindLargestProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] a={1.4,2,5,3.3,2,2,4,5,7,3,2,1,6,3};
		System.out.println(forwardfindPair(a,0,a.length-1));

	}
	public static double forwardfindPair(double[] a, int lo, int hi){
		if(lo==hi-1){
			return a[lo]*a[hi];
		}
		double current=a[lo]*a[lo+1];
		double next=forwardfindPair(a,lo+1,hi);
		return current>next?current:next;
	}

}
