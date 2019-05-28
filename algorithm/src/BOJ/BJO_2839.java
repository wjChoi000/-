package BOJ;

import java.util.Scanner;

public class BJO_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		if(k ==4 || k==7) {
			System.out.println("-1");
		}else {
			switch(k%5) {
			case 0:
				System.out.println(k/5);
				break;
			case 1:
			case 3:
				System.out.println(k/5+1);
				break;
			case 2:
			case 4:
				System.out.println(k/5+2);
				break;
			}
		}
	}
}
