package SK_2018_spring;

import java.util.Scanner;

/*
 * ����
 * ������ ������ �ִ� �ð� K�� �־�����, �迭���� �� ������ ��� �ð��� ��� �ִ�.
 * �� �迭�� ����� ������ �ٸ� �����̴�.
 * ������ �߰��� ������ ������, �� 1�ʶ� ������ ���� ��� ������ ����ٰ� �Ǵ��Ѵ�.
 * �̶� K �ð����� ���� �� �ִ� �ִ� ������ ������?(���� ������ �ߺ����� �ʴ´�.)
 * input
 * 4 4
 * 2 2 2 2
 * output
 * 3
 */


//
//�� ������ �����Ѵٸ� ó���� ������ �߸� ���������� ū ���̴� ����
//�ߺ��� ����ؼ� ���� �� �ִ� �ִ� ������ ���� ����ؼ� �̿Ͱ��� �˰����� �L��.


//���ٹ��: ���Ʈ ���� �˰��� ���
//0�� ���� ~total-1�ʱ��� ������ �� �ִ� ��� �ð����� ���� �� �ִ� ������ ���� ����Ѵ�.
public class Problem2 {
	static public void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int k= sc.nextInt();
		int n= sc.nextInt();
		int list[]=new int[n];
		for(int i=0; i<n; i++) {
			list[i]=sc.nextInt();
		}
		sc.close();
		
		int total=0;
		for(int i=0; i<n; i++)
			total +=list[i];
		
		int m1 = k/total, m2 = k%total;
		
		int max=0;
		int current=m1*n;
		//������ ��� ������ ��� ��ġ���� ��� ������ ������ �ִ��� ����մϴ�.
		for(int t=0; t<total; t++) {

			int index=0, indexTime=0;
			int time=t;
			//������ ��� ��ų ��ġ�� ����մϴ�.
			while(time>0) {
				time -= list[index];
				index++;
			}
			//�߰����� ���ǽ� �����Ұ�츦 ����մϴ�.
			int count=0;
			if(time <0) {
				index++;
				indexTime = time;
				count++;
			}
			time = m2 + indexTime;
			//������ �ִ� ������ ���� ����մϴ�.
			while(time >0) {
				if(index >=n)
					index=0;
				count++;
				time -= list[index];
				index++;
			}
			
			//���� ū ���� ����
			if(max <current+count)
				max =current+count;
			if(max >=n) {
				max = n;
				break;
			}
		}		
		System.out.println(max);
		//�̰� ����Ʈ �ϲ��� ���������� �����δ� �ٸ��� Ǯ����
//		if(total <=k) {
//			System.out.println(n);
//			return;
//		}
//		int max=0;
//		for(int i=0;i<total; i++) {
//			int current =0;
//			int tmpk= k;
//			int index;
//			//���� ���
//			while(k >0) {
//				
//			}
//			
//			if(max <current)
//				max =current;
//		}
//		
//		System.out.println(max);
		
		
	}
	
	
	
}
