package BOJ;

import java.util.Scanner;
import java.util.Stack;




public class BOJ_16637 {
	
	static int calculate(String str, int size) {
		Stack<Integer> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		st1.push(str.charAt(size-1)-'0');
		
		for(int i=size-2; i>=0 ; i-=2) {
			st1.push(str.charAt(i-1)-'0');
			st2.push(str.charAt(i));
		}
		int sum = 0;
		
		int v1=st1.pop(), v2;
		char op1, op2 = st2.pop();
		
		while(!st2.isEmpty()) {
			
			switch(st2.pop()) {
			case '+':
				sum+=st1.pop();
				break;
			case '-':
				sum-=st1.pop();
				break;
			case '*':
				sum*=st1.pop();
				break;
			
			
			}
		}
		
		return sum;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String str = sc.next();
		sc.close();
		
		
		System.out.println(calculate(str,size));
		
		
		return;
	}
}
