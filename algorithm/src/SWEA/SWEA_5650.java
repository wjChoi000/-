package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class SWEA_5650{
	static int N,Max;
	static int[][] Map = new int[102][102];
	
	static int BLACKHOLE=-1, EMPTY=0;
	//   2
	// 0   1
	//   3
	static void shout(int dir,int i,int j){

		int count=0;
		Map[i][j]=-1;
		int current_dir= dir;
		int ci=i, cj=j;
		boolean flag = false;
//		if( i == 3&& j==4 && dir == 1)
//			System.out.println(" ");
		while(true) {
//			if( i == 9&& j==3 )
//				System.out.println(" ");
			if(count>1000) {
				count =0;
				break;
			}
			switch(current_dir) {
			// left
			case 0:
				cj--;
				break;
			//right
			case 1:
				cj++;
				break;
			//top
			case 2:
				ci--;
				break;
			//bottom
			case 3:
				ci++;
				break;
			}
			
			switch(Map[ci][cj]) {
			//블랙홀
			case -1:
				flag =true;
				break;
			//빈칸
			case 0:
				
				break;
			// 벽만남
			case 1:

				count++;
				if(current_dir==3) current_dir =1;
				else if(current_dir==0) current_dir =2;
				else if(current_dir==1) current_dir =0;
				else if(current_dir==2) current_dir =3;
				break;
			case 2:

				count++;
				if(current_dir==0) current_dir =3;
				else if(current_dir==2) current_dir =1;
				else if(current_dir==1) current_dir =0;
				else if(current_dir==3) current_dir =2;
				break;
			case 3:

				count++;
				if(current_dir==1) current_dir =3;
				else if(current_dir==2) current_dir =0;
				else if(current_dir==3) current_dir =2;
				else if(current_dir==0) current_dir =1;
				break;
			case 4:
				count++;
				if(current_dir==1) current_dir =2;
				else if(current_dir==3) current_dir =0;
				else if(current_dir==0) current_dir =1;
				else if(current_dir==2) current_dir =3;
				break;
			case 5:

				count++;
				if(current_dir==0) current_dir =1;
				else if(current_dir==1) current_dir =0;
				else if(current_dir==2) current_dir =3;
				else if(current_dir==3) current_dir =2;
				break;
			//웜홀	
			default :
				for(int c=1; c<=N; c++) {
					boolean f2= false;
					for(int r=1; r<=N; r++) {
						if(Map[c][r] == Map[ci][cj] && (c!=ci || r != cj)) {
							ci=c;
							cj=r;
							f2 =true;
							break;
						}
						
					}
					if(f2)
						break;
				}
			}
			
			if(flag)
				break;
		}
	
		Map[i][j]=0;
		if(count >Max) Max = count;
	}
	public static void main(String args[]) throws Exception{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			Max=0;

			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					Map[i][j] = sc.nextInt();
				}
			}
			//테두리
			for(int i=0; i<=N+1; i++) {
				Map[0][i] =5;
				Map[N+1][i]=5;
				Map[i][0]=5;
				Map[i][N+1]=5;
			}
			
			
			for(int i=1; i<=N; i++) {
				for(int j =1; j<=N; j++) {
					if(Map[i][j]==0) {
						for(int k=0; k<4; k++) {
							shout(k,i,j);
						}	
					}
				}
			}
			
			
			System.out.println("#"+test_case+" "+Max);

		}
	}
}