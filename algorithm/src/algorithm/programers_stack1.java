package algorithm;

import java.util.Stack;

public class programers_stack1 {

	static public int solution(String arrangement) {
        int answer = 0;
//my answer       
//        int s_num=0;
//        int len = arrangement.length();
//        for(int i =0; i<len; i++) {
//        	if(arrangement.charAt(i)=='(' && arrangement.charAt(i+1)==')'){//������
//            	answer +=s_num;
//            	i++;
//    		}else if(arrangement.charAt(i)=='(')//���°�ȣ
//        		s_num++;
//        	else if(arrangement.charAt(i)==')') {//�ݴ°�ȣ
//        		s_num--;
//        		answer++;
//        	}
//        }
        
        //using stack
        Stack<Integer> st = new Stack<>();
        for( int i =0; i<arrangement.length();i++) {
        	if(arrangement.charAt(i)=='(') {
        		st.push(i);//��ȣ��  �����ϰ�
        	}else if(arrangement.charAt(i)==')') {
        		if(st.peek()+1 ==i) {//�̾���  ��ȣ�̸� ������
        			st.pop();
        			answer+=st.size();
        		}else {//�̾����� ���� ��ȣ�̸� 1�߰�
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
