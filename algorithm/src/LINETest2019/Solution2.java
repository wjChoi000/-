package LINETest2019;

import java.util.Scanner;

public class Solution2 {
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        

        String[] element = new String[10];

        int[] number = new int[10];
        int size = s.length(), esize=0, lsize=0;        
        
        for(int i=0; i<size; i++) {
        	char a = s.charAt(i);
        	if(a >='A' && a<='Z') {
        		element[esize] = a+"";
        		esize++;
        	}
        	else if(a >='a'&& a<='z') {
        		element[esize-1] +=a;
        	}
        	else if(a>'0' && a<='9') {
        		number[lsize] = a-'0';
        		lsize++;
        	}
        }
        
        if(esize != lsize)
        	System.out.println("error");
        else {
        	for(int i=0; i<lsize; i++) {
        		System.out.print(element[i]);
        		if(number[i]>1)
        			System.out.print(number[i]);
        	}
        }
	}
}
