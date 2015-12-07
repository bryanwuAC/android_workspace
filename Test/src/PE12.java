
public class PE12 {
	public static void main(String args[]){
		int count=0;
		long starttime=System.currentTimeMillis();
		long n=0;
		while (count<250){
			count=0;
			n++;
			long num=n*(n+1)/2;
			for(int i=1; i<(int)Math.sqrt(num); i++){
				if (num % i==0){
					count++;
				}
			}
		}
		System.out.println(n);
		System.out.println(System.currentTimeMillis()-starttime);
	}

}
