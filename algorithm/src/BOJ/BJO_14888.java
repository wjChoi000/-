package BOJ;

import java.util.Scanner;

public class BJO_14888 {
	static int N;
	static int[] cal_list = new int[4];
	static int[] cal_count = new int[4];
	static int[] num_list;
	static int max_num, min_num;
	
	static void dfs(int depth, int c_cul) {
		if(depth ==N) {
			if(max_num<c_cul) max_num = c_cul;
			if(min_num>c_cul) min_num = c_cul;
			return;
		}
		
		//+
		if(cal_count[0]<cal_list[0]) {
			cal_count[0]++;
			dfs(depth+1,c_cul+num_list[depth]);
			cal_count[0]--;
		}
		//-
		if(cal_count[1]<cal_list[1]) {
			cal_count[1]++;
			dfs(depth+1,c_cul-num_list[depth]);
			cal_count[1]--;
		}			
		//*
		if(cal_count[2]<cal_list[2]) {
			cal_count[2]++;
			dfs(depth+1,c_cul*num_list[depth]);
			cal_count[2]--;
		}
		// ³ª´©±â
		if(cal_count[3]<cal_list[3]) {
			cal_count[3]++;
			dfs(depth+1,c_cul/num_list[depth]);
			cal_count[3]--;
		}
		
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
			max_num= -1000000000;
			min_num = 1000000000;
			N= sc.nextInt();
			
			num_list = new int[N];
			for(int i=0; i<N;i++)
				num_list[i] = sc.nextInt();
			for(int i=0; i<4; i++) {
				cal_list[i]= sc.nextInt();
				cal_count[i]=0;
			}
			
			dfs(1,num_list[0]);
			System.out.println(max_num);
			System.out.println(min_num);
			
		
	}
}
