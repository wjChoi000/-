package BOJ;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//! 우선순위 큐를 사용해야된다!
public class BJO_16236 {

	static int fishSize=2, eat=0, N,M=0;
	static int[] fish = new int[2];
	static int[] dy= { -1,0,0,1};
	static int[] dx = {0,-1,1,0};
	static int[][] Map;
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Map = new int[N][N];
		int[][] visited = new int[N][N];
		for(int i =0; i<N; i++)
			for( int j=0; j<N; j++) {
				Map[i][j]=sc.nextInt();
				visited[i][j]=0;
				if(Map[i][j]>0) {
					if(Map[i][j]== 9) {
						fish[0]=i;
						fish[1]=j;
						Map[i][j]=0;
					}else 
						M++;
				}
			}
		
		
		int time =0;
		PriorityQueue<Fish> que = new PriorityQueue<>();
		Fish f= new Fish(fish[0],fish[1],0);
		que.add(f);
		visited[f.i][f.j]=1;
		
		while(!que.isEmpty()) {
			f = que.remove();
			int m= Map[f.i][f.j];
			//냠냠
			if(m>0 &&m<fishSize) {
				//냠냠
				Map[f.i][f.j]=0;
				time += f.time;
				fish[0]=f.i;
				fish[1]=f.j;
				//크기업
				eat++;
				if(eat==fishSize) {
					eat=0;
					fishSize++;
				}
				//방문 초기화
				for(int i =0; i<N; i++)
					for( int j=0; j<N; j++)
						visited[i][j]=0;
				visited[f.i][f.j]=1;
				//큐 초기화
				que = new PriorityQueue<>();
				f.time=0;
				que.add(f);
				
//				print();
//				System.out.println("");
			}else {
				for(int i=0; i<4;i++) {
					int ny = f.i+dy[i];
					int nx = f.j+dx[i];
					if(ny>=0&&nx>=0&& ny<N&&nx<N) {
						if(visited[ny][nx]==0 &&Map[ny][nx] <=fishSize) {
							Fish new_fish = new Fish(ny,nx,f.time+1);
							que.add(new_fish);
							visited[ny][nx]=1;
						}
					}
				}
			}
			
		}
		
		System.out.println(time);
	}
	
	static void print() {
		System.out.println(fishSize-1 +"---------------------");
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				if(fish[0]==i && fish[1]==j)
					System.out.print("#");
				else
					System.out.print(Map[i][j]);
			}
			System.out.println();
		}
		
	}
}
//우선 순위 큐를 위한 준비
class Fish implements Comparable<Fish>{
		int i=0;
		int j=0;
		int time=0;
		public Fish(int i , int j,int time) {
			this.i = i;
			this.j = j;
			this.time = time;
			
		}
		public void print() {
			System.out.println("i: "+i+",j: "+j);
		}
		@Override
		public int compareTo(Fish Target) {
			if(this.time< Target.time) {
				return -1;
			}else if(this.time ==Target.time) {
				if(this.i <Target.i) {
					return -1;
				}else if(this.i== Target.i){
					if(this.j <Target.j)
						return -1;
					else return 1;
				}else {
					return 1;
				}
			}else
				return 1;
		}	
}
