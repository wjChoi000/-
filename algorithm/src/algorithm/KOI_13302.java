package algorithm;

import java.util.Arrays;
import java.util.Scanner;


//hint dp[i][j]: i~n번째 날에 쿠폰 j개를 가지고 가능한 리조트에 모두 입장하기 위한 비용의 최솟값;

public class KOI_13302 {

	static int[] price = {10000,25000,37000};
	static int MAX_N = 110; // 최대 날짜
	static int MAX_C = 44;//최대 쿠폰 개수 
	static int MAX_INT = 0x07FFFFFF;
	
	static int[][] dp= new int[MAX_N+5][MAX_C];
	static int schedule[] = new int[MAX_N+1];
	private static Scanner scan;
	
	public static void main(String str[]) {
		
		
		scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		//init
		for(int i =0; i<=MAX_N; i++) {
			schedule[i]=0;
		}
		for(int i=0; i <= MAX_N; i++)
			for(int j =0; j<MAX_C; j++)
				dp[i][j] = MAX_INT;
		
		//no day
		for(int i =0; i<m; i++) {
			int temp = scan.nextInt();
			schedule[temp] = -1;
		}
		
		//solution
		dp[0][0] = 0;
		for(int i =0; i<n; i++) {
			
			for(int j =0; j<MAX_C; j++) {
			
				if(dp[i][j] == MAX_INT)
					continue;
				
				if(schedule[i+1] ==-1) {
					if( dp[i+1][j] > dp[i][j])
						dp[i+1][j] =dp[i][j];
				}else {
					if(dp[i+1][j]>dp[i][j]+price[0])
						dp[i+1][j] = dp[i][j]+price[0];
					if(dp[i+3][j+1]>dp[i][j]+price[1])
						dp[i+3][j+1] = dp[i][j]+price[1];
					if(dp[i+5][j+2] > dp[i][j]+price[2])
						dp[i+5][j+2] = dp[i][j]+price[2];
					if( j >= 3)
						if( dp[i+1][j-3] >dp[i][j])
							dp[i+1][j-3] = dp[i][j];
				}
			
			}
			
		}
		Arrays.sort(dp[n]);
		System.out.println(dp[n][0]);
	}


}

//solution
//		dp[0][0] = 0;
//		for(int i =1; i<=n; i++) {
//			int max_coupon = (i/5)*2 +(i%5)/3 ;
//			for(int j =0; j<=max_coupon; j++) {
//				if(schedule[i] != -1) {				
//					int[] list = {MAX_INT,MAX_INT,MAX_INT,MAX_INT};
//					
//					list[0] = dp[i-1][j]+price[0];
//				
//					if(i>=3 && j>=1)
//							list[1] = dp[i-3][j-1] +price[1];
//					
//					if(i>=5 && j>=2)
//							list[2] = dp[i-5][j-2]+price[2];
//					
//					//쿠폰 연속 사용
//					for(int k = 1; k <= max_coupon/3; k++) {
//						if(j+3*k > 40)
//							break;
//						if(list[3] >dp[i-1][j+3*k])
//							list[3] = dp[i-1][j+3*k];
//					}
//					
//					Arrays.sort(list);
//					dp[i][j] = list[0];
//				}
//				else {
//					dp[i][j] = dp[i-1][j];
//				}
//						
//			}
//
//		}
//	
//		Arrays.sort(dp[n]);
//		System.out.println(dp[n][0]);


//	static void printDP(int n) {
//		for(int i =0; i<=n; i++ ) {
//			System.out.print("["+i+"]");
//			for(int j=0; j< 40; j++)
//				System.out.print(dp[i][j]+"\t");
//			System.out.println("\n");
//		}
//		
//	}
	
//static int resort(int now, int coupon, int current_price, int vacation, int[] schedule) {
//		
//		int i;
//		
//		for(i = now; i<vacation;i++) {
//			
//			if(schedule[i] == 0){
//				break;
//			}else {
//				now++;
//			}
//		}
//		
//		if(now  < vacation) {
//			
//			int one_price = 0x7FFFFFFF;
//			int three_price = 0x7FFFFFFF;
//			int five_price = 0x7FFFFFFF;
//						
//			if(coupon>=3) {
//				one_price = resort(now+1, coupon-3, current_price, vacation, schedule);				
//			}
//			else {
//				one_price = resort(now+1, coupon, current_price+price[0], vacation, schedule);
//			}
//			three_price = resort(now+3, coupon+1, current_price+price[1], vacation, schedule);
//		
//			five_price = resort(now+5, coupon+2, current_price+price[2], vacation, schedule);
//			
//			//최소값 선택
//			int min_price = 0;
//			if(one_price < three_price) {
//				min_price = one_price;
//			}else {
//				min_price = three_price;
//			}
//			if( min_price > five_price) {
//				min_price = five_price;
//			}
//			
//			return min_price;
//		}
//		else {
//			return current_price;
//		}
//		
//	}

	
	

