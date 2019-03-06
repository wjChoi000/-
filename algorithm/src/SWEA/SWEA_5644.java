package SWEA;

import java.util.Scanner;

public class SWEA_5644 {

	static int D,W,K;
	static int[][] Map = new int[13][20];
	static int[] flag = new int[13];
	static int[] flagDrag = new int[13];
	static int min_depth=13;
	
	
	static boolean test(){
		int[][] test_Map = new int[13][20];
		for(int i =0; i<D; i++) {
			for(int j =0; j<W; j++) {
				test_Map[i][j] = Map[i][j];
			}
		}
		//¿°»ö
		for(int i =0; i<D; i++) {
			if(flag[i] == 1) {
				for(int j =0; j<W; j++)
					test_Map[i][j]= flagDrag[i];
			}
		}
		System.out.print("");
		//test
		for(int j=0; j<W; j++) {
			int count=1;
			int before = test_Map[0][j];
			System.out.print("");
			for(int i=1; i<D; i++) {
				if(before == test_Map[i][j]) { count++;}
				else {
					before = test_Map[i][j];
					count=1;
				}
				if(count==K) break;
						
			}
			if(count !=K)
				return false;
		}
		
		return true;
	}
	static void dfs(int depth, int start){
		if(depth >= min_depth)
			return;
		if(test()) {

			if(min_depth >depth) min_depth = depth;
			return;
		}
		for(int i=start; i<D; i++) {
			flag[i]=1;
			//A
			flagDrag[i]=0;
			dfs(depth+1,i+1);
			//B
			flagDrag[i]=1;
			dfs(depth+1,i+1);
			
			flag[i]=0;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
		
			D=sc.nextInt();
			W=sc.nextInt();
			K= sc.nextInt();
			min_depth=13;
			for(int i=0; i<D; i++) flag[i]=0;
			
			for(int i=0; i<D; i++)
				for(int j=0; j<W; j++)
					Map[i][j] = sc.nextInt();
			
			dfs(0,0);
			
			System.out.println("#"+test_case+" "+min_depth);
			
		}
	}
}
