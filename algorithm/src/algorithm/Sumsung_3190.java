package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Sumsung_3190 {

	static Scanner scan;
	static int[][] map = new int[100][100];
	static int[][] direction = new int[100][2];
	
	final static int LEFT = 1;
	final static int TOP = 2;
	final static int RIGHT =3;
	final static int BOTTOM=4;
	final static int END = -10;
	final static int body = -1;
	final static int apple = 10;
	
	static ArrayList<int[]> bodyP = new ArrayList<int[]>();
	public static void main(String arg[]) {
		
		//input
		int seconds = 0;
		scan = new Scanner(System.in);
		int i,j;
		
		int n = scan.nextInt();
		for(i=0; i<n; i++) {
			for(j=0 ; j<n; j++) {
				map[i][j] = 0;
			}
		}
		int k = scan.nextInt();
		
		for(i = 0; i<k; i++) {
			int y = scan.nextInt();
			int x  = scan.nextInt();
			map[y-1][x-1] = apple;
		}
		map[0][0] = body;
		int[] e = {0,0};
		bodyP.add(e);
		
		int l = scan.nextInt();
		for(i=0; i<l; i++) {
			direction[i][0] = scan.nextInt();
			String d = scan.next();
			if(d.compareTo("D")==0) {
				direction[i][1] =RIGHT;
			}else {
				direction[i][1] =LEFT;
			}
			
		}
		int currentDirection = RIGHT;
		int result= 0;
		//algorithm
		
		i=0;
		while(true) {
			result = move(currentDirection, n);
			seconds++;
			
			//go
//			for(; seconds< direction[i][0]; seconds++) {
//				result = move(currentDirection, n);
//				if(result  == END) {
//					seconds++;
//					break;
//				}
//			}
			
			if(result == END)
				break;
			//direction change
			if(direction[i][0] == seconds) {
				
				if(direction[i][1] == LEFT) {
					currentDirection--;
					if(currentDirection <LEFT)
						currentDirection = BOTTOM;
				}else {
					currentDirection++;
					if(currentDirection >BOTTOM) {
						currentDirection= LEFT;
					}
				}	
				i++;
				
			}
		}
		//output
		System.out.println(seconds);
	}
	static void show(int n) {
		System.out.println("------------------------------------");
		for(int i=0; i<n ; i++) {
			for(int j =0; j<n; j++) {
				System.out.printf("%d\t",map[i][j]);
			}
			System.out.println();
		}
	}
	
	static int move(int direction, int n ) {
		int[] nextP = new int[2];
		int[] currentP = bodyP.get(bodyP.size()-1);
		nextP[0] = currentP[0];
		nextP[1] = currentP[1];
		switch(direction) {
		case LEFT:
			nextP[1]--;
			break;
		case TOP:
			nextP[0]--;
			break;
		case RIGHT:
			nextP[1]++;
			break;
		case BOTTOM:
			nextP[0]++;
			break;
		}
		//벽 충돌
		if(nextP[0] <0 || nextP[0] >= n || nextP[1] <0 || nextP[1] >=n) {
//			System.out.println("wall");
			return END;
		}
		
		//몸 충돌
		if(map[nextP[0]][nextP[1]] == body) {
//			System.out.println("body");
			return END;
		}
		
		
		//apple o
		if(map[nextP[0]][nextP[1]] != apple ) {
			int[] endP = bodyP.get(0);
			map[endP[0]][endP[1]] = 0;
			bodyP.remove(0);
		}
		bodyP.add(nextP);
		map[nextP[0]][nextP[1]] = body;
		
		return 0;
		
	}
}
