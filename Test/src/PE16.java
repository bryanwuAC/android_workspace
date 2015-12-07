
public class PE16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]=new int[1000];
		data[999]=1;
		for(int i=0; i<1000; i++){
			data=sum(data);
		}
		int sum=0;
		for(int i=0; i<1000; i++)
			sum+=data[i];
		System.out.println(sum);
	}
	public static int[] sum(int[] data){
		int[] result=new int[1000];
		int mark=0;
		int temp=0;
		for(int i=999; i>=0; i--){
			temp=data[i]*2+mark;
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
