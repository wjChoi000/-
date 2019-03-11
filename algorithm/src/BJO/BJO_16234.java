package BJO;

import java.util.Scanner;
import java.util.Stack;

public class BJO_16234 {
	static int N,L,R;
	static int Map[][];
	static int visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		L=sc.nextInt();
		R = sc.nextInt();
		Map = new int[N][N];
		visited = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				Map[i][j] = sc.nextInt();
				visited[i][j]=0;
			}
		}
		boolean flag = true;
		int t=0;
		for(t=0; t<=2000; t++) {
			
			//국경을 연다.
			int section=1;
			for(int i=0; i<N;i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]==0) {
						Stack<Integer[]> st = new Stack<>();
						Integer[] v = {i,j};
						visited[i][j] =section;
						st.push(v);
						while(!st.isEmpty()) {
							Integer[] current = st.pop();
							int r= current[0], c=current[1];
							
							//top
							if(r>0&& visited[r-1][c]==0) {
								int dif = Math.abs(Map[r][c] - Map[r-1][c]);
								if(dif>=L &&dif<=R) {
									Integer[] new_v = {r-1,c};
									visited[r-1][c]=section;
									st.push(new_v);
								}
							}
							//bottom
							if(r<N-1&& visited[r+1][c]==0) {
								int dif = Math.abs(Map[r][c] - Map[r+1][c]);
								if(dif>=L &&dif<=R) {
									Integer[] new_v = {r+1,c};
									visited[r+1][c]=section;
									st.push(new_v);
								}
							}
							//left
							if(c>0&& visited[r][c-1]==0) {
								int dif = Math.abs(Map[r][c] - Map[r][c-1]);
								if(dif>=L &&dif<=R) {
									Integer[] new_v = {r,c-1};
									visited[r][c-1]=section;
									st.push(new_v);
								}
							}
							//right
							if(c<N-1&& visited[r][c+1]==0) {
								int dif = Math.abs(Map[r][c] - Map[r][c+1]);
								if(dif>=L &&dif<=R) {
									Integer[] new_v = {r,c+1};
									visited[r][c+1]=section;
									st.push(new_v);
								}
							}
						}
						section++;
					}	
				}
			}
			//변화가 없는경우
			if(section > N*N)
				break;
			// 인구 이동
			int[][] sum_section = new int[section][2];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sum_section[visited[i][j]][0] += Map[i][j];
					sum_section[visited[i][j]][1]++;
				}
			}
			for(int i=1; i<section;i++) {
				sum_section[i][0] = sum_section[i][0]/sum_section[i][1];
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					Map[i][j] = sum_section[visited[i][j]][0];
					visited[i][j]=0;
				}
			}
			
//			for(int s=1; s<section; s++) {
//				int sum =0, count=0;
//				for(int i =0; i<N; i++) {
//					for(int j=0; j<N;j++) {
//						if(visited[i][j]==s) {
//							sum +=Map[i][j];
//							count++;
//						}
//					}
//				}
//				sum = sum/count;
//				
//				for(int i =0; i<N; i++) {
//					for(int j=0; j<N;j++) {
//						if(visited[i][j]==s) {
//							Map[i][j]=sum;
//						}
//					}
//				}
//			}
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N;j++) {
//					visited[i][j]=0;
//				}
//			}
		}
		System.out.println(t);
	}
}
