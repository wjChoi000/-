package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_5656 {
	static int N,W, H, Min=10000;
	static int[][] Map = new int[15][12];
	static int[][] dumy_Map= new int[15][12];
	static int[] list_N = new int[4];
	
	
	static int count() {
		int num=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++)
				if(dumy_Map[i][j]>0)
					num++;
		}
		
		return num;
	}
	
	static void ball(int w) {
		
		int i,j =w;
		
		for(i=0; i<H; i++) {
			if(dumy_Map[i][j]>0)
				break;
		}
		if( i<H) {
			Stack<Integer[]> st = new Stack<>();
			Integer[] t = {i,j};
			st.push(t);
			while(!st.isEmpty()) {
				t = st.pop();
				
				i = t[0];
				j= t[1];
				for(int k=1; k<dumy_Map[i][j]; k++) {
					//위로
					if(i-k>=0) {
						Integer[] a = {i-k,j};
						st.push(a);
					}
					
					//아래로
					if(i+k  <H) {
						Integer[] a = {i+k,j};
						st.push(a);
					}
					//외쪽
					if(j-k>=0){
						Integer[] a = {i,j-k};
						st.push(a);
					}
					//오른쪽
					if(j+k <W) {
						Integer[] a = {i,j+k};
						st.push(a);
					}
				}
				dumy_Map[i][j]=0;
			}		
		
								
			//내려앉기
			for(j=0; j <W; j++) {
				for(i=H-1; i>0; i--) {
					if(dumy_Map[i][j]==0) {
						for(int k=i-1; k>=0;k--) {
							if(dumy_Map[k][j]>0) {
								dumy_Map[i][j] = dumy_Map[k][j];
								dumy_Map[k][j]=0;
								break;
							}
						}
					}
				}
			}
			
			
		}
	}
	
	static void dfs(int depth) {
		if(depth==N) {
			for(int i=0; i<15; i++)
				for(int j=0; j<12; j++)
					dumy_Map[i][j] = Map[i][j];
			
			for(int i =0; i<N; i++) {
				ball(list_N[i]);
			}
			int num = count();
			
			if(Min>num) {
				Min = num;
			}
			return;
		}
		for(int j=0; j<W;j++) {
			list_N[depth]=j;
			dfs(depth+1);
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N= sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			Min= 10000;
			for(int i=0; i<15; i++)
				for(int j=0; j<12; j++)
					Map[i][j] = 0;
			
			for(int i=0; i<H; i++)
				for(int j=0; j<W; j++)
					Map[i][j] = sc.nextInt();
			
			
			dfs(0);
			
			System.out.println("#"+test_case+" "+Min);
		}
	}
}
