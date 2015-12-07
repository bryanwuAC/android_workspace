public class PE21 {
	public static void main(String[] args){
		int sum=0;
		for(int i=1; i<10000; i++){
			int a=factorSum(i);
			int b=factorSum(a);
			if(b==i && a!=i)
				sum+=a+b;
		}
		System.out.println(sum/2);
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

}
