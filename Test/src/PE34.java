
public class PE34 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum=0;
		for(int i=10; i<=40585; i++){
			if(i==factSum(i))
				sum+=i;
		}
		System.out.println(sum);
			
	}
	private static long factSum(int num) {
		long result=0;
		while(num!=0){
			result+=getFact(num%10);
			num/=10;
		}
		return result;
	}
	public static long getFact(int a){
		switch(a){
		case 0: return 1;
		case 1: return 1;
		case 2: return 2;
		case 3: return 6;
		case 4: return 24;
		case 5: return 120;
		case 6: return 720;
		case 7: return 5040;
		case 8: return 40320;
		case 9: return 362880;
		}
		return 0;
	}

}
