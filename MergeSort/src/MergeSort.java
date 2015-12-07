
public class MergeSort {
	public static int[] data={9,8,7,6,5,4,3,2};
	public static void main(String args[]){
		mergeSort(data, 0, data.length-1);
		for(int i=0; i<data.length; i++)
			System.out.print(" "+data[i]);
	}
	public static void mergeSort(int[] data, int lo, int hi){
		if(lo>=hi)
			return;
		int mid=(lo+hi)/2;
		mergeSort(data,lo,mid);
		mergeSort(data,mid+1,hi);
		int size=hi-lo+1;
		int[] temp=new int[size];
		merge(data,temp,lo,mid+1,hi);
		for(int i=0; i<size; i++)
			data[i+lo]=temp[i];
		
		
	}
	public static void merge(int[] a, int[] temp, int lower, int mid ,int upper){
		int tempIndex=0;
		int leftLo=lower;
		int leftHi=mid-1;
		int rightLo=mid;
		int rightHi=upper;
		while(leftLo<=leftHi && rightLo<=rightHi){
			if(a[leftLo]<a[rightLo]){
				temp[tempIndex]=a[leftLo];
				leftLo++;
				tempIndex++;
			}else{
				temp[tempIndex]=a[rightLo];
				rightLo++;
				tempIndex++;
			}
		}
		while(leftLo<=leftHi)
			temp[tempIndex++]=a[leftLo++];
		while(rightLo<=rightHi)
			temp[tempIndex++]=a[rightLo++];
	}

}
