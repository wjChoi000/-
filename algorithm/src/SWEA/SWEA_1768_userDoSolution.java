package SWEA;

public class SWEA_1768_userDoSolution {

	
	
	public void doUserImplementation(int[] guess) {
		SWEA_1768.Result result;
		
		while(true) {
			guess[0] =8;
			guess[1]=9;
			guess[2]=7;
			guess[3]=5;
			
			
			
			result = SWEA_1768.query(guess);
			if(result.strike==4)
				break;
		}

		
	}
}
