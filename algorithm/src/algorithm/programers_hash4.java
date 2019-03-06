package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 
 ---------------����------------
 
 
 ��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.

���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
�帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
�帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
�뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��,
����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 */
public class programers_hash4 {
	
	public int[] solution(String[] genres, int[] plays) {
	
        HashMap<String, Integer> hm = new HashMap();
        for(int i=0; i<genres.length;i++) {
        	if(hm.containsKey(genres[i])) hm.put(genres[i], hm.get(genres[i])+plays[i]);
        	else hm.put(genres[i], plays[i]);
        }
        
        Iterator itr = hm.entrySet().iterator();
        int num=0;
        String[] genres2 = new String[100];
        int[] plays2 = new int[100];
        while(itr.hasNext()) {
        	Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)itr.next();
        	genres2[num] = e.getKey();
        	plays2[num] = e.getValue();
        	num++;
        }
        
        
        for(int i = 0; i< num-1; i++) {
        	String tempG = genres2[i];
        	int tempP = plays2[i];
        	for(int j =i+1; j<num;j++) {
        		if(tempP <plays2[j]) {
        			genres2[i] = genres2[j];
        			genres2[j] = tempG;
        			tempG = genres2[i];
        			plays2[i] = plays2[j];
        			plays2[j] = tempP;
        			tempP = plays[i];
        		}
        	}
        }
//        for(int i =0; i<num; i++) {
//        	System.out.println(genres2[i]+" "+plays2[i]);
//        }
        
        int index =0;
        int[] answer = new int[200];
        for(int i =0; i<num; i++) {
        	int v1=-1;
        	int v2=-1;
        	int index_v1=1000000000;
        	int index_v2=1000000000;
        	
        	for(int j =0; j<genres.length; j++) {
        		if(genres2[i].compareTo(genres[j])==0) {
        			if(v1 == plays[j]) {
        				v2 = plays[j];
        			    index_v2 = j;
        			}
        			else if(v1 <plays[j]) {
        				v2 = v1;
        				index_v2 = index_v1;
        				v1 = plays[j];
        				index_v1 = j;
        			}else if(v2<plays[j]) {
        				v2 = plays[j];
        				index_v2 = j;
        			}
        		}
        	}
        	
        	answer[index++]=index_v1;
        	if(v2>-1)
        		answer[index++]=index_v2;
        }
        
        
        int[] new_answer = new int[index];
        for(int i=0; i<index; i++) {
        	new_answer[i] = answer[i];
        }
        return new_answer;
    }
	public static void main(String[] args) {
		programers_hash4 T = new programers_hash4();
		
//		String[] geners = {"classic", "pop", "classic", "classic", "pop"};	
//		int[] plays = {500, 600, 150, 800, 2500};
		
		String[] geners = {"classic","pop","classic","pop","classic","classic","a","a","b","b","c","b"}; 
		int[] plays = {400,600,150,2500,500,600,6,5,3,1,10,4};
		
		for(int i :T.solution(geners,plays))
			System.out.print(i+", ");
	}
}
