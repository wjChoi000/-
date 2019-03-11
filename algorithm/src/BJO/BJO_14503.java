package BJO;

import java.util.Scanner;

public class BJO_14503 {
	static int N,M,r,c,d;
	static int[][] Map = new int[52][52];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		r=sc.nextInt();
		c= sc.nextInt();
		d = sc.nextInt();
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				Map[i][j] = sc.nextInt();
		
		
		int count =0;
		while(true) {
			if(Map[r][c]==0) {
				Map[r][c] = 2;
				count++;
			}
			boolean flag =false;
			;
			
			for(int i=0; i<4;i++) {
				d--;
				switch(d) {
				//ºÏ
				case 0:
					if(Map[r-1][c]==0) {
						flag = true;
						r--;
					}
					break;
				//µ¿
				case 1:
					if(Map[r][c+1]==0) {
						flag = true;
						c++;
					}
					break;
				//³²
				case 2:
					if(Map[r+1][c]==0) {
						flag =true;
						r++;
					}
					break;
				//¼­
				case -1:
					d=3;
					if(Map[r][c-1]==0) {
						flag=true;
						c--;
					}
					break;
				}
				
				if(flag)
					break;
			}
			boolean flag2 = false;
			if(!flag) {
				switch(d) {
				case 0:
					if(Map[r+1][c]==1)
						flag2=true;
					else
						r++;
					break;
				case 1:
					if(Map[r][c-1]==1)
						flag2=true;
					else
						c--;
					break;
				case 2:
					if(Map[r-1][c]==1)
						flag2=true;
					else
						r--;
					break;
				case 3:
					if(Map[r][c+1]==1)
						flag2=true;
					else
						c++;
					break;
				}
			}
			if(flag2) break;
			
		}
		
//		Map[r][c] = d+5;
//		System.out.println();
//		for(int i =0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(Map[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(count);
		
		
	}
}
