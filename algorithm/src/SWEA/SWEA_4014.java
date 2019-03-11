package SWEA;

import java.util.Scanner;

public class SWEA_4014 {
	
	static int N, X;
	static int[][] Map = new int[20][20];
	static int[][] y = new int[20][20];
	
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
			//����
			for(int i=0;i<N; i++) {

				int j=0;
				boolean flag = true;
				for(; j<N;j++) {
					//��
				
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
			//����
			for(int j=0; j<N;j++) {
				
				int i=0;
				boolean flag = true;
				for(; i<N;i++) {
					//��
				
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
