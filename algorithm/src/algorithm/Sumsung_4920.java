package algorithm;

import java.util.Scanner;

public class Sumsung_4920 {
	 public static void main(String[] str) {
		 Scanner scan = new Scanner(System.in);
		 int k =1;
		 while(true) {
			 
			 int n = scan.nextInt();
			 if(n==0) {
				 break;
			 }
			 int[][] map = new int[n][n];
			 for(int i =0; i <n; i++)
				 for(int j =0; j<n ; j++)
					 map[i][j]= scan.nextInt();
			 
			 int max_value = -100000000;
			 // ==== 1
			 for(int i =0; i<n; i++) {
				 for(int j = 0; j<n-3; j++) {
					 int value = map[i][j]+ map[i][j+1]+ map[i][j+2]+map[i][j+3];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 // = 2
			 // =
			 // =
			 // =
			 for(int i =0; i<n-3; i++) {
				 for(int j = 0; j<n; j++) {
					 int value = map[i][j]+ map[i+1][j]+ map[i+2][j]+map[i+3][j];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 // ==  3
			 //  ==
			 
			 for(int i =0; i<n-1; i++) {
				 for(int j = 0; j<n-2; j++) {
					 int value = map[i][j]+ map[i][j+1]+ map[i+1][j+1]+map[i+1][j+2];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 // ==  4
			 //==
			 
//			 for(int i =0; i<n-1; i++) {
//				 for(int j = 0; j<n-2; j++) {
//					 int value = map[i][j+1]+ map[i][j+2]+ map[i+1][j]+map[i+1][j+1];
//					 if(value>max_value)
//						 max_value = value;
//				 }
//			 }
			 
			 //=  5
			 //==
			 // =
			 
//			 for(int i =0; i<n-2; i++) {
//				 for(int j = 0; j<n-1; j++) {
//					 int value = map[i][j]+ map[i+1][j]+ map[i+1][j+1]+map[i+2][j+1];
//					 if(value>max_value)
//						 max_value = value;
//				 }
//			 }
			 
			 // = 4
			 //==
			 //=
			 for(int i =0; i<n-2; i++) {
				 for(int j = 0; j<n-1; j++) {
					 int value = map[i][j+1]+ map[i+1][j]+ map[i+1][j+1]+map[i+2][j];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 //=== 5
			 //  =
			 
			 for(int i =0; i<n-1; i++) {
				 for(int j = 0; j<n-2; j++) {
					 int value = map[i][j]+ map[i][j+1]+ map[i][j+2]+map[i+1][j+2];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 //== 6
			 //=
			 //=
			 
			 for(int i =0; i<n-2; i++) {
				 for(int j = 0; j<n-1; j++) {
					 int value = map[i][j]+ map[i][j+1]+ map[i+1][j]+map[i+2][j];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 //=   7
			 //===
			 
			 for(int i =0; i<n-1; i++) {
				 for(int j = 0; j<n-2; j++) {
					 int value = map[i][j]+ map[i+1][j]+ map[i+1][j+1]+map[i+1][j+2];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 // = 8
			 // =
			 //==
			 
			 for(int i =0; i<n-2; i++) {
				 for(int j = 0; j<n-1; j++) {
					 int value = map[i][j+1]+ map[i+1][j+1]+ map[i+2][j]+map[i+2][j+1];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 //=== 9
			 // =
			 for(int i =0; i<n-1; i++) {
				 for(int j = 0; j<n-2; j++) {
					 int value = map[i][j]+ map[i][j+1]+ map[i][j+2]+map[i+1][j+1];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 //=  10
			 //==
			 //=
			 
			 for(int i =0; i<n-2; i++) {
				 for(int j = 0; j<n-1; j++) {
					 int value = map[i][j]+ map[i+1][j]+ map[i+1][j+1]+map[i+2][j];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 // =  11
			 //===
			 
			 for(int i =0; i<n-1; i++) {
				 for(int j = 0; j<n-2; j++) {
					 int value = map[i][j+1]+ map[i+1][j]+ map[i+1][j+1]+map[i+1][j+2];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 // =  12
			 //==
			 // =
			 
			 for(int i =0; i<n-2; i++) {
				 for(int j = 0; j<n-1; j++) {
					 int value = map[i][j+1]+ map[i+1][j]+ map[i+1][j+1]+map[i+2][j+1];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 //== 13
			 //==
			 
			 for(int i =0; i<n-1; i++) {
				 for(int j = 0; j<n-1; j++) {
					 int value = map[i][j]+ map[i][j+1]+ map[i+1][j]+map[i+1][j+1];
					 if(value>max_value)
						 max_value = value;
				 }
			 }
			 
			 System.out.println(k+". "+max_value);
			 k++;
		 }
	 }
}

