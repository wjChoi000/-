package BOJ;

import java.util.Scanner;

public class BJO_15684 {
	static int N,M,H, Ladder=1;
	static int Max = -1;
	static int[][] Map = new int[31][12];
	static int[][] new_ladder = new int[5][2];
	static boolean ladder() {
		
		for(int j =1; j<=N; j++) {
			int n = j;
			for(int i=0; i<= H; i++) {
				if(Map[i][n]==Ladder) n++;
				else if(Map[i][n-1]==Ladder) n--;	
			}
			if( n != j)
				return false;
		}
		
		return true;
	}
	
	static void dfs(int depth, int i1, int j1) {
		if(depth>3)
			return;
		if(Max != -1 && Max <=depth)
			return;
//		for(int i =1; i<=depth; i++) {
//			System.out.print(new_ladder[i][0]+","+new_ladder[i][1] +" / ");
//		}
//		System.out.println("");
		if(ladder()) {
			if(Max == -1)
				Max =depth;
			else if(Max >depth)
				Max = depth;
			return;
		}
		for(int i=i1; i<=H; i++) {
			if(i >0)
				for(int j = j1; j<=N; j++) {
					if(j>0)
						if(Map[i][j] ==0 && Map[i][j-1]==0 && Map[i][j+1]==0) {
							Map[i][j]=Ladder;
							new_ladder[depth+1][0]=i;
							new_ladder[depth+1][1]=j;
							dfs(depth+1,i,j-1);
		
							Map[i][j]=0;
						}
				}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		for(int i=0; i< 31;i++)
			for(int j =0; j<12; j++)
				Map[i][j]=0;
		
		for(int i=0; i<M; i++) {
			int a= sc.nextInt();
			int b =sc.nextInt();
			Map[a][b] = Ladder;
		
		}
		new_ladder[0][0]=1;
		new_ladder[0][1]=1;
		dfs(0,1,1);
		System.out.println(Max);
		
	}
}
