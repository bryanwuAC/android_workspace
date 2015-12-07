
public class InsertionSort {
	public static void insertionsort(int[] arr,int lo,int hi){
		if(lo<hi){
			insertionsort(arr, lo, hi-1);
			insertInOrder(arr, lo, hi);
		}
	}
	public static void insertInOrder(int[] arr,int lo, int hi){
		if(lo<hi && arr[hi]<arr[hi-1]){
			swap(arr, hi-1, hi);
			insertInOrder(arr, lo, hi-1);
		}
	}
	public static void swap(int[] arr, int a, int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void main(String[] args){
		int[] a={1,5,26,4,2,3,4,6,3};
		insertionsort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
	}

}
