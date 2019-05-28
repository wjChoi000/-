package BOJ;

import java.util.Scanner;

public class BJO_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		String s = sc.next();
		sc.close();
		int result=0;
		for(int i=0;i<N;++i) {
			result += s.charAt(i)-'0';
		}
			
		System.out.println(result);
	}
}
