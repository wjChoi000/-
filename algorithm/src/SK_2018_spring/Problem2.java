package SK_2018_spring;

import java.util.Scanner;

/*
 * 문제
 * 음악을 들을수 있는 시간 K가 주어지고, 배열에는 각 음반의 재생 시간이 담겨 있다.
 * 각 배열에 저장된 음반은 다른 음반이다.
 * 음악은 중간에 들을수 있으며, 단 1초라도 음악을 들을 경우 음악은 들었다고 판단한다.
 * 이때 K 시간동안 들을 수 있는 최대 음반의 갯수는?(같은 음반은 중복되지 않는다.)
 * input
 * 4 4
 * 2 2 2 2
 * output
 * 3
 */


//
//이 문제를 리뷰한다면 처음에 문제를 잘못 접근했지만 큰 차이는 없다
//중복을 고려해서 들을 수 있는 최대 음악의 수를 계산해서 이와같은 알고리즘을 짲다.


//접근방법: 브루트 포스 알고리즘 사용
//0초 부터 ~total-1초까지 시작할 수 있는 모든 시간에서 들을 수 있는 음악의 수을 계산한다.
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
		//음악이 재생 가능한 모든 위치에서 몇개의 음악을 들을수 있는지 계산합니다.
		for(int t=0; t<total; t++) {

			int index=0, indexTime=0;
			int time=t;
			//음악을 재생 시킬 위치를 계산합니다.
			while(time>0) {
				time -= list[index];
				index++;
			}
			//중간에서 음악시 시작할경우를 계산합니다.
			int count=0;
			if(time <0) {
				index++;
				indexTime = time;
				count++;
			}
			time = m2 + indexTime;
			//들을수 있는 음악의 수를 계산합니다.
			while(time >0) {
				if(index >=n)
					index=0;
				count++;
				time -= list[index];
				index++;
			}
			
			//가장 큰 값을 갱신
			if(max <current+count)
				max =current+count;
			if(max >=n) {
				max = n;
				break;
			}
		}		
		System.out.println(max);
		//이게 베스트 일껄로 예상하지만 실제로는 다르게 풀었음
//		if(total <=k) {
//			System.out.println(n);
//			return;
//		}
//		int max=0;
//		for(int i=0;i<total; i++) {
//			int current =0;
//			int tmpk= k;
//			int index;
//			//음악 듣기
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
