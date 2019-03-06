package algorithm;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
/*
 * �����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.

���� ��� �����̰� ���� ���� �Ʒ��� ���� ���� �����̰� ���׶� �Ȱ�, �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� �������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.

����	�̸�
��	���׶� �Ȱ�, ���� ���۶�
����	�Ķ��� Ƽ����
����	û����
�ѿ�	�� ��Ʈ

�����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */

public class programers_hash3 {
	public int solution(String[][] clothes) {
	    int answer = 1;
	    
	    HashMap<String, Integer> hm = new HashMap();
	    for(String[] cloth: clothes) {
	    	if( hm.containsKey(cloth[1]) ) hm.put(cloth[1], hm.get(cloth[1])+1);
	    	else hm.put(cloth[1],2);
	    }
	    Iterator itr = hm.entrySet().iterator();
	    while (itr.hasNext()){
	    	Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)itr.next();
	    	answer = answer * e.getValue();
	    }
	    return answer-1;
	}
	
	
	public static void main(String[] args) {
		programers_hash3 T = new programers_hash3();
		String[][][] input = {{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}},
				{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}};
	
		for(String[][] i : input) {
			System.out.println(T.solution(i));
		}
	}
}

