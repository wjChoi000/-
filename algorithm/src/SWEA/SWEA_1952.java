package SWEA;

import java.util.Scanner;

public class SWEA_1952 {
	static int[] Schedule= new int[12];
	static int[][] Fare = new int[4][2];
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			for(int i=0; i<4; i++) {
				Fare[i][0]=sc.nextInt();
			}
			Fare[0][1]=1;
			Fare[1][1]=1;
			Fare[2][1]=3;
			
			for(int i=0; i<12; i++) {
				Schedule[i] = sc.nextInt();
			}
			
			int[] price = new int[16];
			for(int i=1; i<16; i++)
				price[i]=3000;
			price[12]= Fare[3][0];
			for(int i=0; i<12; i++) {
					for(int j=0; j<3; j++) {
						
						int new_price = Fare[j][0];
						if(j==0)
							new_price *=Schedule[i];
						new_price += price[i];
						if(price[i+Fare[j][1]] >new_price)
							price[i+Fare[j][1]]=new_price;
						
					}
				
			}
		
			
			System.out.println("#"+test_case+" "+price[12]);
		}
	}
}
