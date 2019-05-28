package BOJ;

import java.util.Scanner;

public class BJO_14889 {

	static int N;
	static int[][] Map= new int[20][20];
	static int min_s= 10000000;
	static int[] flag = new int[20];
	
	static void dfs(int depth, int next) {
		if(depth== N/2) {
			//calculate s
			int[] team1 =new int[N/2];
			int[] team2 = new int[N/2];
			int t1=0,t2=0;
			for(int i=0; i<N; i++) {
				if(flag[i]==1) team1[t1++]=i;
				else team2[t2++]=i;
			}
			int s1=0,s2=0;
			for(int i=0; i<N/2-1; i++) {
				for(int j=i+1; j<N/2;j++) {
					s1 += Map[team1[i]][team1[j]]+Map[team1[j]][team1[i]];
					s2 +=Map[team2[i]][team2[j]]+Map[team2[j]][team2[i]];
				}
			}
			int dif = Math.abs(s1-s2);
			if(min_s >dif) min_s = dif;
			return;
		}
		for(int i=next; i<N;i++) {
			flag[i]=1;
			dfs(depth+1,i+1);
			flag[i]=0;
					
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			flag[i]=0;
			for(int j=0; j<N; j++)
				Map[i][j] = sc.nextInt();
		}
		flag[0]=1;
		dfs(1,1);
		
		System.out.println(min_s);
		
	}
}
