package BOJ;

import java.util.Scanner;

public class BJO_11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int size = s.length();
		for(int i=1; i<=size; ++i){
			System.out.print(s.charAt(i-1));
			if(i%10==0) {
				System.out.println();
			}
				
		}
	}
}
