package BOJ;

import java.util.Scanner;

public class BJO_15686 {
	static int N;
	static int M;
	static int empty=0, home=1, ch=2;
	static int min_ch = 1000000000;
	static int[][] Map = new int[50][50];
	static int[] flag = new int[13];
	static int[][] ch_index =new int[13][2];
	static int ch_num=0;
	
	static int cul_ch(){
		int[][] ch_Map =new int[N][N];
		
		for(int r=0; r<N;r++) {
			for(int c=0; c<N; c++) {
				if(Map[r][c]==1) ch_Map[r][c]=100000;
				else ch_Map[r][c]=0;
			}
		}
		for(int i=0; i<ch_num; i++) {
			if(flag[i]==1) {
				for(int r=0; r<N;r++) {
					for(int c=0; c<N; c++) {
						if(Map[r][c]==1) {
							int r1 = Math.abs(ch_index[i][0] - r);
							int c1 = Math.abs(ch_index[i][1] - c);
							if(ch_Map[r][c]>r1+c1) ch_Map[r][c]=r1+c1;
						}
					}
				}
			}
		}
		int total_ch=0;
		for(int r=0; r<N;r++) {
			for(int c=0; c<N; c++) {
				total_ch+=ch_Map[r][c];
			}
		}
		return total_ch;
	}
	static void dfs(int depth,int last_num) {
		if(depth == M) {
			int total_ch = cul_ch();
			if(min_ch >total_ch) min_ch = total_ch;
			return;
		}
		for(int i=last_num; i<ch_num; i++) {
			flag[i]=1;
			dfs(depth+1,i+1);
			flag[i]=0;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		for(int i =0; i<N; i++)
			for(int j =0; j<N; j++) {
				Map[i][j] = sc.nextInt();
				if(Map[i][j]==2) {
					ch_index[ch_num][0]=i;
					ch_index[ch_num][1]=j;
					ch_num++;
				}
			}
		dfs(0,0);
		System.out.println(min_ch);
		
	}
}
