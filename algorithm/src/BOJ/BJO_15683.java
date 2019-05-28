package BOJ;

import java.util.Scanner;

public class BJO_15683 {
	static int N, M, Min =10000, C;
	static int[][] Map = new int[8][8], CCTV = new int[8][3];
	static int WALL = 6,SEE =-1;
	
	static int empty() {
		int num=0;
		for(int i =0; i<N;i++)
			for(int j =0; j<M; j++)
				if(Map[i][j]==0) num++;
		return num;
	}
	
	static void top(int i, int j) {
		
		for( int it =i-1; it>=0; it--) {
			if(Map[it][j]==WALL)
				break;
			if(Map[it][j]==0)
				Map[it][j]= SEE;
		}
	}
	
	static void bottom(int i, int j) {
		for( int it =i+1; it<N; it++) {
			if(Map[it][j]==WALL)
				break;
			if(Map[it][j]==0)
				Map[it][j]= SEE;
		}
	}

	
	
	static void right(int i, int j) {
		for( int jt =j+1; jt<M; jt++) {
			if(Map[i][jt]==WALL)
				break;
			if(Map[i][jt]==0)
				Map[i][jt]= SEE;
		}
	}

	static void left(int i, int j) {
		for( int jt =j-1; jt>=0; jt--) {
			if(Map[i][jt]==WALL)
				break;
			if(Map[i][jt]==0)
				Map[i][jt]= SEE;
		}
	}



	static void dfs(int depth) {
		if(depth >=C) {
			//감시
			for(int c=0; c<C; c++) {
				int i = CCTV[c][0], j=CCTV[c][1], dir = CCTV[c][2];
				switch(Map[i][j]) {
				case 1:
					switch(dir) {
					case 0:
						top(i,j);
						break;
					case 1:
						bottom(i,j);
						break;
					case 2:
						right(i,j);
						break;
					case 3:
						left(i,j);
						break;
					}
					break;
				case 2:
					switch(dir) {
					case 0:
						top(i,j);
						bottom(i,j);
						break;
					case 1:
						right(i,j);
						left(i,j);
						break;
					}
					break;
				case 3:
					switch(dir) {
					case 0:
						top(i,j);
						right(i,j);
						break;
					case 1:
						top(i,j);
						left(i,j);
						break;
					case 2:
						bottom(i,j);
						left(i,j);
						break;
					case 3:
						bottom(i,j);
						right(i,j);
						break;
					}
					break;
				case 4:
					switch(dir) {
					case 0:
						bottom(i,j);
						right(i,j);
						left(i,j);
						break;
					case 1:
						top(i,j);
						right(i,j);
						left(i,j);
						break;
					case 2:
						top(i,j);
						bottom(i,j);
						left(i,j);
						break;
					case 3:
						top(i,j);
						bottom(i,j);
						right(i,j);
						break;
					}
					break;
				case 5:
					top(i,j);
					bottom(i,j);
					right(i,j);
					left(i,j);
					break;
				}
			}
			
			
			int t = empty();
			if(t< Min)
				Min = t;
			//원상 복구
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++)
					if(Map[i][j]==SEE)
						Map[i][j]=0;
			}
			
			return;
		}

		int i =CCTV[depth][0], j = CCTV[depth][1];
		switch(Map[i][j]) {
		case 1:
			//한방향
			for(int k=0; k<4; k++) {
				CCTV[depth][2]=k;
				dfs(depth+1);
			}
			
			break;
		case 2:
			// 수직
			for(int k=0; k<2; k++) {
				CCTV[depth][2]=k;
				dfs(depth+1);
			}
			break;
		case 3:
			//직각
			for(int k=0; k<4; k++) {
				CCTV[depth][2]=k;
				dfs(depth+1);
			}
			break;
		case 4:
			//삼방향
			for(int k=0; k<4; k++) {
				CCTV[depth][2]=k;
				dfs(depth+1);
			}
			break;
		case 5:
			//전 방향
			CCTV[depth][2]=0;
			dfs(depth+1);
					
			break;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		C=0;
		for(int i =0; i<N; i++)
			for(int j=0; j<M; j++) {
				Map[i][j] = sc.nextInt();
				if(Map[i][j]>0 && Map[i][j] <6) {
					CCTV[C][0]=i;
					CCTV[C][1]=j;
					C++;
				}
			}

		dfs(0);
		
		System.out.println(Min);
	}
}
