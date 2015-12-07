
public class PE31 {
	public static void main(String[] args){
		long num=0;
		for(int thp=0; thp<=1; thp++){
			for(int ohp=0; ohp<=2; ohp++){
				for(int fiftp=0; fiftp<=4; fiftp++){
					for(int twtp=0; twtp<=10; twtp++){
						for(int tp=0; tp<=20; tp++){
							for(int fifp=0; fifp<=40; fifp++){
								for(int twp=0; twp<=100; twp++){
									for(int op=0; op<=200; op++){
										if(200*thp+100*ohp+50*fiftp+20*twtp+10*tp+5*fifp+2*twp+op==200)
											num++;
								}
							}
						}
					}
				}
			}
		}
	}
		System.out.println(num);
	}
}
