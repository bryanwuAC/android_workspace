
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
			min=j;                       //Ĭ��һ����С��ֵΪj 
			for(int k=j;k<num-1;k++){
				if (a[min]>a[k+1]){
					min=k+1;            //������Сֵ 
				}
				swap(a[min],a[j]);      //����swap���������е�n���뵥����Сֵ�� 
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
