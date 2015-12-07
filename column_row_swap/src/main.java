
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sidelength=0;
		int counter=1;
		int temp=0;
		while(sidelength<=0){
			System.out.println("Please input the length of the matrix:");
			sidelength=TextIO.getInt();
			}
		int a[][]=new int[sidelength][sidelength];
		System.out.println("The original one is:");
		for(int i=0; i<sidelength; i++){
			for(int j=0;j<sidelength; j++){
				a[i][j]=counter;
				System.out.print(a[i][j]+" ");
				counter++;
			}
			System.out.println("");
		}
		System.out.println("The result is:");
		for(int i=0;i<sidelength;i++){
			for(int j=i;j<sidelength;j++){
				temp=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=temp;
			}
		}
		for(int i=0; i<sidelength; i++){
			for(int j=0; j<sidelength; j++){
				System.out.print(a[i][j]+" ");
				}
			System.out.println("");
		}

	}

}
