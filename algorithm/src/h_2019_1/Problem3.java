package h_2019_1;
/*
 * BOJ 16638과 유사함, 대신 단한번만 괄호 사용가능
 * 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


//접근 방법: 모든 경우의 수를 계산하기 위해 브루트포스 알고리즘을 활용하여 괄호를 넣을 수 있는 모든 경우의 수를 찾고 최대값을 계산한다.
// 이때 inorder을 postorder 바꾸는 함수를 만들고 postorder을 계산하는 함수를 만들어 위의 문제를 해결한다.
public class Problem3 {
	
	/*
	 * 연산자의 우선 순위를 알려준다.
	 * oper1이 높으면  -1, 같으면 0, 낮으면 1;
	 */

	static int operationCompare(Character oper1, Character oper2) {
		switch(oper1) {
		case '(':
			return -1;
		case '+':
		case '-':
			switch(oper2) {
			case '+':
			case '-':
				return 0;
			case '(':
			case '*':
				return 1;
			}
		case '*':
			switch(oper2) {
			case '(':
				return 1;
			case '+':
			case '-':
				return -1;
			case '*':
				return 0;
			}
			
		}
		return -1;
	}
	/*
	 * inorder을 postorder로 변경한다.
	 */
	static char[] postorder(String str,int length) {
		Stack<Character> oper = new Stack<>();
		char str_postorder[] = new char[length];
		int index =0;		
		Character oper1=null;
		for(int i=0; i<length;i++) {
			Character c = str.charAt(i);
			switch(c) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				str_postorder[index++]=c;
				break;
			case '-':
			case '+':
			case '*':
				if(!oper.isEmpty()) {
					oper1= oper.pop();
					if(oper1=='(') {
						oper.push(oper1);
					}
					else if(operationCompare(c, oper1) >=0) {
						str_postorder[index++]=oper1;
					}
					else {
						oper.push(oper1);
					}
				}
				oper.push(c);
				break;
			case '(':
				oper.push(c);
				break;
			case ')':
				while(true) {
					oper1= oper.pop();
					if(oper1=='(')
						break;
					else
						str_postorder[index++]=oper1;
				}
				break;
			default:
				System.out.println("post order error");
				return null;
			}
		}
		while(!oper.isEmpty()) {
			str_postorder[index++]=oper.pop();
		}
		return str_postorder;
	}
	
	/*
	 * postorder을 계산한다.
	 */
	static int calculatePostorder(char[] str) {
		int length = str.length;
		
		Stack<Integer> var = new Stack<>();
		
		for(int i=0; i<length; i++) {
			switch(str[i]) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				var.push(str[i]-'0');
				break;
			case '-':
				var.push(var.pop()-var.pop());
				break;
			case '+':
				var.push(var.pop()+var.pop());
				break;
			case '*':
				var.push(var.pop()*var.pop());
				break;				
			}
			
		}
		
		
		return var.pop();
	}
	
	static public void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int length = str.length();
		sc.close();
		
		int max =0;
	
		//괄호를 삽입할 수 있는 모든 경우의 수를 계산한다.
		for(int i=0;i<length/2; i++) {
			
			for(int j=i; j<length/2; j++) {
				String new_str = "";
				if(i!=0) 
					new_str=str.substring(0, i*2);
				new_str +="("+str.substring(i*2,j*2+3)+")";
				
				if(j != length-1)
					new_str +=str.substring(j*2+3,length);
				
				char[] new_str_postorder = postorder(new_str,new_str.length());
				int current = calculatePostorder(new_str_postorder);
				
				System.out.println("-----------------");
				System.out.println(new_str);
				System.out.println(new_str_postorder);
				System.out.println(current);
				if(max <current)
					max = current;
				
			}
		}
		
		System.out.println(max);
		
		return;
	}
}
