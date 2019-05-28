package SK_2018_spring;

import java.util.Scanner;

/*
 * ����:
 * �Է��� ũ�� K, �迭�� ���� N�� N���� �迭�� �־�����.
 * �迭�� swap�� ���ؼ� �����ϼ� �ִ�.
 * �̶� �迭�� �¿� ������ ���� k���Ϸ� �迭�� �� �����Ҷ� �ּ������� swap�Ǵ� Ƚ���� ����Ͻÿ� 
 * input
 * 2 4
 * 1 5 7 3
 * output
 * 2
 * 
 */


//������ �⺻���� ���� ��� ��Ʈ��ŷ ����� ����Ͽ� ��� ����� ���� Ž���մϴ�.
public class Problem4 {

	static int count=0, max= -1, n =0, k=0;
	static boolean flag = false;
	static int list[] = new int[8];
	
	//swap�ϴ� �Լ�
	static void swap(int i, int j) {
		int tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
	
	//k ������ �����ϴ��� Ȯ���Ѵ�.
	static boolean isValid() {
		for(int i=0; i<n-1;i++)
			if( Math.abs(list[i]-list[i+1])>k)
				return false;
		return true;
	}
	
	//�迭�� ��ȯ�� �׷����� �����Ͽ� ���� �켱 Ž������ ������ �ذ��մϴ�.
	static void dfs(int depth) {
		//������ �����ϸ� ����
		if(isValid()) {
			if(count > max)
				max =count;
			return;
		}
		//n���� ������� ���� Ȥ�� swapȽ���� depth�� �Ѿ�� ����
		//��Ʈ��ŷ���� �迭�� ��� ����� ���� Ž���ϱ� ���ؼ��� 8���� ��ȯ�ϸ� �����մϴ�.
		if(depth == n ||( max > 0 && max<=depth)) {
			return;
		}
		//���� 
		dfs(depth+1);
		//
		for(int i=depth+1; i<n; i++) {
			count++;
			swap(depth, i);
			dfs(depth+1);
			swap(i, depth);
			count--;
		}
		
		
	}
	
	static public void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		for(int i=0; i<n;i++)
			list[i] = sc.nextInt();
		sc.close();
		
		//���� ��� : ������ ��� ��ȯ�� ����� ���� �Ǵ��մϴ�.
		//
		dfs(0);
		
		System.out.println(max);
		
		
	}
}
