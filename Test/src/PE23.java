
public class PE23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[] a=new boolean[28124];
		for(int i=1; i<28124; i++){
			a[i]=false;
			if(i<factorSum(i))
				a[i]=true;
		}
		int sum=0;
		for(int i=1; i<28124; i++){
			if(judge(i, a)==false)
				sum+=i;
		}
		System.out.println(sum);

	}
	public static int factorSum(int num){
		int sum=0;
		for(int i=1; i<(int)Math.sqrt(num)+1; i++){
			if(num%i==0){
				if(num/i!=i)
					sum+=i+num/i;
				else
					sum+=i;
			}	
		}
		return sum-num;
	}
	public static boolean judge(int num, boolean[] a){
		for(int i=1; i<num/2+1; i++){
			if(a[num-i] && a[i])
				return true;
		}
		return false;
	}

}
