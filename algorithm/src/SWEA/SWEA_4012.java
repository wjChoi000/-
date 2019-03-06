package SWEA;

import java.util.Scanner;

public class SWEA_4012 {
	
	static int N;
	static int[] flag;
	static int min_sig;
	static int[][] table;
	
	public static void cal_sig() {
		int[] list = new int[N/2];
		int[] olist = new int[N/2];
		int i1=0,i2=0;
		for(int i =0; i<N;i++) {
			if(flag[i]==1) { list[i1++] = i;
			}
			else{
				olist[i2++]=i;
			}
		}
		int current_sig= 0;
		int opp_sig = 0;
		for(int i =0; i<N/2-1; i++) {
			for(int j=i+1; j<N/2;j++) {
				current_sig +=table[list[i]][list[j]]+table[list[j]][list[i]];
				opp_sig+=table[olist[i]][olist[j]]+table[olist[j]][olist[i]];
			}
		}
		int cmin_sig = Math.abs(opp_sig - current_sig);
		if( min_sig> cmin_sig) min_sig = cmin_sig;
	}
	
	public static void dfs(int count,int last) {
		if(N/2 == count) {
			cal_sig();
			return;
		}
		// 중복 최소화가 중요
		for(int i=last; i<N;i++) {
			if(flag[i] == 0) {
				flag[i] = 1;
				dfs(count+1,i+1);
				flag[i]=0;
			}
		}
	}
	
	
	public static void main(String[] str) {		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			flag = new int[N];
			min_sig =100000000;
			table = new int[N][N];
			
			for(int i =0; i<N; i++) {
				flag[i]=0;
				for(int j =0; j<N; j++) {
					table[i][j]= sc.nextInt();
				}
			}
			
			flag[0]=1;
			dfs(1,1);
			
			System.out.println("#"+test_case+" "+min_sig);
		}
	}
}
