package SWEA;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_5653 {
	static int N,M,K, Base=300;
	static int[][] Map,visited;
	static int[] dy= {1,0,0,-1};
	static int[] dx= {0,1,-1,0};
	static int num() {
		int n=0;
		for(int i=0; i<600;i++)
			for(int j=0; j<600;j++) {
				if(Map[i][j]>0) {
					n++;
				}
			}
		return n;
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
			K = sc.nextInt();
			Map = new int[600][600];
			visited = new int[600][600];
			
			PriorityQueue<Cell> que = new PriorityQueue<>();
			
			for(int i=Base; i<N+Base; i++)
				for(int j=Base; j<M+Base; j++) {
					Map[i][j] = sc.nextInt();
					if(Map[i][j] >0) {
						visited[i][j] =1;
						Cell c = new Cell(i,j,Map[i][j],0);
						que.add(c);
					}
				}

			while(true) {
				Cell c = que.remove();
//				if(c.K ==2)
//					System.out.println();
				if(c.K==K) {
					que.add(c);
					break;
				}
				
				if(c.T == c.t) {
					//¹è¾ç
					for(int r=0; r<4;r++) {
						int ny = c.i+dy[r];
						int nx = c.j+dx[r];
						if(visited[ny][nx]==0) {
							Cell newCell= new Cell(ny,nx,c.T,c.K+1);
							que.add(newCell);
							visited[ny][nx]=1;
						}
					}
				}
				
				if(c.t>1){
					c.t--;
					c.K++;
					que.add(c);
				}
			}
			
		
			
			System.out.println("#"+test_case+" "+que.size());
		}
	}
}


class Cell implements Comparable<Cell>{
	int i;
	int j;
	int T;
	int t;
	int K;
	
	public Cell(int i, int j, int T, int K) {
		this.i =i ;
		this.j =j;
		this.T=T;
		this.t = T*2;
		this.K=K;
	}
	
	@Override
	public int compareTo(Cell Target) {
		if(this.K <  Target.K)
			return -1;
		else if(this.K == Target.K) {
			if(this.T >Target.T )
				return -1;
			else
				return 1;
		}else return 1;
	}
}