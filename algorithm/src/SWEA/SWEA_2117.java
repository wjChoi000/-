package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_2117 {
	
	static int N,M;
	static int[][] Map;
	static int[] Operation;
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = { 0,-1, 1, 0};
	static int price(int K, int m) {
		return m*M -Operation[K];
	}
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N= sc.nextInt();
			M= sc.nextInt();
			Map = new int[N][N];
			Operation = new int[N*2+1];
			int Max_Home=0, Max_Price=0;
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					Map[i][j] = sc.nextInt();
			
			
			for(int K=1;K<=N*2; K++)
				Operation[K] = K * K + (K - 1) * (K - 1);
			for(int i=0; i<N;i++) {
				for(int j=0; j<N; j++) {
					int[][] visited = new int[N][N];
					
					int m=0;
					visited[i][j]=1;
					Queue<Integer[]> que = new LinkedList<>();
					Integer[] q = {i,j,1};
					que.add(q);
					
					int t=1;
					while(!que.isEmpty()) {
						q = que.remove();

						if(q[2]>t) {
							int price = price(t,m);
							t++;
							if( price>=0 &&Max_Home < m) {
								Max_Home=m;
							}
						}
						m += Map[q[0]][q[1]];
						for(int a=0; a<4;a++) {
							int ny = q[0]+dy[a];
							int nx = q[1]+dx[a];
							if(ny>=0 && ny<N && nx>=0 && nx<N && visited[ny][nx]==0) {
								Integer[] nq = {ny,nx,q[2]+1};
								que.add(nq);
								visited[ny][nx]=1;
							}
						}
					}
					int price = price(t,m);
						t++;
						if( price>=0 &&Max_Home < m) {
							Max_Home=m;
						}
				}
			}
			
			System.out.println("#"+test_case+" "+Max_Home);
		}
	}
}
