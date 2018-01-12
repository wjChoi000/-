package algorithm;

import java.util.Scanner;

public class Sumsung_12100 {

	static Scanner scan;
	static int[][] board = new int[20][20];
	final static int left = 0;
	final static int top = 1;
	final static int right =2;
	final static int bottom = 3;
	
	
	public static void main(String str[]) {
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i,j;
		int max_num=0;
		
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				int temp = scan.nextInt();
				if(temp>max_num) {
					max_num = temp;
				}
				board[i][j] = temp;
			}
		}
	
		int one, two, three, four, five;
		for(one = 0; one <4; one++) {
			int[][] oneBoard = moveBoard(n,one,board);
			for(two = 0; two <4; two++) {
				int[][] twoBoard = moveBoard(n,two,oneBoard);
				for(three = 0; three <4; three++) {
					int[][] threeBoard = moveBoard(n, three,twoBoard);
					for(four = 0; four <4; four++) {
						int[][] fourBoard = moveBoard(n, four, threeBoard);
						for(five = 0; five <4; five++) {
							int[][] fiveBoard= moveBoard(n,five, fourBoard);
							
						
							// find max number
							for(i=0; i<n; i++) {
								for(j=0; j<n; j++) {
									if(max_num<fiveBoard[i][j]) {
										max_num = fiveBoard[i][j];
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(max_num);
	}
	
	static int[][] moveBoard(int n, int direction, int[][] board) {
		int[][] newBoard = new int[20][20];
				
		int i,j, boardPoint;
		
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++)
				newBoard[i][j] =0;
		}
		
		switch(direction) {
		case left:
			for(i=0; i<n; i++) {
				boardPoint=0;
				int temp1 = -1;
				int temp2 = -1;
				for(j=0; j<n; j++) {
					temp2 = board[i][j];
					if(temp2 != 0) {
						if(temp1 == -1) {
							temp1 = temp2;
							temp2= -1;
						}else if(temp1 == temp2) {
							
							newBoard[i][boardPoint] = temp1+temp2;
							
							boardPoint++;
							temp1 = -1;
							temp2 = -1;
						}else {
							newBoard[i][boardPoint] = temp1;
							boardPoint++;
							temp1 = temp2;
							temp2 = -1;
						}
					}

				}
				if(temp1 >0) {
					newBoard[i][boardPoint] = temp1;
					boardPoint++;
				}
				if(temp2>0) {
					newBoard[i][boardPoint] = temp2;
					boardPoint++;
				}
			}
			break;
		case top:

			for(j=0; j<n; j++) {
				boardPoint=0;
				int temp1 = -1;
				int temp2 = -1;
				for(i=0; i<n; i++) {
					temp2 = board[i][j];
					if(temp2 != 0) {
						if(temp1 == -1) {
							temp1 = temp2;
							temp2= -1;
						}else if(temp1 == temp2) {
							newBoard[boardPoint][j] = temp1+temp2;
							boardPoint++;
							temp1 = -1;
							temp2= -1;
						}else {
							newBoard[boardPoint][j] = temp1;
							boardPoint++;
							temp1= temp2;
							temp2= -1;
						}
					}
				}
				
				if(temp1 >0) {
					newBoard[boardPoint][j] = temp1;
					boardPoint++;
				}
				if(temp2>0) {
					newBoard[boardPoint][j] = temp2;
					boardPoint++;
				}
			}
			
			break;
		case right:
			
			
			for(i=0; i<n; i++) {
				boardPoint=n-1;
				
				int temp1 = -1;
				int temp2 = -1;
				for(j=n-1; j>=0; j--) {
					temp2 = board[i][j];
					if(temp2 != 0) {
						if(temp1 == -1) {
							temp1 = temp2;
							temp2 = -1;
						}else if(temp1 == temp2) {
							newBoard[i][boardPoint] = temp1+temp2;
							boardPoint--;
							temp1 = -1;
							temp2 = -1;
						}else {
							newBoard[i][boardPoint] = temp1;
							boardPoint--;
							temp1 = temp2;
							temp2 = -1;
						}
					}
				}
				
				if(temp1 >0) {
					newBoard[i][boardPoint] = temp1;
					boardPoint--;
				}
				if(temp2>0) {
					newBoard[i][boardPoint] = temp2;
					boardPoint--;
				}
			}
			break;
		case bottom:
			
			for(j=0; j<n; j++) {
				boardPoint=n-1;
				int temp1 = -1;
				int temp2 = -1;
				for(i=n-1; i>=0; i--) {
					temp2 = board[i][j];
					if(temp2 != 0) {
						if(temp1 == -1) {
							temp1 = temp2;
							temp2 = -1;
						}else if(temp1 == temp2) {
							newBoard[boardPoint][j] = temp1+temp2;
							boardPoint--;
							temp1 = -1;
							temp2 = -1;
						}else {
							newBoard[boardPoint][j] = temp1;
							boardPoint--;
							temp1 = temp2;
							temp2 = -1;
						}
					}
				}
				if(temp1 >0) {
					newBoard[boardPoint][j] = temp1;
					boardPoint--;
				}
				if(temp2>0) {
					newBoard[boardPoint][j] = temp2;
					boardPoint--;
				}
			}
			break;
		}
			
		return newBoard;
	}
	
}
