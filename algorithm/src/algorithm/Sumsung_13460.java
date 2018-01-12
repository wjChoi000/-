package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Sumsung_13460 {

	static int[][] miro = new int[10][10];
	static Scanner scan;
	static int HOLL = 1;
	static int RED = 2;
	static int BLUE =3;
	static int[][] point = new int[3][2];
	static int left =0;
	static int top = 1;
	static int right =2;
	static int bottom = 3;
	static ArrayList<pointball> stack;
	static int block = -1;
	static int open = 0;
	static int gool = 1;
	static boolean[] direction = {true,true,true,true};
	
	static int num= 11;
	
	public static void main(String str[]) {
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int i, j;
		String temp;
		for(i = 0;i<n;i++) {
			temp =scan.next();
			for(j =0; j <m; j++) {
				if(temp.charAt(j) =='#') {
					miro[i][j] = block;					
				}else if(temp.charAt(j) =='.') {
					miro[i][j] = open;
				}
				else if((temp.charAt(j) =='O')){
					miro[i][j] = open;
					point[0][0]=i;
					point[0][1] = j;
				}
				else if((temp.charAt(j) =='R')){
					miro[i][j] = open;
					point[1][0]=i;
					point[1][1]=j;
				}
				else if((temp.charAt(j) =='B')){
					miro[i][j] = open;
					point[2][0] = i;
					point[2][1] = j;
				}

			}
		}		
//		for(i=0; i<3; i++) {
//			System.out.println(point[i][0]+","+point[i][1]);
//		}
//		for(i=0;i<n; i++) {
//			for(j=0; j<m; j++)
//				System.out.print(miro[i][j]);
//			System.out.println();
//		}
		stack = new ArrayList<pointball>();
		
		//init
		
		stack.add(new pointball(point[1],point[2], 0 ,direction));
		while(!stack.isEmpty()) {
			int index = stack.size()-1;
			pointball p = stack.get(index);

//			System.out.println("-----------------------");
//			System.out.println("point : "+p.red[0]+","+p.red[1]+"/"+p.blue[0]+","+p.blue[1]);
//			System.out.println("num : "+p.num_move);
//			for(i=0; i<4; i++)
//				System.out.print(p.direction[i]+" ");
//			System.out.println();
			if(p.direction[left]) {
				moveLeft(p);
			}else if(p.direction[top]) {
				moveTop(p);
			}
			else if(p.direction[right]) {
				moveRight(p);
			}else if(p.direction[bottom]) {
				moveBottom(p);
			}else {
				stack.remove(index);
			}
		}
		if(num == 11) {
			num = -1;
		}
		System.out.println(num);
		
	}
	
	static void moveLeft(pointball p) {

		int[] red = new int[2];
		red[0] = p.red[0];
		red[1] = p.red[1];
		
		int[] blue =  new int[2];
		blue[0] = p.blue[0];
		blue[1] = p.blue[1];

		
		
		boolean[] directionLeft = {false,true,false,true};
		
		while(p.direction[left]) {
			
			if(p.num_move+1 >= num) {
				p.direction[left] = false;
				break;
			}
			//gool check
			
			
			
			if(red[0] ==point[0][0] && red[1] == point[0][1]) {
				p.direction[left] = false;
				//blue left
				boolean flag = true;
				while(miro[blue[0]][blue[1]-1] == open) {
					blue[1]--;
					if(blue[0] ==point[0][0] && blue[1] == point[0][1])
						flag =false;
				}
				if(num >p.num_move+1 && flag)
					num=p.num_move+1;
				break;
			}
			if(blue[0] ==point[0][0] && blue[1] == point[0][1]) {
				p.direction[left] = false;
				break;
			}
				
			
			//blue and red의 왼쪽이 막히면 p.d[l] = false;\
			if( (miro[red[0]][red[1]-1] == block && miro[blue[0]][blue[1]-1] ==block) ||
					(miro[red[0]][red[1]-1] == block && blue[1]-1 == red[1] &&blue[0]==red[0]) ||
					(miro[blue[0]][blue[1]-1] ==block && red[1]-1 == blue[1] &&blue[0]==red[0]) ) {
				p.direction[left] = false;
				
				stack.add(new pointball(red,blue,p.num_move+1,directionLeft));
				break;
			}
			
			if(miro[red[0]][red[1]-1] == open)
				red[1]--;
			if(miro[blue[0]][blue[1]-1] == open)
				blue[1]--;
			
//			//red top, red bottom,
//			if(miro[red[0]][red[1]+1] == open ||
//					miro[red[0]][red[1]-1] == open||
//					miro[blue[0]][blue[1]+1]==open||
//					miro[blue[0]][blue[1]-1] == open) {
//				stack.add(new pointball(red,blue,p.num_move+1,directionLeft));
//			}
		}
	}
	static void moveRight(pointball p) {
		int[] red = new int[2];
		red[0] = p.red[0];
		red[1] = p.red[1];
		
		int[] blue =  new int[2];
		blue[0] = p.blue[0];
		blue[1] = p.blue[1];
		boolean[] directionLeft = {false,true,false,true};
		
		
		while(p.direction[right]) {
			if(p.num_move+1 >= num) {
				p.direction[right] = false;
				break;
			}
			//gool check
			if(red[0] ==point[0][0] && red[1] == point[0][1]) {
				p.direction[right] = false;
				
				boolean flag = true;
				while(miro[blue[0]][blue[1]+1] == open) {
					blue[1]++;
					if(blue[0] ==point[0][0] && blue[1] == point[0][1])
						flag =false;
				}
				if(num >p.num_move+1 && flag)
					num=p.num_move+1;
				break;
			}
			if(blue[0] ==point[0][0] && blue[1] == point[0][1]) {
				p.direction[right] = false;
				break;
			}
			
			
			//blue and red의 오른쪽이 막히면 p.d[l] = false;\
			if( (miro[red[0]][red[1]+1] == block && miro[blue[0]][blue[1]+1] ==block) ||
					(miro[red[0]][red[1]+1] == block && blue[1]+1 == red[1] &&blue[0]==red[0] ) ||
					(miro[blue[0]][blue[1]+1] ==block && red[1]+1 == blue[1] &&blue[0]==red[0]) ) {
				p.direction[right] = false;
				
				stack.add(new pointball(red,blue,p.num_move+1,directionLeft));
				break;
			}
			
			if(miro[red[0]][red[1]+1] == open)
				red[1]++;
			if(miro[blue[0]][blue[1]+1] ==open)
				blue[1]++;
			
//			//red top, red bottom,
//			if(miro[red[0]][red[1]+1] == open ||
//					miro[red[0]][red[1]-1] == open||
//					miro[blue[0]][blue[1]+1]==open||
//					miro[blue[0]][blue[1]-1] == open) {
//				stack.add(new pointball(red,blue,p.num_move+1,directionLeft));
//			}
		}
		
		
	}
	static void moveTop(pointball p) {
		int[] red = new int[2];
		red[0] = p.red[0];
		red[1] = p.red[1];
		
		int[] blue =  new int[2];
		blue[0] = p.blue[0];
		blue[1] = p.blue[1];
		boolean[] directionLeft = {true,false,true,false};
		
		while(p.direction[top]) {
			if(p.num_move+1 >= num) {
				p.direction[top] = false;
				break;
			}
			//gool check
			if(red[0] ==point[0][0] && red[1] == point[0][1]) {
				p.direction[top] = false;
				boolean flag = true;
				while(miro[blue[0]+1][blue[1]] == open) {
					blue[0]++;
					if(blue[0] ==point[0][0] && blue[1] == point[0][1])
						flag =false;
				}
				if(num >p.num_move+1 && flag)
					num=p.num_move+1;
				break;
			}
			if(blue[0] ==point[0][0] && blue[1] == point[0][1]) {
				p.direction[top] = false;
				break;
			}
			
			
			//blue and red의 위쪽이 막히면 p.d[l] = false;\
			if( (miro[red[0]+1][red[1]] == block && miro[blue[0]+1][blue[1]] ==block) ||
					(miro[red[0]+1][red[1]] == block && blue[0]+1 == red[0] &&blue[1]==red[1]) ||
					(miro[blue[0]+1][blue[1]] ==block && red[0]+1 == blue[0] &&blue[1]==red[1]) ) {
				p.direction[top] = false;
				stack.add(new pointball(red,blue,p.num_move+1,directionLeft));
				break;
			}
			
			if(miro[red[0]+1][red[1]] == open)
				red[0]++;
			if(miro[blue[0]+1][blue[1]] ==open)
				blue[0]++;
//			//red left, red right,
//			if(miro[red[0]+1][red[1]] == open ||
//					miro[red[0]-1][red[1]] == open||
//					miro[blue[0]+1][blue[1]]==open||
//					miro[blue[0]-1][blue[1]] == open) {
//				stack.add(new pointball(red,blue,p.num_move+1,directionLeft));
//			}
		}
		
		
	}
	static void moveBottom(pointball p) {
		int[] red = new int[2];
		red[0] = p.red[0];
		red[1] = p.red[1];
		
		int[] blue =  new int[2];
		blue[0] = p.blue[0];
		blue[1] = p.blue[1];
		boolean[] directionLeft = {true,false,true,false};
	
		while(p.direction[bottom]) {
			if(p.num_move+1 >= num) {
				p.direction[bottom] = false;
				break;
			}
			//gool check
			if(red[0] ==point[0][0] && red[1] == point[0][1]) {
				p.direction[bottom] = false;
				boolean flag = true;
				while(miro[blue[0]-1][blue[1]] == open) {
					blue[0]--;
					if(blue[0] ==point[0][0] && blue[1] == point[0][1])
						flag =false;
				}
				if(num >p.num_move+1 && flag)
					num=p.num_move+1;
				break;
			}
			
			if(blue[0] ==point[0][0] && blue[1] == point[0][1]) {
				p.direction[bottom] = false;
				break;
			}
		
			
			//blue and red의 아래이 막히면 p.d[l] = false;\
			if( (miro[red[0]-1][red[1]] == block && miro[blue[0]-1][blue[1]] ==block) ||
					(miro[red[0]-1][red[1]] == block && blue[0]-1 == red[0] &&blue[1]==red[1]) ||
					(miro[blue[0]-1][blue[1]] ==block && red[0]-1 == blue[0] &&blue[1]==red[1]) ) {
				p.direction[bottom] = false;
				stack.add(new pointball(red,blue,p.num_move+1,directionLeft));
				break;
			}
			
			if(miro[red[0]-1][red[1]] == open)
				red[0]--;
			if(miro[blue[0]-1][blue[1]] ==open)
				blue[0]--;
			//red left, red right,
//			if(miro[red[0]+1][red[1]] == open ||
//					miro[red[0]-1][red[1]] == open||
//					miro[blue[0]+1][blue[1]]==open||
//					miro[blue[0]-1][blue[1]] == open) {
//				stack.add(new pointball(red,blue,p.num_move+1,directionLeft));
//			}
		}
	}
	
	public static class pointball {
		int[] red = new int[2];
		int[] blue = new int[2];
		int num_move = 0;
		boolean[] direction = new boolean[4];
		public pointball(int[] red, int blue[],int num_move,boolean[] direction) {
			this.red = red;
			this.blue = blue;
			this.num_move = num_move;
			this.direction = direction;
		}
	}
}
