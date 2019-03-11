package SWEA;

import java.util.Scanner;

public class SWEA_2383 {
	
	static int N,Min;
	static int[][] Map,Door, Human;
	static int human_count;
	
	static void dfs(int depth) {
		//시간 구하기
		if(depth == human_count) {
//			int a_size = human_count-b_size;
			int[][] list = new int[2][10];
			int[] count = {0,0};
			for(int i=0; i<human_count; i++) {
				if(Human[i][2]==0) {//1번문	
					int distance = Math.abs(Door[0][0]-Human[i][0]) + Math.abs(Door[0][1]-Human[i][1]);
					list[0][count[0]]=distance;
					count[0]++;
				}else {//2번문
					int distance = Math.abs(Door[1][0]-Human[i][0]) + Math.abs(Door[1][1]-Human[i][1]);
					list[1][count[1]]=distance;
					count[1]++;
				}
			}
			
			//list 정렬 오름차순
			for(int i=0; i<2; i++) {	
				for(int j=0; j<count[i]-1; j++) {
					for(int k=j+1; k<count[i];k++) {
						int temp = list[i][j];
						if(temp >list[i][k]) {
							list[i][j] = list[i][k];
							list[i][k] = temp;
						}
					}
				}
			}
			
			
			//문 통과 시간
			int Max=0;
			for(int i=0; i<2;i++) {
				int time=0;
				//문 통과하기
				int stair_time= -1*Map[Door[i][0]][Door[i][1]];
				int into_stair =0;
				
				
				for(int h=0; h<count[i];) {
				
					time++;
					for(int j=h; j<count[i];j++) {
						if(list[i][j] >0)//한칸전진
							list[i][j]--;
						else if(list[i][j]==0) {//계단 대기자
							if(into_stair <3) {//입장 가능시
								list[i][j]--;
								into_stair++;
							}
						}
						else if(list[i][j]<0) {//계단에 있을경우
							if(list[i][j] <=stair_time) {//계단에서 나옴
								h++;
								into_stair--;
							}
							list[i][j]--;
							
						}
					
					}
					
				}
				if(Max <time)//더 오래 걸린 시간 선택
					Max= time;
				
				
			}
			if(Max < Min)//가정 적은 통과시간
				Min = Max;
			
			return;
		}
		//사람이 두문으로 갈수 있는 모든 경의 수
		for(int i=0; i<2; i++) {
			Human[depth][2] =i;
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
			N =sc.nextInt();
			Min = 1000000000;
			Map = new int[N][N];
			Door = new int[2][2];
			Human = new int[10][3];
			int door_count=0;
			human_count=0;
			for(int i=0; i<N;i++)
				for(int j=0; j<N; j++) {
					Map[i][j] = sc.nextInt();
					if(Map[i][j]==1) {
						Human[human_count][0]=i;
						Human[human_count][1]=j;
						human_count++;
					}else if(Map[i][j]>1) {
						Door[door_count][0]=i;
						Door[door_count][1]=j;
						door_count++;
					}
				}
			
			dfs(0);
			
			System.out.println("#"+test_case+" "+Min);
		}
	}
}
