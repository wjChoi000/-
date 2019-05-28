package h_2019_1;

import java.util.Scanner;

/*
 * ���� n�� �־���, ���� n�� ���ų� ū �� �߿� �Ʒ��� ������ �����ϴ� ���� ����Ͻÿ�
 * n�� ¦�� �ڸ� ����(abcdef)�̴�. ex) 10,1000,100000
 * n�� �ڸ����� �������� ������. abc,def
 * �̶� a*b*c = d*e*f�� �����ϴ� �ּ� ���ڴ�?
 */
public class Problem1 {

	
	static public void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		//�ڸ����� ����ϴ� �ڵ��Դϴ�.
		int count=0,tmp=n;
		while(tmp>0) {
			tmp /=10;
			count++;
		}
		//Ȧ�� �ڸ��� ���  ������ ¦���� �ڸ����� ù ���ڰ� �����Դϴ�.
		if(count%2==1) {
			n=1;
			for(int i=0;i<count;i++)
				n *=10;
			System.out.println(n);
			return;
		}
		//¦�� �ڸ��� ��� ���ڸ� ���� ��Ű�� �� ���ڰ� �� ������ �����ϴ��� �Ǵ��մϴ�.
		while(true) {
			int m=1;
			//�ڸ����� �������� ������ ���� m�Դϴ�.
			for(int i=0;i<count/2;i++) {
				m *=10;
			}
			//�ڸ��� ������ ������ �� �ڸ����� ���մϴ�.
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
