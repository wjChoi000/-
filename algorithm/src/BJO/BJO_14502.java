package BJO;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJO_14502 {
	static int N,M;
	static int Max_num=0;
	static int[][] Map = new int[8][8];
	static int[][] visited = new int[8][8];
	static int[][] wall = new int[3][2];
	static public int cal_safe(int[][] map) {
		int num =0;
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(map[i][j] == 0)
					num++;
		return num;
	}
	
	static public int[][] spread_virus() {
		int[][] spread_map= new int[8][8];
		Queue<Integer[]> st = new LinkedList<>(); 
		
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++) {
				spread_map[i][j] = Map[i][j];
				if(Map[i][j]==2) {
					Integer[] index = {i,j}; 
					st.add(index);
				}
			}
		
		for(int i=0; i<3; i++) {
			spread_map[wall[i][0]][wall[i][1]] = 1;
		}
		
		
		while(!st.isEmpty()) {
			Integer[] current = st.remove();
			int i =current[0];
			int j = current[1]; 
			//위
			if(i>0) {
				if(spread_map[i-1][j]==0) {
					spread_map[i-1][j]=2;
					Integer[] next = {i-1,j};
					st.add(next);
				}
			}
			//아래
			if(i<N-1)
				if(spread_map[i+1][j]==0) {
					spread_map[i+1][j]=2;
					Integer[] next = {i+1,j};
					st.add(next);
				}
			//왼쪽
			if(j>0)
				if(spread_map[i][j-1]==0) {
					spread_map[i][j-1]=2;
					Integer[] next = {i,j-1};
					st.add(next);
				}
			//오른쪽
			if(j<M-1)
				if(spread_map[i][j+1]==0) {
					spread_map[i][j+1]=2;
					Integer[] next = {i, j+1};
					st.add(next);
				}
		}
		
		return spread_map;
	}
	
	static public void dfs(int depth, int last) {
		if(depth==3) {
			int[][] spread_map = spread_virus();
			int num = cal_safe(spread_map);
			if(num>Max_num) Max_num= num;
			return;
		}
		for(int k= last; k<N*M; k++) {
			int i = k/M;
			int j = k%M;
			if(visited[i][j]==0) {
				visited[i][j]=1;
				
				wall[depth][0]=i;
				wall[depth][1]=j;
				
				dfs(depth+1, k+1);
				visited[i][j]=0;
			}
		}
	}
	
	static public void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++) {
				Map[i][j]=sc.nextInt();
				if(Map[i][j] ==0) visited[i][j] = 0;
				else visited[i][j] = 1;
			}
		dfs(0,0);
		System.out.println(Max_num);
		
	}
}
