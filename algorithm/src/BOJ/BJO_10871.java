package BOJ;

import java.util.Scanner;

public class BJO_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M= sc.nextInt();
		int[] list = new int[N];
		for(int i=0;i<N; i++)
			list[i]=sc.nextInt();
		sc.close();
		for(int i=0; i<N;i++)
			if(list[i]<M)
				System.out.print(list[i]+" ");
	}
}
