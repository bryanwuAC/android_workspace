
public class PrimeList {
	public static int[] primeList(int range){
		int[] data=new int[range];
		int num=2;
		int index=0;
		while(num<range){
			boolean isPrime=true;
			for(int i=2; i<(int)Math.sqrt(num)+1; i++){
				if(num%i==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime)
				data[index++]=num;
			num++;
		}
		return data;
	}
}
