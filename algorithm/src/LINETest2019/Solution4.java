package LINETest2019;

import java.util.Scanner;

public class Solution4 {
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] Building = new int[N];
		for(int i=0; i<N; i++)
			Building[i] = sc.nextInt();
		int Max = 0;
		for(int i=0; i<N-1; i++) {
			int currentMax =0;
			for(int j=i+1; j<N;j++) {
				if(currentMax < Building[j]) {
					if( Max < j-i)
						Max = j-i;
					
					if(Building[i] <=Building[j]) {
						break;
					}
					
					currentMax = Building[i];
				}
			}
		}

		
		System.out.println(Max);
	}
}
