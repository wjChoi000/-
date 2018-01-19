package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Sumsung_14502 {
	static Scanner scan;
	static int N;
	static int M;
	final static int SAFETY = 0;
	final static int WALL =1 ;
	final static int VIRUS = 2;
	
	public static void main(String arg[]) {
		//input
		scan = new Scanner(System.in);
		N= scan.nextInt();
		M = scan.nextInt();
		
		int map[][] = new int[N][M];
	
		int i,j,k;
		for(i =0; i<N; i++) {
			for(j=0; j<M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		//solution
		int maxSafetySection = 0;
		int x1,x2,x3, y1,y2,y3;
		for(i=0; i<M*N-2; i++) {
			x1 = i/M;
			y1 = i%M;
			if(map[x1][y1] != SAFETY)
				continue;
			
			for(j=i+1; j<M*N-1; j++) {
				x2 = j/M;
				y2 = j%M;
				if(map[x2][y2] != SAFETY)
					continue;
					
				for(k=j+1; k<M*N; k++) {
					x3 = k/M;
					y3 = k%M;
					if(map[x3][y3] != SAFETY)
						continue;
					int[][] tempMap = new int[N][M];
					//System.arraycopy(map, 0, tempMap, 0, N*M);
					for(int l =0; l<N; l++) {
						for(int t=0; t<M; t++) {
							tempMap[l][t] = map[l][t];
						}
					}
					tempMap[x1][y1] = WALL;
					tempMap[x2][y2] = WALL;
					tempMap[x3][y3] = WALL;
					int tempNum = numSafetySection(tempMap);
					
					if(maxSafetySection < tempNum) {
						maxSafetySection = tempNum;
					}
				}
			}
		}
		
		//output
		System.out.println(maxSafetySection);
	}
	
	
	static int numSafetySection(int map[][]) {
		ArrayList<int[]> virusStack = new ArrayList<int[]>();
		int i,j;
		for(i=0; i<N; i++) {
			for(j=0; j<M; j++) {
				if(map[i][j] ==VIRUS) {
					int[] temp = {i,j};
					virusStack.add(temp);
				}
			}
		}
		
		while(!virusStack.isEmpty()) {
			int[] cp = virusStack.get(0);
			virusStack.remove(0);
			//ÁÂ
			if(cp[1]-1>=0 && map[cp[0]][cp[1]-1]== SAFETY) {
				map[cp[0]][cp[1]-1] = VIRUS;
				int[] temp = {cp[0], cp[1]-1};
				virusStack.add(temp);
			}
			//¿ì
			if(cp[1]+1 < M && map[cp[0]][cp[1]+1] == SAFETY) {
				map[cp[0]][cp[1]+1] = VIRUS;
				int[] temp = {cp[0], cp[1]+1};
				virusStack.add(temp);
			}
			//À§
			if(cp[0]-1 >=0 && map[cp[0]-1][cp[1]]== SAFETY) {
				map[cp[0]-1][cp[1]] = VIRUS;
				int[] temp = {cp[0]-1, cp[1]};
				virusStack.add(temp);
			}
			//¾Æ·¡
			if(cp[0]+1 < N && map[cp[0]+1][cp[1]] == SAFETY) {
				map[cp[0]+1][cp[1]] = VIRUS;
				int[] temp = {cp[0]+1, cp[1]};
				virusStack.add(temp);
			}
		}
		
		
		int num = 0;
		for(i=0; i< N; i++) {
			for(j=0; j<M; j++) {
				if(map[i][j] == SAFETY)
					num++;
			}
		}
		
		return num;
	}
}
