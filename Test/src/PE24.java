
public class PE24 {

	/**
	 * @param args
	 */
	public static boolean[] a=new boolean[10];
	public static void main(String[] args) {
		int length=9;
		String result="";
		int total=1000000-1;
		for(int i=0; i<10; i++){
			a[i]=true;
		}
		while(length>0){
			int num=0;
			int fact=factorial(length);
			num=total/fact+1;
			total=total%fact;
			result+=""+findnumber(num);
			length--;
		};
		System.out.println(result);

	}
	public static int findnumber(int num){
		int count=0;
		for(int i=0; i<10; i++){
			if(a[i]){
				count++;
			}
			if(count==num){
				a[i]=false;
				return i;
			}
		}
		return -1;
	}
	public static int factorial(int num){
		int result=1;
		for(int i=1; i<num+1; i++){
			result*=i;
		}
		return result;
	}

}
