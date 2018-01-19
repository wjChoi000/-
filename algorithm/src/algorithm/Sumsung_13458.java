package algorithm;

import java.util.Scanner;

public class Sumsung_13458 {

	static Scanner scan;
	
	public static void main(String str[]) {
		
		//input
		scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = scan.nextInt();
		}
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		
		//solution
		long result = 0;//Áß¿ä!
		for(int i=0; i <N; i++) {
			if(A[i]>0)
			{
				A[i] =  A[i]-B;
				result++;
			}
			if(A[i] >0) {
				if(A[i]%C ==0) {
					result = result+(A[i]/C);
				}else {
					result = result+(A[i]/C)+1;
				}
			}
		}
		
		//output
		System.out.println(result);
	}
}
