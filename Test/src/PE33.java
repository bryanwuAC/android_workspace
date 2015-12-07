
public class PE33 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num=1;
		int den=1;
		for(int deN=10; deN<100; deN++){
			for(int nuM=10; nuM<deN; nuM++){
				if(deal(nuM,deN)){
					num*=nuM;
					den*=deN;
				}
			}
		}
		System.out.println(num+"/"+den);

	}
	public static boolean deal(int a, int b){
		int aa=a;
		int bb=b;
		int a1=a/10;
		int a2=a%10;
		int b1=b/10;
		int b2=b%10;
		double org=(double)a/b;
		if(a1==b2){
			a=a2;
			b=b1;
		}else if(a2==b1){
			a=a1;
			b=b2;
		}else{
			return false;
		}
		if(b!=0 && a!=0 && (double)a/b==org && a<b){
			System.out.println(aa+"/"+bb);
			return true;
		}	
		return false;
	}

}
