
public class PE25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a=new int[1000];
		int[] b=new int[1000];
		a[999]=1;
		b[999]=1;
		int index=2;
		int[] c=new int[1000];
		while(c[0]==0){
			index++;
			c=sum(a,b);
			a=b;
			b=c;
		}
		System.out.println(index);

	}
	public static int[] sum(int[] a, int[] b){
		int[] result=new int[1000];
		int mark=0;
		int temp=0;
		for(int i=999; i>=0; i--){
			temp=a[i]+b[i]+mark;
			mark=0;
			if(temp>=10){
				mark=1;
				temp%=10;
			}
			result[i]=temp;
		}
		return result;
	}

}
