package SWEA;

import java.util.Scanner;

public class SWEA_2105 {
	static int N, Max =-1;
	static int[][] Map =new int[100][100];
	static int[][] visited = new int[100][100];
	static int[] eated = new int[101];
	static int[][] list = new int[101][2];
	
	static void p(int depth) {
//		for(int i=0 ; i<101;i++) {
//			if(eated[i]==1)
//				System.out.print(i+" ");
//		}
//		System.out.println("");
//		for(int i=0; i<depth; i++) {
//			System.out.print(list[i][0]+","+list[i][1]+"->");
//		}
//		
//		System.out.println();
//		for(int i=0 ; i<N;i++){
//			for(int j=0; j<N;j++) {
//				System.out.print(visited[i][j]+"("+Map[i][j]+")"+" ");
//			}
//			System.out.println();
//		}
//		for(int i=0 ; i<N;i++){
//			for(int j=0; j<N;j++) {
//				if(visited[i][j]==1) {
//					System.out.print(Map[i][j]+" ");	
//				}
//				
//			}
//		}
//		
//		System.out.println();
	}
	static void dfs(int depth,int i, int j,int s_i, int s_j, int c,int num) {
		
		if(depth>(N*N+1)/2 || num>4)
			return;
		//ÁÂ»ó
		if(i>0 &&j>0) {
			if( s_i==i-1 && s_j== j-1 &&depth>3) {
				if(Max<depth) {
					Max = depth;
					p(depth);
				}
			}else if(eated[ Map[i-1][j-1] ] ==0 &&visited[i-1][j-1]==0 ) {
				list[depth][0]=i-1;
				list[depth][1]=j-1;
				
				int new_num = num;
				if(c !=1)
					new_num++;
				
				visited[i-1][j-1]=1;
				eated[Map[i-1][j-1]]=1;
				dfs(depth+1,i-1,j-1,s_i,s_j,1,new_num);
				visited[i-1][j-1]=0;
				eated[Map[i-1][j-1]]=0;
			}
		}
		//¿ì»ó
		if(i>0 &&j<N-1) {
			if( s_i==i-1 && s_j== j+1&&depth>3) {
				if(Max<depth) {
					Max = depth;
					p(depth);
				}
			}else if(eated[ Map[i-1][j+1] ] ==0 &&visited[i-1][j+1]==0) {
				list[depth][0]=i-1;
				list[depth][1]=j+1;
				
				int new_num = num;
				if(c !=2)
					new_num++;
				
				visited[i-1][j+1]=1;
				eated[Map[i-1][j+1]]=1;
				dfs(depth+1,i-1,j+1,s_i,s_j,2,new_num);
				visited[i-1][j+1]=0;
				eated[Map[i-1][j+1]]=0;
			}
		}
		//¿ìÇÏ
		if(i<N-1 &&j<N-1) {
			if( s_i==i+1 && s_j== j+1&&depth>3) {
				if(Max<depth) {
					Max = depth;
					p(depth);
				}
			}else if(eated[ Map[i+1][j+1] ] ==0 &&visited[i+1][j+1]==0 ) {
				list[depth][0]=i+1;
				list[depth][1]=j+1;
				
				int new_num = num;
				if(c !=3)
					new_num++;
				
				visited[i+1][j+1]=1;
				eated[Map[i+1][j+1]]=1;
				dfs(depth+1,i+1,j+1,s_i,s_j,3,new_num);
				visited[i+1][j+1]=0;
				eated[Map[i+1][j+1]]=0;
			}
		}
		//ÁÂÇÏ
		if(i<N-1 &&j>0) {
			if( s_i==i+1 && s_j== j-1&&depth>3) {
				if(Max<depth) {
					Max = depth;
					p(depth);
				}
			}else if(eated[ Map[i+1][j-1] ] ==0&&visited[i+1][j-1]==0)  {
				list[depth][0]=i+1;
				list[depth][1]=j-1;
				
				visited[i+1][j-1]=1;
				eated[Map[i+1][j-1]]=1;
				
				int new_num = num;
				if(c !=4)
					new_num++;
				dfs(depth+1,i+1,j-1,s_i,s_j,4,new_num);
				visited[i+1][j-1]=0;
				eated[Map[i+1][j-1]]=0;
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
			N = sc.nextInt();
			Max = -1;
			for(int i=0 ; i<N; i++)
				for(int j=0; j<N; j++) {
					Map[i][j]=sc.nextInt();
					visited[i][j] =0;
				}
			for(int i=0; i< 101; i++)
				eated[i]=0;
			
			for(int i=0 ; i<N; i++)
				for(int j=0; j<N; j++) {
					visited[i][j]=1;
					eated[Map[i][j]]=1;
					
					list[0][0]=i;
					list[0][1]=j;
					
					dfs(1,i,j,i,j, -1,0);
					
					visited[i][j]=0;
					eated[Map[i][j]]=0;

				}
			System.out.println("#"+test_case+" "+Max);
			
		}
	}
}
