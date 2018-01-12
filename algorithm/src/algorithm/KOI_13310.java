package algorithm;

import java.util.Scanner;

// 시간 초과로 풀지 못함
public class KOI_13310 {
	

	private static Scanner scan;

	public static void main(String[] str) {
		scan = new Scanner(System.in);
		
		int maximum_day =0;
		int maximum_dis = 0x7fffffff;
		int i,j,k;
		
		int num_star = scan.nextInt();
		int day = scan.nextInt();
	
		int[][] point = new int[num_star][4];
		
		for(i=0; i<num_star;i++) {
			point[i][0] = scan.nextInt();
			point[i][1] = scan.nextInt();
			point[i][2] = scan.nextInt();
			point[i][3] = scan.nextInt();
		}
		
		//거리 계산
		for(i=0; i<=day; i++) {
			int temp_max=0;
			for(j =0; j<num_star-1; j++) {
				for(k = j+1; k<num_star; k++) {
					int dif_x = point[j][0] + i* point[j][2] - point[k][0] - i* point[k][2];
					int dif_y = point[j][1] + i* point[j][3] - point[k][1] - i* point[k][3];
					int dis = dif_x*dif_x + dif_y*dif_y;
					//현재 가장 멀리 떨어진별
					if(temp_max<dis) {
						temp_max = dis;
						if(temp_max>maximum_dis)
							break;
					}
				}
			}
			
			if(temp_max < maximum_dis) {
				maximum_dis = temp_max;
				maximum_day = i;
			}
		}
		System.out.println(maximum_day);
		System.out.println(maximum_dis);
	}
}
