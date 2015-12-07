
public class selection_sort {
	public static void main(String[] args) {
		int num=0;
		int min=0;
		System.out.println("Please input the capacity of the series:");
		num=TextIO.getlnInt();
		int a[]=new int[num];
		for (int i=0;i<num;i++){
			TextIO.putln("Please input the number:");
			a[i]=TextIO.getlnInt();
			System.out.println(" ");
		}
		for (int j=0;j<num;j++){
			min=j;                       //默认一趟最小的值为j 
			for(int k=j;k<num-1;k++){
				if (a[min]>a[k+1]){
					min=k+1;            //单趟最小值 
				}
				swap(a[min],a[j]);      //调用swap，交换序列第n个与单趟最小值。 
			}
		}
		for (int p=0;p<num;p++){
			TextIO.put(a[p]+" ");
		}
	}
	public static void swap(int a, int b){
		int temp=0;
		temp=a;
		a=b;
		b=temp;
	}
}
