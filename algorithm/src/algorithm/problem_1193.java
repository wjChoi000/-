package algorithm;

import java.util.Scanner;

public class problem_1193 {
	public static void main(String[] str) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int i =1, count=0, dif=0;;
		while(true) {
			count = count+ i; 
			if(count >= num) {
				dif = count - num;
				//System.out.println(dif+", "+ count+", "+num+", " +i);
				break;
			}
			else
				i++;
		}
		//¦��
		if(i%2 ==0) {
			int u2= dif+1,u1 = i-dif;
			System.out.println(u1+"/"+ u2);
		}
		//Ȧ��
		else {
			int u1= dif+1,u2 = i-dif;
			System.out.println(u1+"/"+ u2);
		}
	}
}
