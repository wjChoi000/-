package algorithm;

import java.util.Scanner;

public class Problem_3019 {

		public static void main(String[] str) {
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			int[] map = new int[n+3];
			int p = scan.nextInt();
			
			for(int i =0; i<n; i++) {
				map[i] = scan.nextInt();
			}
			map[n]= -10;
			map[n+1]= -10;
			map[n+2]= -10;
			
			int output = 0;
			
			switch(p) {
				case 1:
					//----
					for(int i =0; i<n-3; i++) {
						if(map[i]==map[i+1])
							if(map[i+1]==map[i+2])
								if(map[i+2] == map[i+3])
									output++;
					}
					//-
					//-
					//-
					//-
					output += n;
					break;
				case 2:
					// --
					// --
					for(int i =0; i<n-1; i++) {
						if(map[i] == map[i+1])
							output++;
					}
					break;
				case 3:
					// ==
					//==
					for(int i =0; i<n-2; i++) {
						if(map[i] == map[i+1])
							if(map[i+1]+1 == map[i+2])
								output++;
					}
					//=
					//==
					// =
					for(int i =0; i<n-1; i++) {
							if( (map[i]-1) == map[i+1])
								output++;
					}
					break;
				case 4:
					//==
					// ==
					for(int i =0; i<n-2; i++) {
							if(map[i]-1== map[i+1])
								if(map[i+1]==map[i+2])
									output++;
						
					}
					// =
					//==
					//=
					
					for(int i =0; i<n-1; i++) {
						if( map[i]+1 == (map[i+1]))
							output++;
					}
					break;
				case 5:
					// =
					//===
					for(int i =0; i<n-2; i++) {
						if(map[i]==map[i+1])
							if(map[i+1]==map[i+2])
								output++;
					}
					
					//===
					// = 
					for(int i =0; i<n-2; i++) {
						if(map[i]==map[i+2])
							if(map[i]-1 ==map[i+1])
								output++;
					}
									
					// =
					//==
					// =
					for(int i =0; i<n-1; i++) {
						if((map[i]-1) == map[i+1])
							output++;
					}
					
					//=
					//==
					//=
					for(int i =0; i<n-1; i++) {
						if( map[i]+1 == (map[i+1]))
							output++;
					}
					
					break;
				case 6:
					//  =
					//===
					for(int i =0; i<n-2; i++) {
						if(map[i]==map[i+1])
							if(map[i+1]==map[i+2])
								output++;
					}
					//=
					//=
					//==
					
					for(int i =0; i<n-1; i++) {
						if(map[i]==map[i+1])
							output++;
					}
					
					//===
					//=
					for(int i =0; i<n-2; i++) {
						if(map[i]+1==map[i+1])
							if(map[i+1] ==map[i+2])
								output++;
					}
					//==
					// =
					// =
					for(int i =0; i<n-1; i++) {
						if(map[i]-2 ==map[i+1])
							output++;
					}
					break;
				case 7:
					//=
					//===
					for(int i =0; i<n-2; i++) {
						if(map[i]==map[i+1])
							if(map[i+1]==map[i+2])
								output++;
					}
					//==
					//=
					//=
					for(int i =0; i<n-1; i++) {
						if(map[i]+2 ==map[i+1])
							output++;
					}
					//===
					//  =
					for(int i =0; i<n-2; i++) {
						if(map[i]==map[i+1])
							if(map[i+1]-1 ==map[i+2])
								output++;
					}
					// =
					// =
					//==
					for(int i =0; i<n-1; i++) {
						if(map[i]==map[i+1])
								output++;
					}
					break;
				default:
					break;
			}
			System.out.println(output);
		}
}
