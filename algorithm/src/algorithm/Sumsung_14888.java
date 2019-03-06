package algorithm;

import java.util.Scanner;

public class Sumsung_14888 {
		static int max = -1000000000;
		static int min = 1000000000;
		static int n_size =0;
		static void add(int[] n, int[] m, int index, int current, int q, int w, int e,int r) {
			if(index >= n_size) {
//				System.out.println("current "+current);
				if(current > max)
					max = current;
				if(current <min)
					min = current;
			
			}else {
//				System.out.println("index= "+index+", current "+current+",q="+q+",w="+w+",e="+e+",r="+r);
				int next = 0;
				
				if(m[0] >q) {
						next = current +n[index];
						add(n,m,index+1,next,q+1,w,e,r);
					}
				if(m[1] >w) {
						next = current -n[index];
						add(n,m,index+1,next,q,w+1,e,r);	
					}
				if(m[2]>e) {
						next = current * n[index];
						add(n,m,index+1,next,q,w,e+1,r);	
					}
				if(m[3]>r) {
						next = current / n[index];
						add(n,m,index+1,next,q,w,e,r+1);	
				}
			}
			
		}
		
		public static void main(String arg[]) {
			Scanner scan = new Scanner(System.in);
			
			int[] N = new int[11];
			int[] M = new int[4];
			
			n_size = scan.nextInt();
			for(int i=0; i<n_size; i++) {
				N[i]= scan.nextInt();
			}
			int m =0;
			for(int i =0; i<4; i++) {
				M[i] = scan.nextInt();
				m = m+ M[i];
			}
			
			add(N, M,  1, N[0], 0, 0, 0,0);
			
			System.out.println(max);
			System.out.println(min);
		
		}
}
