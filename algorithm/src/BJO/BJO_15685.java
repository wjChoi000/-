package BJO;

import java.util.Scanner;

public class BJO_15685 {

	static int N;
	static int[][] dragon = new int[N][4];
	static int[][][] Map = new int[101][101][2]; // 0 X++ / 1 Y++
	
	static int[] makeZero(int x,int y, int d) {
		//0세대 이면
		// 0 X++ / 1 Y++/ 2 X--/ 3 Y--;
		int[] end = new int[3];
		switch(d) {
		case 0:
			Map[y][x][0]= 1;
			end[1]=x+1;
			end[0]=y;
			end[2]=0;
			break;
		case 1:
			Map[y][x][1]=1;
			end[1]=x;
			end[0]=y+1;
			end[2]=1;
			break;
		case 2:
			Map[y][x-1][0]=1;
			end[1]=x-1;
			end[0]=y;
			end[2]=2;
			break;
		case 3:
			Map[y-1][x][1]=1;
			end[1]=x;
			end[0]=y-1;
			end[2]=3;
			break;
		}
		return end;
	}
	static int G;
	
	static int[] makeDragonCurve(int y ,int x, int d, int g) {	
		int[] end = {1,2,3,4};
		if(g==0) {
			end = makeZero(x,y,d);
		}
		else {
			end = makeDragonCurve(end[0],end[1],end[2],g-1);
			
		}
		if(g>0)
			makeDragonCurve(end[0],end[1],end[2],g-1);
		

		return end;
		
	}
	
	
	
	static int count_square() {
		int num=0;
		for(int i=0; i<100;i++) {
			for(int j =0; j<100; j++) {
				
				
			}
		}
		
		return num;
	}
	
	public static void main(String[] arg) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			for(int j=0; j<4;j++)
				dragon[i][j]=sc.nextInt();
		}
		for(int i=0; i<101; i++)
			for(int j =0; j<101; j++)
				for(int k=0; k<2; k++)
					Map[i][j][k]=0;
		
		
		
		
		System.out.println(count_square());
	}
}
