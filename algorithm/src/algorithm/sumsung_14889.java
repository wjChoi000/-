package algorithm;

import java.util.Scanner;

public class sumsung_14889 {
	static int[][] score;
	static int N;
	static int dif =100000;
	static int[][] visited;
	
//	void dfs(int c, int[] list, int teamNumber) {
//		if(teamNumber >= N/2) {
//			int sumS=0, sumL = 0;
//			for(int i =0; i<teamNumber; i++) {
//				//sumS += score[[li]]
//			}
//			
//			int cdif = Math.abs(sumS-sumL);
//			if(cdif <dif) {
//				dif = cdif;
//			}
//		}
//		else {
//			for(int i =0; i<N; i++) {
//				if(visited[c][i] ==0) {
//					
//					
//					visited[c][i]=1;
//				
//					dfs(i)
//				}			
//			}
//		}
//	}
//	
//	public static void main(String args[]) {
//		Scanner scan = new Scanner(System.in);
//		N = scan.nextInt();
//		score = new int[N][N];
//		visited = new int[N][N];
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				score[i][j] = scan.nextInt();
//				visited[i][j]=0;
//			}
//			score[i][i]=0;
//			visited[i][i]=1;
//		}
//		
//		
//		System.out.println(dif);
//	}
}
