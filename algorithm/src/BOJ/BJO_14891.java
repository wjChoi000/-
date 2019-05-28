package BOJ;

import java.util.Scanner;

public class BJO_14891 {
	static int S=1, N=0,K, result;
	static int[][] Map = new int[4][8], list_K = new int[100][2];
	
	static int score() {
		int sum=0;
		int m=1;
		for(int i=0; i<4; i++) {
			if(Map[i][0]==S)
				sum += m;
			m *=2;
		}
		return sum;
	}
	static void rotation_r(int k) {
		int i=k-1;
		int temp = Map[i][0];
		Map[i][0] = Map[i][7];
		Map[i][7] = Map[i][6];
		Map[i][6] = Map[i][5];
		Map[i][5] = Map[i][4];
		Map[i][4] = Map[i][3];
		Map[i][3] = Map[i][2];
		Map[i][2] = Map[i][1];
		Map[i][1] = temp;
	}
	static void rotation_l(int k) {
		int i=k-1;
		int temp = Map[i][0];
		Map[i][0] = Map[i][1];
		Map[i][1] = Map[i][2];
		Map[i][2] = Map[i][3];
		Map[i][3] = Map[i][4];
		Map[i][4] = Map[i][5];
		Map[i][5] = Map[i][6];
		Map[i][6] = Map[i][7];
		Map[i][7] = temp;
	}
	static void rotation(int k) {
		//회전
		boolean[] state = new boolean[3]; // 같으면 false 다르면 true
		
		for(int i=0; i<3; i++) {
			if(Map[i][2] == Map[i+1][6])
				state[i] = false;
			else
				state[i] = true;
		}
		
		switch(list_K[k][0]) {
		case 1:
			//시계
			if(list_K[k][1]==1) {
				rotation_r(1);
				if(state[0]) {
					rotation_l(2);
					if(state[1]) {
						rotation_r(3);
						if(state[2])
							rotation_l(4);
					}
				}
			}else {
				//반시계
				rotation_l(1);
				if(state[0]) {
					rotation_r(2);
					if(state[1]) {
						rotation_l(3);
						if(state[2])
							rotation_r(4);
					}
				}
			}
			break;
		case 2:
			if(list_K[k][1]==1) {
				//시계
				rotation_r(2);
				if(state[0])
					rotation_l(1);
				if(state[1]) {
					rotation_l(3);
					if(state[2])
						rotation_r(4);
				}
			}else {
				//반시계
				rotation_l(2);
				if(state[0])
					rotation_r(1);
				if(state[1]) {
					rotation_r(3);
					if(state[2])
						rotation_l(4);
				}
				
			}
			
			break;
		case 3:
			if(list_K[k][1]==1) {//시계
				rotation_r(3);
				
				if(state[2])
					rotation_l(4);
				if(state[1]) {
					rotation_l(2);
					if(state[0])
						rotation_r(1);
				}
				
			}else{//반시계
				rotation_l(3);
				
				if(state[2])
					rotation_r(4);
				if(state[1]) {
					rotation_r(2);
					if(state[0])
						rotation_l(1);
				}
			}
			break;
		case 4:
			if(list_K[k][1]==1) {//시계
				rotation_r(4);
				if(state[2]) {
					rotation_l(3);
					if(state[1]) {
						rotation_r(2);
						if(state[0])
							rotation_l(1);
					}
				}
			}else {
				//반시계
				rotation_l(4);
				if(state[2]) {
					rotation_r(3);
					if(state[1]) {
						rotation_l(2);
						if(state[0])
							rotation_r(1);
					}
				}
			}
			break;
		}
		
	}
	
	
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		
		result=0;
		
		for(int i=0; i<4; i++) {
			int t= sc.nextInt();
			for(int j=0; j <8; j++) {
				Map[i][7-j] = t%10;
				t =t/10;
			}
		}
			

			
		K = sc.nextInt();

		for(int i=0; i<K; i++) {
			list_K[i][0] = sc.nextInt();
			list_K[i][1] = sc.nextInt();
		}

		for(int i=0; i<K; i++) {
			rotation(i);
		}
		//계산 
		result = score();
			
		System.out.println(result);
		
	}
}
