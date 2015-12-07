

public class PE15 {
	public static void main(String[] args){
		long[][] a=new long[22][22];
		int m=1;
		int n=1;
		for(int i=0; i<21; i++){
			a[i][0]=1;
			a[0][i]=1;
		}
		while(m<21 || n<21){
			if(m>21){
				m=1;
				n++;
			}
			a[m][n]=a[m-1][n]+a[m][n-1];
			m++;
		}
		for(int i=0; i<21; i++){
			for(int j=0; j<21; j++){
				System.out.print("	"+a[i][j]);
			}
			System.out.println("");
		}
	}
}

