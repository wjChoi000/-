package h_2019_1;

import java.util.Scanner;

/*
 * 숫자 n이 주어짐, 숫자 n과 같거나 큰 수 중에 아래의 조건을 만족하는 수를 출력하시오
 * n은 짝수 자리 숫자(abcdef)이다. ex) 10,1000,100000
 * n을 자릿수를 절반으로 나눈다. abc,def
 * 이때 a*b*c = d*e*f를 만족하는 최소 숫자는?
 */
public class Problem1 {

	
	static public void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		//자릿수를 계산하는 코드입니다.
		int count=0,tmp=n;
		while(tmp>0) {
			tmp /=10;
			count++;
		}
		//홀수 자리일 경우  무조건 짝수의 자릿수의 첫 숫자가 정답입니다.
		if(count%2==1) {
			n=1;
			for(int i=0;i<count;i++)
				n *=10;
			System.out.println(n);
			return;
		}
		//짝수 자리일 경우 숫자를 증가 시키며 각 숫자가 위 조건을 만족하는지 판단합니다.
		while(true) {
			int m=1;
			//자리수를 절반으로 나누기 위한 m입니다.
			for(int i=0;i<count/2;i++) {
				m *=10;
			}
			//자리를 반으로 나누고 각 자릿수를 곱합니다.
			int left= n/m,right= n%m;
			int leftMult=1, rightMult=1;
			for(int i=0; i<count/2; i++) {
				leftMult *= left%10;
				left /=10;
				rightMult *= right%10;
				right /=10;
			}			
		
			if(leftMult == rightMult) {
				System.out.println(n);
				break;
			}
			n++;
		}
		
		return;
	}
}
