
public class PE26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int range=1000;
		int[] data=PrimeList.primeList(range);
		for(int i=0; i<range; i++)
			if(data[i]!=0){
				System.out.println(100000.0/data[i]);
			}

	}
}
