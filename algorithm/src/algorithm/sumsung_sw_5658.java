package algorithm;
import java.util.Scanner;
import java.util.Arrays;
public class sumsung_sw_5658{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			String s = sc.next();
			int n = N/4;
			
			long[] n_list = new long[N+n];
			
			for(int i =0; i< N; i++) {
				 char g = s.charAt(i);
				 if(0 <=(int)g-48 && (int)g -48 <10) {
					 n_list[i] = (int)g-48; 
				 }
				 else {
					n_list[i] = (int)g-55;
				 }
				
			}
			for( int i =0; i<n; i++) {
				n_list[N+i] = n_list[i];
			}
			
			long[] chance = new long[N];

			for(int i = 0; i<N; i++) {
				long current =0;
				long multi =1;
				for(int j=n-1; j>=0; j--) {
					current = current+ n_list[i+j]*multi;
					multi = multi*16;
				}
				chance[i] =current;
			}
			
			Arrays.sort(chance);
		
			int index=N-1;
			for(int i=K-1; i>0; i--) {
				if(chance[index] !=chance[index-1])
					index--;
				else {
					
					while(chance[index]== chance[index-1]) {
						index--;
					}
					index--;
				}
			}
			System.out.println("#"+test_case+" "+chance[index]);
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}
