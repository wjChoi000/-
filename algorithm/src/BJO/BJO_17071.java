package BJO;

import java.util.PriorityQueue;
import java.util.Scanner;


public class BJO_17071 {
	static int Max =500001;
	
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] visited = new int[2][Max];
		int time =0;
		int acc =1;
		boolean flag =false;
		
		for(int i=0;i<2; i++)
			for(int j=0; j<Max; j++)
				
				visited[i][j] = -1;
		visited[0][N] = time;

		int currentMax =N;
		
		while(true) {
			if(K>=Max) {
				break;
			}
			if(visited[0][K] == time) {
				flag=true;
				break;
			}
			
			int current = time%2;
			int next = 1-current;
			
			for(int i=0;i<=currentMax; i++) {
				if(visited[current][i]== time) {
					if(i-1>=0) {
						visited[next][i-1]=time+1;
					}
					if(i+1<Max) {
						visited[next][i+1]=time+1;
					}
					if(i*2<Max) {
						visited[next][i*2]=time+1;
					}
				}
			}
			currentMax *=2;
			if(currentMax >= Max)
				currentMax =Max-1;
			
			
			K +=acc;
			++acc;
			++time;
		}
		if(flag) 
			System.out.println(time);
		else
			System.out.println("-1");
	}
}


