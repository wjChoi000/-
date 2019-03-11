package BJO;

import java.util.ArrayList;
import java.util.Scanner;

public class BJO_16235 {

	static int N,M,K;
	static int[][] Energy, Map, Dead;
	static int[] dy = {-1,-1,-1, 0, 1, 1, 1, 0};
	static int[] dx = {-1, 0, 1, 1, 1, 0,-1,-1}; 
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M= sc.nextInt(); // ��������
		K = sc.nextInt();// ���
		
		Energy = new int[N][N];
		Map = new int[N][N];
		Dead = new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++) {
				Energy[i][j] = 5;
				Map[i][j] = sc.nextInt();
				Dead[i][j]=0;
			}
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<N*N;i++) {
			ArrayList<Integer> l = new ArrayList<>();
			list.add(l);
			
		}
		
		for(int m=0; m<M; m++) {
			int i=sc.nextInt()-1;
			int j=sc.nextInt()-1;
			Integer a =sc.nextInt();
			int index = i*N + j;

			list.get(index).add(a);
			
		}
		
		for(int k=0; k<K; k++) {
			//�� : ����� ����, ���̰� �����, �������� ����
			for(int i=0; i<N;i++) {
				for(int j=0; j<N; j++) {
					int index = i*N+j;
					ArrayList<Integer> current = list.get(index);
					//������ ������
					if(!current.isEmpty()) {
						int size = current.size();
						for(int s =size-1; s>=0; s--) {
							Integer tree = current.get(s);
							//����
							if(Energy[i][j] <tree) {
								Dead[i][j] = tree/2;
								current.remove(s);
							}else {
								Energy[i][j] -= tree;
								current.add(s,tree+1);
								current.remove(s+1);
							}
								
						}
					}
				}
			}
			//���� : ���� ������ ����̵�, ��������/2
			for(int i=0; i<N;i++)
				for(int j =0; j<N; j++) {
					Energy[i][j] += Dead[i][j];
					Dead[i][j] = 0;
				}
			//���� : ����, 5�� ����� ����, ���� 8ĭ
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++) {
					int index = i*N+j;
					ArrayList<Integer> current = list.get(index);
					if(!current.isEmpty()) {
						int size = current.size();
						for(int s=0; s<size;s++) {
							Integer tree = current.get(s);
							if(tree%5==0) {
								//����
								for(int r=0; r<8; r++) {
									int ny = i+dy[r];
									int nx = j+dx[r];
									if( 0<=ny && 0<=nx && ny<N &&nx<N) {
										int newIndex = ny*N+nx;
										list.get(newIndex).add(1);
									}
										
								}

							}
						}
					}
				}
			}
			
			
			//�ܿ� : ��� �߰�
			for(int i=0; i<N;i++)
				for(int j =0; j<N; j++) {
					Energy[i][j] += Map[i][j];
				}
		}
		
		int num=0;
		for(ArrayList<Integer> l :list) {
			num += l.size();
		}
		
		System.out.println(num);
	}
}
