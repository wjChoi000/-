package LINETest2019;

import java.util.Scanner;

public class Solution1 {

	
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        long N = sc.nextLong();
        long Min =Long.MAX_VALUE;

        for(long W=1; W<=Math.sqrt(N);W++) {
        	if(N%W== 0) {
        		long H = N/W;
        		if(Min >Math.abs(W-H)) {
        			Min = Math.abs(W-H);

        		}
        	}
        		
        }
        System.out.println(Min);

	}
}
