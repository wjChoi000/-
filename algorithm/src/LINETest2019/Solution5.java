package LINETest2019;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution5 {
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int b = sc.nextInt();
		int[] visited = new int[200001];
		int time =-1;
		int acc =1;
		
		
		boolean flag =false;
		PriorityQueue<B> que = new PriorityQueue<>();
		que.add(new B(0,b));
		
		while(true) {
			
		     int QueSize = que.size();
		     while(QueSize>0) {
		    	 B current = que.remove();
		    	 if(current.location ==c) {
		    		 flag=true;
		    		 time = current.time;
		    		 break;
		    	 }
		    	 int now = current.location-1;
		    	 if(now >=0) {
		    		 if(visited[now] <current.time+1) {
		    			 que.add(new B(current.time+1,now));
		    			 visited[now] =current.time+1;
		    		 }
		    	 }
		    	 
		    	 now = current.location+1;
		    	 if(now <=200000) {
		    		 if(visited[now] <current.time+1) {
		    			 que.add(new B(current.time+1,now));
		    			 visited[now] =current.time+1;
		    		 }		    		 
		    	 }
		    	 
		    		 
		    	 now = 2*current.location;
		    	 if(now <=200000) {
		    		 if(visited[now] <current.time+1) {
		    			 que.add(new B(current.time+1,now));
		    			 visited[now] =current.time+1;
		    		 }
		    	 }
		    	 
		    	 QueSize--;
		     }
		     
		     c += acc;
		     acc++;
		     if (c >= 200001)
		    	 break;
		     if(flag) {
		    	 break;
		     }
		}
		

		System.out.println(time);

	}
}

class B implements Comparable<B>{
	int time;
	int location;

	
	public B(int time, int location) {
		this.time = time;
		this.location=location;
		
	}
	
	public int compareTo(B t) {
		if(this.time<t.time)
			return -1;
		else
			return 1;
	}
	
}
