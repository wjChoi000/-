package BJO;

import java.util.PriorityQueue;

public class Example {

	
	public static void main(String[] args) {
		PriorityQueue<Integer> que = new PriorityQueue<>();
	
		que.add(10);
		que.add(5);
		que.add(7);
		
		while(!que.isEmpty()) {
			Integer i = que.remove();
			System.out.println(i);
		}
	}
}
