package SWEA;

import java.util.Scanner;

public class SWEA_1949 {
	
	static int N, K,Max;
	static int[][] Map, visited;
	static int high=0;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = { 0, 1, 0,-1};
	
	
	static void dfs(int depth,int i, int j ,int k) {
		if(depth>Max)
			Max = depth;
		
		for(int a=0; a<4; a++) {
			int ny = i-dy[a];
			int nx = j-dx[a];
			if(ny>=0&&ny<N &&nx>=0&& nx<N) {
				if(Map[i][j] >Map[ny][nx] &&visited[ny][nx] ==0) {
					visited[ny][nx]=depth;
					dfs(depth+1,ny,nx,k);
					visited[ny][nx]=0;
				}
				
				if(k<1) {
					for(int b=1; b<=K; b++) {
						Map[ny][nx] -=b;
						if(Map[i][j]>Map[ny][nx] && visited[ny][nx] ==0) {
							visited[ny][nx]=depth;
							dfs(depth+1,ny,nx,k+1);
							visited[ny][nx]=0;
						}
						Map[ny][nx] +=b;
					}
				}
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
			Max=0;
			N = sc.nextInt();
			K = sc.nextInt();
			Map = new int[N][N];
			visited= new int[N][N];
			high=0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					Map[i][j]=sc.nextInt();
					visited[i][j]=0;
					if(high<Map[i][j]) {
						high = Map[i][j];
					}
				}
			}
			for(int i=0; i<N;i++) {
				for(int j=0; j<N;j++) {
					if(Map[i][j]==high) {
						visited[i][j]=1;
						dfs(1, i,j,0);
						visited[i][j]=0;
					}
				}
			}
			
			
			
			System.out.println("#"+test_case+" "+Max);
		}
	}
}
