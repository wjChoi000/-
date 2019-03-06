package algorithm;
/*
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.

������ : 119
���ؿ� : 97 674 223
������ : 11 9552 4421
��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��,
 � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */
public class programers_hash2 {
	
	public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        // my answer
//        for(int i = 0; i<len-1; i++) {
//        	for(int j= i+1; j<len; j++) {
//        		if( phone_book[i].length() <= phone_book[j].length())
//        			if(phone_book[i].compareTo(phone_book[j].substring(0, phone_book[i].length()))==0)
//        				return false;
//        		if( phone_book[i].length() > phone_book[j].length())
//        			if(phone_book[j].compareTo(phone_book[i].substring(0, phone_book[j].length()))==0)
//        				return false;
//        	}
//        }
        for( int i =0; i<len-1; i++) {
        	for(int j= i+1; j<len; j++) {
        		if(phone_book[i].startsWith(phone_book[j])) {return false;}
        		if(phone_book[j].startsWith(phone_book[i])) {return false;}
        	}
        }
        
        
        return true;
    }
	public static void main(String arg[]) {
		programers_hash2 T = new programers_hash2();
		
		String[][] input = {{"119", "97674223", "1195524421"},
				{"123","456","789"},
				{"12","123","1235","567","88"}};
		
		for(String[] i: input) {
			for(String ii:i) {
				System.out.print(ii+", ");
			}
			if(T.solution(i)) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
	}
}
