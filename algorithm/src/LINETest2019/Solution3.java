package LINETest2019;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution3 {
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String head = sc.nextLine();
		String[] nh = head.split(" ");
		int nHeadSize = nh.length;
		
		PriorityQueue<ID> que = new PriorityQueue<>();
		for(int i=0; i<N-1; i++) {
			
			int id= sc.nextInt();
			String[] temp = new String[3];
			for(int j=0; j<nHeadSize-1;j++) {
				temp[j] = sc.next();
			}
			
			que.add(new ID(id,temp));
			
		}
		sc.nextLine();
		int M = Integer.parseInt(sc.nextLine());
		head = sc.nextLine();
		String[] mh = head.split(" ");
		int mHeadSize = mh.length;
		
		String[][] ms = new String[M][4];
		for(int i=0; i<M-1; i++) {
			for(int j=0; j<mHeadSize; j++)
				ms[i][j] = sc.next();
		}
		
		//vaild head
		int[] mhs = new int[3];
		for(int i=1; i<mHeadSize; i++) {
				for(int j=1; j<nHeadSize; j++) {
					if(mh[i].compareTo(nh[j])==0)
						mhs[i-1] =1;
				}
			
		}
		
		//head print
		int i=0;
		for(;i<nHeadSize-1; i++)
			System.out.print(nh[i]+" ");
		System.out.print(nh[i]);
		for(i=1; i<mHeadSize; i++)
			if(mhs[i-1]==0)
				System.out.print(" "+mh[i]);
		//tuple print
		while(!que.isEmpty()) {
			System.out.println();
			ID id = que.remove();
			i=0;
			System.out.print(id.id);
			for(;i<nHeadSize-1; i++)
				System.out.print(" "+id.s[i]);
				
				
			i=0;
			for(; i<M-1; i++) {
				if(id.id == Integer.parseInt(ms[i][0]))
					break;
			}
			if(i == M-1) {
				for(int j=0; j<mHeadSize-1;j++) {
					if(mhs[j]==0)
						System.out.print(" NULL");
				}
			}
			else {
				for(int j=0; j<mHeadSize-1;j++) {
					if(mhs[j]==0)
						System.out.print(" "+ms[i][j+1]);
				}
			}
		}
		
	}
}

class ID implements Comparable<ID>{
	int id;
	String[] s;

	
	public ID(int id,String[] s) {
		this.id = id;
		this.s=s;
		
	}
	
	public int compareTo(ID t) {
		if(this.id<t.id)
			return -1;
		else
			return 1;
	}
	
}
