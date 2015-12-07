public class PE20 {
  public static void main(String[] args){
	  int[] result=new int[200];
	  result[0]=1;
	  for(int i=2; i<101; i++){
		  result=multiple(result, convert(i));
	  }
	  int sum=0;
	  for(int i=0; i<result.length; i++)
		  sum+=result[i];
	  System.out.println(sum);
  }
  public static int[] convert(int num){
	  int[] a=new int[3];
	  int index=0;
	  while(num>0){
		  a[index]=num%10;
		  num/=10;
		  index++;
	  }
	  return a;
  }
  public static int[] multiple(int[] a, int[] b){
	  int[] c=new int[a.length+b.length];
	  for(int i=0; i<a.length; i++){
		  for(int j=0; j<b.length; j++){
			  c[i+j]+=a[i]*b[j];
		  }
	  }
	  for(int i=0; i<a.length+b.length; i++)
		  if(c[i]>=10){
			  c[i+1]+=c[i]/10;
			  c[i]%=10;
		  }
	  return c;
	  
  }
}
