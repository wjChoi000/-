package SWEA;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5648 {
	static final int MAXTIME =4001;	
	static int energy =0,N=0;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	static int[][] Map= new int[4001][4001];;
	
	
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
				
		for(int test_case = 1; test_case <= T; test_case++)
		{
			energy=0;
			N =sc.nextInt();

			Queue<Integer[]> que  = new LinkedList<>();
			
			
			for(int i=0 ; i<N; ++i) {
				Integer[] element = new Integer[4];
				for(int j=0; j<4; ++j)
					element[j] = sc.nextInt();
				
				element[0] +=1000;
				element[0] *=2;
				element[1] +=1000;
				element[1] *=2;
				
				que.add(element);
			}
			int time=0;
			
			while(que.size()>1 && time<MAXTIME) {
				
				int size = que.size();
				
				for(int s=0; s<size; s++) {
					Integer[] current = que.remove();
			
					current[0] +=dx[current[2]];
					current[1] +=dy[current[2]];
					if( current[0]>=0 &&current[1] >=0 && current[0]<=4000 &&current[1] <=4000) {
						que.add(current);
						Map[current[0]][current[1]] +=current[3];
					}
				}
				size = que.size();
				for(int s=0; s<size; s++) {
					Integer[] current = que.remove();
					if( Map[current[0]][current[1]] != current[3]) {
						energy += Map[current[0]][current[1]];
					}
					else{
						que.add(current);
					}
					Map[current[0]][current[1]]=0;
					
				}
				
				++time;
			}
			System.out.println("#"+test_case+" "+energy);
		}
	}
}
