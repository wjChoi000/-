package SWEA;

import java.util.Scanner;

public class SWEA_4014 {
	
	static int N, X;
	static int[][] Map = new int[20][20];
	static int[][] y = new int[20][20];
	
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			
			N = sc.nextInt();
			X = sc.nextInt();
			
			for(int i=0; i<N+0; i++)
				for(int j =0; j<N+0;j++) {
					Map[i][j] = sc.nextInt();
					y[i][j]=0;
				}
			
			int count =0;
			//세로
			for(int i=0;i<N; i++) {

				int j=0;
				boolean flag = true;
				for(; j<N;j++) {
					//위
				
					if(j+1 < N &&Map[i][j] == Map[i][j+1]-1 ){			
						if(j-X >=-1) {
							for(int k=0; k<X;k++)
								if(Map[i][j] != Map[i][j-k] || y[i][j-k]==1)
									flag =false;
							for(int k=0; k<X;k++)
								y[i][j-k]=1;
						}
						else flag = false;
					}
					else if( j+1 < N && Map[i][j] == Map[i][j+1]+1) {
						if( j+X <N) {
							for(int k=0; k<X; k++)
								if( Map[i][j+1] != Map[i][j+1+k] || y[i][j+1+k]==1)
									flag = false;
							for(int k=0; k<X;k++)
								y[i][j+1+k]=1;
						}else flag =false;
						
					}
					else if( j+1 == N||Map[i][j] == Map[i][j+1]) {
						
					}else {
						flag =false;
					}
					
					if(!flag)
						break;
				}
				if(flag) count++;
				
			}
			
			for(int r=0; r<N; r++)
				for(int c =0; c<N;c++) {
					y[r][c]=0;
				}
			//가로
			for(int j=0; j<N;j++) {
				
				int i=0;
				boolean flag = true;
				for(; i<N;i++) {
					//위
				
					if(i+1 < N &&Map[i][j] == Map[i+1][j]-1 ){			
						if(i-X >=-1) {
							for(int k=0; k<X;k++)
								if(Map[i][j] != Map[i-k][j] || y[i-k][j]==1)
									flag =false;
							for(int k=0; k<X;k++)
								y[i-k][j]=1;
							
						}
						else flag = false;
					}
					else if(i+1 < N && Map[i][j] == Map[i+1][j]+1) {
						if( i+X <N) {
							for(int k=1; k<X; k++)
								if( Map[i+1][j] != Map[i+1+k][j] || y[i+1+k][j]==1)
									flag = false;
							for(int k=0; k<X;k++)
								y[i+1+k][j]=1;
						}else flag =false;
						
					}
					else if(i+1 == N || Map[i][j] == Map[i+1][j]) {
						
					}else {
						flag =false;
					}
					
					if(!flag)
						break;
				}
				if(flag) count++;
			}
			
			System.out.println("#"+test_case+" "+count);
			

		}
	}
}
