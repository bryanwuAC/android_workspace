
public class merge1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int arr1[]={1,4,8,10,15,46};
			int arr2[]={2,3,7,12,15,48};
		    int result[]=new int[arr1.length+arr2.length];
			int total=arr1.length+arr2.length;
			int p1=0;
			int p2=0;
			for(int i=0;i<total;i++){
				if (arr1[p1]<=arr2[p2]){
					result[i]=arr1[p1];
					p1++;
				}else{
					result[i]=arr2[p2];
					p2++;
				}
			}
			for (int j=0; j<total;j++){
				System.out.print(result[j]+",");
			}
		}

	}

