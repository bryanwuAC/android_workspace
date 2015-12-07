
public class PE13 {
	public static void main(String args[]){
		String[] a=new String[100];
		String total="";
		int sum=0;
		int tens=0;
		a=readFile();
		for(int i=49; i>=0; i--){
			sum=0;
			for(int j=0; j<100; j++){
				int num=a[j].charAt(i)-48;
				sum+=num;
			}
			sum=sum+tens;
			total=(sum%10)+total;
			tens=sum/10;
		}
		System.out.println(tens+""+total);

	}
	public static String[] readFile(){
		String[] b=new String[100];
		TextIO.readFile("PE13_data");
		for(int i=0; i<100; i++){
			b[i]=TextIO.getln();
		}
		return b;
	}

}
