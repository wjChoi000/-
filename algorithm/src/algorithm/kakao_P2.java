package algorithm;
import java.util.*;
public class kakao_P2 {
	   
	    
	    public static void main(String[] str) {
	    	
	    	String S = "Forget  CVs..Save time . x x";
	    	
	    	StringTokenizer st = new StringTokenizer(S,"?|!|.");
	        while(st.hasMoreTokens()){
	        
	        	String s = st.nextToken().trim();
	        	
	        	String[] word = s.split("\\s");
	        	for(String w: word)
	        		System.out.println(w.length());
	        	
	        }
	    	
	    }
}
