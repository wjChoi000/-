package SWEA;

import java.util.Scanner;

public class SWEA_2382 {
	
	static int M,N,K;
	static int[][] list_K = new int[1001][4]; 
	
	static int sum_m() {
		int sum=0;
		for(int i =0; i<K;i++)
			sum += list_K[i][2];
		return sum;
	}
	static void move() {
		
		//2. move
		for(int i=0; i<K; i++) {
			if(list_K[i][2]>0) {
				switch(list_K[i][3]) {
				//╩С: 1, го: 2, аб: 3, ©Л: 4
				case 1:
					list_K[i][0]--;
					break;
				case 2:
					list_K[i][0]++;
					break;
				case 3:
					list_K[i][1]--;
					break;
				case 4:
					list_K[i][1]++;
					break;
				}
				//3. edge
				if(list_K[i][0]==0||list_K[i][0]==N-1) {
					list_K[i][2] = list_K[i][2]/2;
					if(list_K[i][3]==1)
						list_K[i][3]=2;
					else list_K[i][3]=1;
				}
				if(list_K[i][1]==0||list_K[i][1]==N-1) {
					list_K[i][2] =list_K[i][2]/2;
					if(list_K[i][3]==3)
						list_K[i][3]=4;
					else list_K[i][3]=3;
				}
			}
		}
		
		//4. merge
		for(int i=0 ; i<K-1; i++) {
			if(list_K[i][2] >0) {
				int max = list_K[i][2], dir = list_K[i][3];
				
				for(int j=i+1; j<K; j++) {
					if(list_K[j][2] >0) {
						if(list_K[i][0]==list_K[j][0] &&list_K[i][1]==list_K[j][1]) {
							if(max < list_K[j][2]) {
								max = list_K[j][2];
								dir = list_K[j][3];
							}
							list_K[i][2] += list_K[j][2];
							
							for(int r=0; r<4; r++) {
								list_K[j][r]=0;						
							}
		
						}
					}
				}
				list_K[i][3] = dir;
			}
		}
		
	}
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			N = sc.nextInt();
			M=sc.nextInt();
			K = sc.nextInt();

			
			for(int i=0; i<K; i++) {
				list_K[i][0] =sc.nextInt();
				list_K[i][1] = sc.nextInt();
				list_K[i][2] = sc.nextInt();
				list_K[i][3] = sc.nextInt();
				
			}
			
			
			for(int i =0; i<M;i++) {
				move();
//				System.out.println("#"+i+1);
//				for(int c=0; c<K; c++) {
//					for(int r=0; r<4; r++)
//						System.out.print(list_K[c][r]+" ");
//					System.out.println();
//				}
			}
			
			System.out.println("#"+test_case+" "+sum_m());

		}
	}
}

