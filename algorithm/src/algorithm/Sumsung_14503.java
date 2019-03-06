package algorithm;
//
//import java.util.Scanner;
//
//public class Sumsung_14503 {
//	static int N;
//	static int M;
//	static int r;
//	static int c;
//	static int d;
//	
//	
//	static int[][] MAP= new int[50][50];
//	
//	
//	static Scanner scan;
//	final static int SOUTH = 0;
//	final static int EAST = 1;
//	final static int NORTH = 2;
//	final static int WEST = 3;
//	
//	final static int EMPTY =0;
//	final static int WALL = 1;
//	final static int CLEAN = 2;
//	
//	static public void main(String str[]) {
//		scan = new Scanner(System.in);
//		N = scan.nextInt();
//		M = scan.nextInt();
//		r = scan.nextInt();
//		c = scan.nextInt();
//		d = scan.nextInt();
//		int i, j;
//		for(i=0; i<N; i++) {
//			for(j=0; j<M; j++) {
//				MAP[i][j] = scan.nextInt();
//				
//			}
//		}
//		int num_clean=0;
//		boolean stop_flag = false;
//		while(true) {
//			if(stop_flag)
//				break;
//			//1
//			if(MAP[r][c] == EMPTY) {
//				num_clean++;
//				MAP[r][c] = CLEAN;
//			}
//			
//			//2
//			while(true) {
//				if(MAP[r+1][c] != EMPTY && MAP[r-1][c] != EMPTY && MAP[r][c+1] != EMPTY 
//						&& MAP[r][c-1] != EMPTY) {
//					boolean flag2 = true;
//					
//					switch(d){
//					case SOUTH:
//						if(MAP[r+1][c] != WALL) {
//							r++;
//							flag2=false;
//						}
//						break;
//					case EAST:
//						if(MAP[r][c-1] != WALL) {
//							c--;
//							flag2=false;
//						}
//						break;
//					case NORTH:
//						if(MAP[r-1][c] != WALL) {
//							r--;
//							flag2=false;
//						}
//						break;
//					case WEST:
//						if(MAP[r][c+1] != WALL) {
//							c++;
//							flag2=false;
//						}
//						break;
//					}
//					//2-4
//					if(flag2) {
//						stop_flag = true;
//						break;
//					}else {
//						break;
//					}
//				}
//				
//				int tempD = d;
//				boolean flag1= false;
//				
//				for(i=0 ; i<4; i++) {
//					switch(tempD){
//					case SOUTH:
//						if(MAP[r-1][c] == EMPTY) {
//							flag1 = true;
//							r--;
//						}
//						break;
//					case EAST:
//						if(MAP[r][c+1] == EMPTY) {
//							flag1 = true;
//							c++;
//						}
//						break;
//					case NORTH:
//						if(MAP[r+1][c] == EMPTY) {
//							flag1 = true;
//							r++;
//						}
//						break;
//					case WEST:
//						if(MAP[r][c-1] == EMPTY) {
//							flag1 = true;
//							c--;
//						}
//						break;
//					}
//					if(flag1) {
//						d = tempD;
//						break;
//					}else {
//					
//						tempD--;
//						if(tempD <0)
//							tempD = WEST;
//					}
//				}
//				
//				if(flag1) {
//					break;
//				}
//				
//				
//			
//			}
//		}
//
//		for(i=0; i<N; i++) {
//			for(j = 0; j<M; j++) {
//				System.out.print(MAP[i][j]);
//			}
//			System.out.println();
//		}
//		
//		System.out.println(num_clean);
//	}
//}
import java.util.Scanner;
import java.util.Stack;
 
public class Sumsung_14503{
    int[][] map;
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int curDirection;
    Pair<Integer, Integer> robotLoc;
    Stack<Pair<Integer, Integer>> stack = new Stack<Pair<Integer, Integer>>();
    int row, col;
    int ans = 0;
 
    void dfs() {
        int dRow, dCol;
        int nRow = -1, nCol = -1;
        int tempCur = curDirection;
        Pair<Integer, Integer> tempPair;
 
        while (!stack.isEmpty()) {
             
            tempPair = stack.pop();
            dRow = tempPair.x;
            dCol = tempPair.y;
            tempCur = curDirection;
             
            if (map[dRow][dCol] == 0) {
                map[dRow][dCol] = 2;
                ans++;
            }
             
            //왼쪽부터 회전
            for (int i = 0; i < 4; i++) {
                switch (curDirection) {
                case 0: {
                    curDirection = 3;
                    nRow = dRow + directions[curDirection][0];                 
                    nCol = dCol + directions[curDirection][1];             
                    break;
                }
                case 1: {
                    curDirection = 0;
                    nRow = dRow + directions[curDirection][0];
                    nCol = dCol + directions[curDirection][1];
                    break;
                }
                case 2: {
                    curDirection = 1;
                    nRow = dRow + directions[curDirection][0];
                    nCol = dCol + directions[curDirection][1];
                    break;
                }
                case 3: {
                    curDirection = 2;
                    nRow = dRow + directions[curDirection][0];
                    nCol = dCol + directions[curDirection][1];
                    break;
                }
                }
                if (0 <= nRow && nRow < row && 0 <= nCol && nCol < col) {
                    if (map[nRow][nCol] == 0) {
                        tempPair = new Pair<Integer, Integer>(nRow, nCol);
                        stack.push(tempPair);
                        break;
                    }
                }
            }
             
            //뒤로 후진
            if (stack.isEmpty()) {
                curDirection = tempCur;
                switch (curDirection) {
                case 0: {
                    nRow = dRow + directions[2][0];
                    nCol = dCol + directions[2][1];
                    break;
                }
                case 1: {
                    nRow = dRow + directions[3][0];
                    nCol = dCol + directions[3][1];
                    break;
                }
                case 2: {
                    nRow = dRow + directions[0][0];
                    nCol = dCol + directions[0][1];
                    break;
                }
                case 3: {
                    nRow = dRow + directions[1][0];
                    nCol = dCol + directions[1][1];
                    break;
                }
                }
                if (map[nRow][nCol] == 1)
                    return;
                tempPair = new Pair<Integer, Integer>(nRow, nCol);
                stack.push(tempPair);
            }
        }
    }
 
    void solution() {
        Scanner s = new Scanner(System.in);
 
        row = s.nextInt();
        col = s.nextInt();
        int tempRow, tempCol;
        tempRow = s.nextInt();
        tempCol = s.nextInt();
        robotLoc = new Pair<Integer, Integer>(tempRow, tempCol);
        curDirection = s.nextInt();
        map = new int[row][col];
        stack = new Stack<Pair<Integer, Integer>>();
        stack.push(robotLoc);
 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = s.nextInt();
            }
        }
 
        dfs();
        
        for(int i =0; i< row; i++) {
        	for(int j = 0; j<col; j++)
        		System.out.print(map[i][j]);
        	System.out.println();
        }
        
        System.out.println(ans);
    }
 
    public static void main(String[] args) {
        Sumsung_14503 m = new Sumsung_14503();
        m.solution();
    }
 
    class Pair<X, Y> {
        X x;
        Y y;
 
        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
 
        }
 
    }
 
}