package algorithm;

import java.util.Scanner;

public class Sumsung_14499 {

	static Scanner scan;
	
	final static int EAST = 1;
	final static int WEST =2;
	final static int SOUTH = 3;
	final static int NORTH = 4;
	
	final static int TOP =0;
	final static int BOTTOM = 5;
	
	
	static int[][] dice = new int[4][3];
	static int x;
	static int y;
	static int N = 0;
	static int M = 0;
	public static void main(String str[]) {
		
		
		//input
		scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		x = scan.nextInt();
		y = scan.nextInt();
		
		int K = scan. nextInt();
		
		int[][] map = new int[N][M];
		int i,j;
		
		for(i=0; i<N;i++) {
			for(j=0; j<M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		int[] kList = new int[K];
		for(i=0 ; i<K; i++) {
			kList[i] = scan.nextInt();
		}
		for(i=0; i<4; i++)
			for(j=0; j<3; j++)
				dice[i][j] =0;
		
		// solution
		for(i=0; i<K; i++) {
			moveDice(map, kList[i]);
		}
	}
	
	static void moveDice(int[][] map, int dir) {
		boolean flag = true;
		int temp;
		switch(dir) {
		case EAST:
			y++;
			if (y>=M) {
				flag = false;
				y--;
				break;
			}
			temp = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = temp;
			
			break;
		case WEST:
			y--;
			if(y<0) {
				flag = false;
				y++;
				break;
			}
			temp = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = temp;
			
			
			break;
		case NORTH:
			x++;
			if(x>=N) {
				flag = false;
				x--;
				break;
			}
			// dice ¿Ãµø
			temp = dice[0][1];
			dice[0][1] = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = temp;
			
			break;
		case SOUTH:
			x--;
			if(x <0) {
				flag = false;
				x++;
				break;
			}
			
			temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
			break;
		}
		
		if(flag) {
//			System.out.println(x+","+y);
			if(map[x][y] == 0) {
				map[x][y] = dice[3][1];
			}else {
				dice[3][1] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[1][1]);
		}
	}
	
}
