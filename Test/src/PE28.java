
public class PE28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum=1;
		int n=1001;
		for(int i=3;  i<n+2; i=i+2){
			int square=i*i;
			int diff=i-1;
			sum+=4*square-6*diff;
		}
		System.out.println(sum);

	}

}
