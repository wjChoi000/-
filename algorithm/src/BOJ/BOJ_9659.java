package BOJ;

import java.util.Scanner;

public class BOJ_9659{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		
		int size = s.length();
		int N = s.charAt(size-1)-'0';
		if(size ==1 && N <= 3)
			System.out.println("SK");
		else if(N%2==1)
			System.out.println("SK");
		else
			System.out.println("CY");
		
		return;
	}
}
