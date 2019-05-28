package BOJ;

import java.util.Scanner;

public class BJO_10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] list = new int[3];
		list[0] =sc.nextInt();
		list[1] = sc.nextInt();
		list[2] = sc.nextInt();
		sc.close();
		
		for(int i=0; i<2; i++) {
			for(int j=i+1; j<3; j++) {
				if(list[i]>list[j]) {
					int temp = list[j];
					list[j]=list[i];
					list[i]= temp;
				}
			}
		}
		System.out.println(list[1]);
		
	}
}
