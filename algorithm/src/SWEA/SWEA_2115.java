package SWEA;

import java.util.Scanner;

public class SWEA_2115 {
	static int M,N,C, max_cost;
	static int[][] map = new int[10][10];
	static int[][] man= new int[2][2];
	
	static int max;
	static int[] flag = new int[5];
	static int[] list = new int[5];
	
	static void dfs(int depth, int last,int current_C) {
		if(current_C >C || depth > M)
			return;
		
		int sum=0;
		for(int i=0; i<M;i++) {
			if(flag[i]==1) sum += list[i]*list[i];
		}
		if(max <sum) 
			max=sum;
			
		
		for(int i=last; i<M;i++) {
			flag[i]=1;
			dfs(depth+1,i+1, current_C+list[i]);
			flag[i]=0;
		}
	}
	
	static void cal_cost() {
		
		//man1
		for(int i=0; i<5; i++)flag[i]=0;
		for(int i=0; i<M; i++) list[i]= map[man[0][0]][man[0][1]+i];
		dfs(0,0,0);
		int max1=max;
		max =0;
	
		//man2
		for(int i=0; i<5; i++) flag[i]=0;
		for(int i=0; i<M; i++) list[i]= map[man[1][0]][man[1][1]+i];
		dfs(0,0,0);
		int max2=max;
		max =0;
		
		if(max1+max2 >max_cost) max_cost = max1+max2;
	}
	
	
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			max_cost =0;
			
			for(int i=0; i<2; i++)
				for(int j=0; j<2; j++)
					man[i][j] = -1;
			
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					map[i][j] = sc.nextInt();
			
			for(int i1 =0; i1 < N;i1++) {
				for(int j1= 0; j1<=N-M; j1++) {
					man[0][0]=i1;
					man[0][1]=j1;
					
					for(int i2= i1; i2<N; i2++) {
						man[1][0]=i2;
						if(i2>i1)
							for(int j2 =0; j2<=N-M; j2++) {
								man[1][1]=j2;
								cal_cost();						
							}
						else
							for(int j2 =j1+M; j2<=N-M; j2++) {
								man[1][1]=j2;
								cal_cost();
							}
					}
				}
			}
			
			
			
			System.out.println("#"+test_case+" "+max_cost);
		}
	}
}
