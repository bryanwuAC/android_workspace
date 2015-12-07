
public class test {
	 public static void main(String[] args){
		  int maxidx=9+90*2+3;
		  int index=-1;
		  int[] a=new int[maxidx],b=new int[maxidx],tempa=new int[maxidx];
		  index=0;a[index]=1;
		  
		  int temp,tempidx,c;
		  int[] tt=new int[3];
		  
		  for(int i=2;i<=100;i++){
			  temp=i;tempidx=-1;for(int j=0;j<maxidx;j++)tempa[j]=0;
			  while(temp>0){tempidx++;tt[tempidx]=temp%10;temp/=10;}
			  for(int j=0;j<=tempidx;j++){
				  c=0;
				  for(int k=0;k<=index;k++){b[k]=a[k]*tt[j]+c;c=b[k]/10;b[k]=b[k]%10;}
				  if(c>0)b[++index]=c;
				  
				  c=0;
				  for(int k=0;k<=index;k++){tempa[k+j]=tempa[k+j]+b[k]+c;c=tempa[k+j]/10;tempa[k+j]=tempa[k+j]%10;}
				  if(c>0)tempa[++index]=c;
				  index++;
			  }
			  while(tempa[index]==0){index--;}
			  for(int j=0;j<=index;j++)a[j]=tempa[j];
		  }
		  
	  temp=0;
	  for(int i=0;i<=index;i++)temp+=a[i];
	  System.out.print(temp+"\n");
		  
	  }
}
