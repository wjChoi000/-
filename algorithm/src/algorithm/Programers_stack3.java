package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//다리를 지나는 트럭
public class Programers_stack3 {
	static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        Queue<Integer> st = new LinkedList();
		
        st.add(truck_weights[0]);
       
        int total_weight = truck_weights[0];
        int wait_car =1;
        int go_car =0;
        int[] car_time = new int[10000];
        for(int i =1;i<10000; i++)
        	car_time[i]=0;
        
        while(!st.isEmpty()) {
        	
        	for(int i= go_car; i<wait_car;i++) car_time[i]++;
        	if(car_time[go_car] == bridge_length) {
        		go_car++;
        		total_weight -= st.remove();
        	}
        	if( wait_car <truck_weights.length && total_weight+truck_weights[wait_car] <=weight ) {
        		st.add(truck_weights[wait_car]);
        		total_weight += truck_weights[wait_car];
        		wait_car++;
        		
        	}
        	
        	time++;
//        	System.out.print(" ");
        }
        
        return time;
    }
	
	public static void main(String[] str) {
		int[] bridge_length= {2,100,100};
		int[] weight = {10,100,100};
		int[][] truck_weights= {{7,4,5,6},
				{10},
				{10,10,10,10,10,10,10,10,10,10}};
		for(int i =0; i<3; i++) {
			System.out.println(solution(bridge_length[i],weight[i],truck_weights[i]));
		}
		
	}
}
