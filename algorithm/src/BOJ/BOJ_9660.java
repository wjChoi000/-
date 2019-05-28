package BOJ;

import java.util.Scanner;

public class BOJ_9660 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long N= sc.nextLong();
		sc.close();
	
			switch((int)N%7) {
			case 0:
			case 2:
				System.out.println("CY");
				break;
			case 1:
			case 3:
			case 4:
			case 5:
			case 6:
				System.out.println("SK");
				break;
			}
		return;
	}
}
