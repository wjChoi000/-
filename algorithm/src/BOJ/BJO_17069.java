package BOJ;

import java.util.Scanner;

public class BJO_17069 {
	static int N;
	static int[][] Map;
	static int[][] visited;
	static long num=0;
//	static void dfs(int i, int j, int d) {
//		if(i==N-1 && j==N-1) {
//			++num;
//			return;
//		}
//		
//		//세로 ,1
//		int ni = i+1, nj =j;
//		if(ni<N &&Map[ni][nj]==0  && d !=0){
//			dfs(ni,nj,1);
//		}
//		//가로
//		ni = i;
//		nj = j+1;
//		if(nj<N &&Map[ni][nj]==0&& d !=1){
//			dfs(ni,nj,0);
//		}
//		//대각선
//		ni= i+1;
//		nj= j+1;
//		if(nj <N &&ni<N &&Map[ni][nj]==0&&Map[ni][nj-1]==0&&Map[ni-1][nj]==0 ){
//			dfs(ni,nj,2);	
//		}
//		
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		Map = new int[N][N];

		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				Map[i][j] = sc.nextInt();
	
//		dfs(0,1,0);
		long[][][] dp = new long[3][N][N];
		
		int T = 2*(N-1);
		if(Map[0][2] ==0) {
			dp[0][0][2]=1;
			if(Map[1][1]==0 &&Map[1][2]==0)
				dp[2][1][2]=1;
		}
		for(int t=2; t<=T; t++) {
			//가로 0
			for(int n=0; n<=t; n++) {
				int i=n, j=t-n;
				if( i<N&&j<N&&dp[0][i][j]>0) {
					if(j+1<N && Map[i][j+1]==0) {
						dp[0][i][j+1] +=dp[0][i][j];
						if(i+1<N && Map[i+1][j+1]==0 && Map[i+1][j]==0)
							dp[2][i+1][j+1] +=dp[0][i][j];
					}
				}
			}
			//세로
			for(int n=0; n<=t; n++) {
				int i=n, j=t-n;
				if(i<N&&j<N&&dp[1][i][j]>0) {
					if(i+1<N && Map[i+1][j]==0) {
						dp[1][i+1][j] += dp[1][i][j];
						if(j+1<N && Map[i][j+1]==0 && Map[i+1][j+1]==0)
							dp[2][i+1][j+1]+=dp[1][i][j];
					}
				}
			}
			//대각선
			for(int n=0; n<=t; n++) {
				int i=n, j=t-n;
				if(i<N&&j<N&&dp[2][i][j]>0) {
					if(j+1<N && Map[i][j+1] ==0) {
						dp[0][i][j+1] += dp[2][i][j];
					}
					if(i+1<N && Map[i+1][j]==0) {
						dp[1][i+1][j] += dp[2][i][j];
					}
					if(i+1<N && j+1<N &&Map[i][j+1]==0 &&Map[i+1][j]==0&&Map[i+1][j+1]==0)
						dp[2][i+1][j+1] +=dp[2][i][j];
				}
			}
			
		}
		
		
		System.out.println(dp[0][N-1][N-1]+dp[1][N-1][N-1]+dp[2][N-1][N-1]);
	}
}
