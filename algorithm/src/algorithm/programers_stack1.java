package algorithm;

import java.util.Stack;

public class programers_stack1 {

	static public int solution(String arrangement) {
        int answer = 0;
//my answer       
//        int s_num=0;
//        int len = arrangement.length();
//        for(int i =0; i<len; i++) {
//        	if(arrangement.charAt(i)=='(' && arrangement.charAt(i+1)==')'){//레이저
//            	answer +=s_num;
//            	i++;
//    		}else if(arrangement.charAt(i)=='(')//여는괄호
//        		s_num++;
//        	else if(arrangement.charAt(i)==')') {//닫는괄호
//        		s_num--;
//        		answer++;
//        	}
//        }
        
        //using stack
        Stack<Integer> st = new Stack<>();
        for( int i =0; i<arrangement.length();i++) {
        	if(arrangement.charAt(i)=='(') {
        		st.push(i);//번호를  저장하고
        	}else if(arrangement.charAt(i)==')') {
        		if(st.peek()+1 ==i) {//이어진  번호이면 레이져
        			st.pop();
        			answer+=st.size();
        		}else {//이어지지 않은 번호이면 1추가
        			st.pop();
        			answer+=1;
        		}
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String s = "()(((()())(())()))(())";
		System.out.println(solution(s));
	}
}
