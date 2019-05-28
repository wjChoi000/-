package BOJ;

import java.util.Scanner;

public class BJO_14499 {
	static int N,M, x,y,K;
	static int[][] Map = new int[20][20];
	static int[] list_K = new int[1000];
	static int[][] dise = new int[4][3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M= sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();
		
		
		for(int i=0; i<N;i++)
			for(int j=0; j<M; j++)
				Map[i][j]=sc.nextInt();
		for(int i=0; i<K; i++)
			list_K[i]=sc.nextInt();
		
		for(int i=0; i<4;i++)
			for(int j=0;j<3; j++)
				dise[i][j]=0;
		
		for(int k=0; k<K; k++) {
			int temp=0;
			boolean flag= false;
			switch(list_K[k]) {
			//µ¿
			case 1:
				if(y<M-1) {
					flag=true;
					temp=dise[1][0];
					dise[1][0] =dise[3][1];
					dise[3][1] = dise[1][2];
					dise[1][2] = dise[1][1];
					dise[1][1] = temp;
					y++;
					
				}
				break;
			//¼­
			case 2:
				if(y>0) {
					flag=true;
					temp = dise[1][0];
					dise[1][0] =dise[1][1];
					dise[1][1] = dise[1][2];
					dise[1][2] = dise[3][1];
					dise[3][1] = temp;
					y--;
				}
				break;
			//³²
			case 3:
				if(x>0) {
					flag=true;
					temp = dise[0][1];
					dise[0][1] =dise[1][1];
					dise[1][1] = dise[2][1];
					dise[2][1] = dise[3][1];
					dise[3][1] = temp;
					x--;
				}
				break;
			//ºÏ	
			case 4:
				if(x<N-1) {
					flag=true;
					temp = dise[0][1];
					dise[0][1] =dise[3][1];
					dise[3][1] = dise[2][1];
					dise[2][1] = dise[1][1];
					dise[1][1] = temp;
					x++;
				}
				break;
			}
			if(flag) {
				if (Map[x][y]==0) {
					Map[x][y] =dise[3][1];
				}else {
					dise[3][1] = Map[x][y];
					Map[x][y]=0;
				}
				System.out.println(dise[1][1]);
			}
			
		}
	}
}
