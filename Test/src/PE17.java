
public class PE17 {
	public static void main(String[] args){
		int sum=11;
		int ones=0;
		int tens=0;
		int hund=0;
		for(int i=0; i<10; i++){
			for(int j=0; j<100; j++){
				hund=j==0 || i==0 ?getHundreds(i):getHundreds(i)+3;
				ones=j%10;
				tens=j/10;
				if(tens==1)
					sum+=getTensSpecial(j)+hund;
				else
					sum+=getOnes(ones)+getTens(tens)+hund;
			}
		}
		System.out.println(sum);
		
	}
	public static int getOnes(int a){
		switch(a){
		case 0: return 0;
		case 1: return 3;
		case 2: return 3;
		case 3: return 5;
		case 4: return 4;
		case 5: return 4;
		case 6: return 3;
		case 7: return 5;
		case 8: return 5;
		case 9: return 4;
		}
		return 0;
	}
	public static int getTens(int a){
		switch(a){
		case 0: return 0;
		case 2: return 6;
		case 3: return 6;
		case 4: return 5;
		case 5: return 5;
		case 6: return 5;
		case 7: return 7;
		case 8: return 6;
		case 9: return 6;
		}
		return 0;
	}
	public static int getTensSpecial(int a){
		switch(a){
		case 10: return 3;
		case 11: return 6;
		case 12: return 6;
		case 13: return 8;
		case 14: return 8;
		case 15: return 7;
		case 16: return 7;
		case 17: return 9;
		case 18: return 8;
		case 19: return 8;
		}
		return 0;
	}
	public static int getHundreds(int a){
		switch(a){
		case 0: return 0;
		case 1: return 10;
		case 2: return 10;
		case 3: return 12;
		case 4: return 11;
		case 5: return 11;
		case 6: return 10;
		case 7: return 12;
		case 8: return 12;
		case 9: return 11;
		}
		return 0;
	}
}
