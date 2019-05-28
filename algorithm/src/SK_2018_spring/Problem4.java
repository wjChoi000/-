package SK_2018_spring;

import java.util.Scanner;

/*
 * 문제:
 * 입력은 크기 K, 배열의 개수 N과 N개의 배열이 주어진다.
 * 배열은 swap을 통해서 움직일수 있다.
 * 이때 배열의 좌우 인접한 값이 k이하로 배열을 재 정렬할때 최소한으로 swap되는 횟수를 출력하시오 
 * input
 * 2 4
 * 1 5 7 3
 * output
 * 2
 * 
 */


//문제의 기본적인 접근 방법 백트래킹 방법을 사용하여 모든 경우의 수를 탐색합니다.
public class Problem4 {

	static int count=0, max= -1, n =0, k=0;
	static boolean flag = false;
	static int list[] = new int[8];
	
	//swap하는 함수
	static void swap(int i, int j) {
		int tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
	
	//k 조건을 만족하는지 확인한다.
	static boolean isValid() {
		for(int i=0; i<n-1;i++)
			if( Math.abs(list[i]-list[i+1])>k)
				return false;
		return true;
	}
	
	//배열의 교환을 그래프로 생각하여 깊이 우선 탐색으로 문제를 해결합니다.
	static void dfs(int depth) {
		//조건을 만족하면 종료
		if(isValid()) {
			if(count > max)
				max =count;
			return;
		}
		//n보다 깊어지면 종료 혹은 swap횟수가 depth를 넘어가면 종료
		//백트래킹으로 배열의 모든 경우의 수를 탐색하기 위해서는 8번을 교환하면 가능합니다.
		if(depth == n ||( max > 0 && max<=depth)) {
			return;
		}
		//현재 
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
		
		//접근 방법 : 가능한 모드 교환의 경우의 수를 판단합니다.
		//
		dfs(0);
		
		System.out.println(max);
		
		
	}
}
