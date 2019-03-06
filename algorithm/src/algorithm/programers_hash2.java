package algorithm;
/*
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
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
