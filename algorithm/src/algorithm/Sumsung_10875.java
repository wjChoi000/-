package algorithm;

import java.util.ArrayList;
import java.util.Scanner;


//
public class Sumsung_10875 {

	static Long time = 0L;
	
	static long L;
	static int N;
	final static int LEFT = 1;
	final static int RIGHT = -1;
	
	final static int SOUTH =0;
	final static int EAST = 1;
	final static int NORTH =2;
	final static int WEST = 3;
	
	final static int[][] D = {{1,0},{0,1},{-1,0}, {0,-1}};
	final static int BODY = 1;
	final static int EMPTY = 0;
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		L = scan.nextLong();
		N = scan.nextInt();
		
		//배열로 해결 불가능 너무 큼
		//int[][] MAP = new int[100000000*2+1][100000000*2+1];
		
		long[][] MAP = new long[N+4][4];
		long[][] T = new long[N][2];
		
		for(int i = 0; i <N; i++) {
			T[i][0] = scan.nextLong();
			String temp = scan.nextLine();
			if(temp.compareTo(" L")==0)
				T[i][1] = LEFT;
			else
				T[i][1] = RIGHT;
		}
		
		scan.close();
		
		solution(MAP, T);
		
		System.out.println(time);
	}

	
	static void solution(long[][] MAP, long[][] T) {
		int direction = EAST;
		long x1=L , y1 =L,y2 = L, x2 = L ;
		long[] lw = {-1,2*L+1, -1,-1};
		long[] rw = {-1,2*L+1, 2*L+1,2*L+1};
		long[] bw = {-1,-1, -1, 2*L+1};
		long[] tw = {2*L+1,2*L+1,-1,2*L+1};
		
		MAP[0] = lw;
		MAP[1] = rw;
		MAP[2] = bw;
		MAP[3] = tw;
		
		for(int i =0; i <N; i++) {			
			// move
			time = time +T[i][0];
			y2 = y2+ D[direction][0]*T[i][0];
			x2 = x2+ D[direction][1]*T[i][0];
			
			//point
			long[] t1= {y1,y2,x1, x2};
			
			if(y1 >y2) {
				t1[1] = y1;
				t1[0] = y2;
			}
			if(x1>x2) {
				t1[3] = x1;
				t1[2] = x2;
			}
			
			long min_c =-1;
			
			//충돌시간 시간이 가장 긴거 찾기
			for(int k = 0; k<i+4; k++){
				long temp_min =-1;
				long[] t2 = MAP[k];
				
				//--
				if(t1[0]==t1[1]) {
					//--
					if(t2[0]==t2[1]) {
						if(t2[0]==t1[0]) {
							if(t2[2]<=t1[2]&& t1[2]<=t2[3]) {
								temp_min = t2[3] -t1[2];
							}else if(t2[2]<=t1[3]&& t1[3]<=t2[3]) {
								temp_min = t1[3]-t2[2]  ;
							}
						}
						
					}
					// l
					// l
					else {
						if( t1[2] <= t2[2]&& t2[2] <=t1[3] && t2[0] <= t1[0] && t1[0] <=t2[1]){
							if(direction ==WEST) {
								temp_min = t2[2] -t1[2];
							}
							else {
								temp_min = t1[3]-t2[2];
							}
						}
					}
				}
				// l
				// l
				else {
					// l
					// l
					if(t2[2] == t2[3]) {
						if(t2[2] == t1[2]) {
							if(t2[0] <=t1[0] && t1[0]<=t2[1]) {
								temp_min = t2[1] - t1[0];
							}else if(t2[0] <=t1[1] && t1[1]<=t2[1]) {
								temp_min = t1[1]- t2[0];
							}
							
						}
					}
					// --
					else {
						if(t2[2]<= t1[2] && t1[2] <=t2[3] && t1[0]<=t2[0] &&t2[0] <= t1[1]) {
							if(direction == SOUTH) {
								temp_min = t1[1] - t2[0];
							}else {
								temp_min = t2[0] -t1[0];
							}
						}
					}
					
				}
				
				if(temp_min >min_c) {	
					min_c = temp_min;
				}
			}	
			
			if(min_c != -1) {
				time = time - min_c;
				return;
			}
			
			MAP[i+4]= t1;
			//direction convert
			if(T[i][1] == LEFT) {
				direction--;
				if(direction <SOUTH)
					direction = WEST;
			}else {
				direction++;
				if(direction>WEST)
					direction = SOUTH;
			}
			
			y1 = y2 +D[direction][0];
			x1 = x2 +D[direction][1];
		}
	}
	
	public static void main(String str[]) {
		input();
	}
}
